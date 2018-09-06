package com.asky.backend.service;

import com.asky.backend.entity.Content;
import com.asky.backend.repository.ContentRepository;
import com.asky.backend.service.Iservice.IContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("contentService")
public class ContentService implements IContentService {
    @Autowired
    private ContentRepository contentRepository;

    @Override
    public List<Content> getAllContent() {
        return contentRepository.findAll();
    }

    @Override
    public Content getContentById(int contentId) {
        return contentRepository.findById(contentId).get();
    }

    @Override
    public Content insertContent(Content content) {
        return contentRepository.saveAndFlush(content);
    }

    @Override
    public Content updateContent(Content content) {
        return contentRepository.saveAndFlush(content);
    }
}
