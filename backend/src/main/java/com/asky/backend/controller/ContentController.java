package com.asky.backend.controller;


import com.asky.backend.entity.Content;
import com.asky.backend.model.ContentModel.ContentDtoForGet;
import com.asky.backend.model.ContentModel.ContentDtoForInsert;
import com.asky.backend.service.ContentService;
import com.asky.backend.util.PersonalModelMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping(value = "api/contents")
public class ContentController {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ContentService contentService;

    @GetMapping(value="")
    public ResponseEntity<?> getAllContents(){
        List<Content> contentList=contentService.getAllContent();
        List<ContentDtoForGet> contentDtoForGetList=PersonalModelMapper.mapListEntityToListDtos(contentList,ContentDtoForGet.class);
        return ResponseEntity.ok(contentDtoForGetList);
    }


    @GetMapping(value="/{contentId}")
    public ResponseEntity<?> getContentById(@PathVariable int contentId){
        String errorMessage="";
        ContentDtoForGet content=modelMapper.map(contentService.getContentById(contentId),ContentDtoForGet.class);
        if(content==null){
            errorMessage="content not found for the requested id";
            return ResponseEntity.badRequest().body(errorMessage);
        }
        return ResponseEntity.ok(content);
    }

    @PostMapping(value="/content")
    public ResponseEntity<?> insertContent(@RequestBody ContentDtoForInsert contentDtoForInsert, Errors errors){
        String errorMessage="";
        if(errors.hasErrors()){
           errorMessage=errors.getAllErrors().stream().map(error->error.getDefaultMessage()).collect(Collectors.joining(","));
            return ResponseEntity.badRequest().body(errorMessage);
        }
     Content content= contentService.insertContent(modelMapper.map(contentDtoForInsert,Content.class));
        URI uri=URI.create("/api/contents/content/"+ content.getContentId());
        return ResponseEntity.created(uri).build();
    }

   @GetMapping(value = "pdfs/{path}")
    public ResponseEntity<ByteArrayResource> getFileByPath(@PathVariable("path") String fileName){

        Path path= Paths.get("E:\\Major\\backend\\src\\main\\resources\\static\\"+fileName);
        ByteArrayResource pdfByteArrayResource=null;
        try {
             pdfByteArrayResource=new ByteArrayResource(Files.readAllBytes(path));

        } catch (IOException e) {
            e.printStackTrace();
        }
      return  ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION)
           //   .contentType(MediaType.APPLICATION_PDF)
               .contentType(MediaType.parseMediaType("application/octet-stream"))
                .body(pdfByteArrayResource);
    }

    @GetMapping(value="/videos")
    public ResponseEntity<ByteArrayResource> getVideoByPath(){
       Path path=Paths.get("E:\\Major\\backend\\src\\main\\resources\\static\\videos\\sample.mp4");
       ByteArrayResource videoArrayResource=null;
        try {
            videoArrayResource=new ByteArrayResource(Files.readAllBytes(path));

        } catch (IOException e) {
            e.printStackTrace();
        }
    return ResponseEntity.ok()
            .header("Content-Disposition","attachment;filename=sample.mp4")
            .contentType((MediaType.APPLICATION_OCTET_STREAM))
            .body(videoArrayResource);

    }

}
