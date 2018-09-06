package com.asky.backend.service.Iservice;

import com.asky.backend.entity.Content;

import java.util.List;

public interface IContentService {

    public List<Content> getAllContent();

    public Content getContentById(int contentId);

    public Content insertContent(Content content);

    public Content updateContent(Content content);
}
