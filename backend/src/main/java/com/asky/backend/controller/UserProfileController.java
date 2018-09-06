package com.asky.backend.controller;

import com.asky.backend.model.UserModel.UserDtoForProfileView;
import com.asky.backend.service.UserHasCourseService;
import com.asky.backend.service.UserService;
import com.asky.backend.util.PersonalModelMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value="/api/userProfiles")
public class UserProfileController {
    @Autowired
    private UserHasCourseService userHasCourseService;
    @Autowired
    private UserService userService;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping()
    public ResponseEntity<?> getAllUserProfiles(){
        List<UserDtoForProfileView> userDtoForProfileViewList=
        PersonalModelMapper.mapListEntityToListDtos(userService.getAllUsers(),UserDtoForProfileView.class);
        List<UserDtoForProfileView> userDtoForProfileViewListFinal=new ArrayList<>();
        userDtoForProfileViewList.stream().forEach(u->{
            u.setAdditionalFields(userHasCourseService);
            userDtoForProfileViewListFinal.add(u);
        });

      return  ResponseEntity.ok().body(userDtoForProfileViewListFinal);


    }
    @GetMapping("/{userId}")
    public ResponseEntity<?> getUserProfileById(@PathVariable("userId") int userId){
        UserDtoForProfileView userDtoForProfileView=modelMapper.map(userService.getUserByUserId(userId),UserDtoForProfileView.class);
        userDtoForProfileView.setAdditionalFields(userHasCourseService);
        return ResponseEntity.ok().body(userDtoForProfileView);
    }

}
