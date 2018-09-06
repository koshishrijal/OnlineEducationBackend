package com.asky.backend.model.ContentModel;

public class ContentDtoForGet {
    private int contentId;

    private String contentName;

    private String contentDescription;

    private String contentPdfLink;

    private String contentVdoLink;

    public int getContentId() {
        return contentId;
    }

    public void setContentId(int contentId) {
        this.contentId = contentId;
    }

    public String getContentName() {
        return contentName;
    }

    public void setContentName(String contentName) {
        this.contentName = contentName;
    }

    public String getContentDescription() {
        return contentDescription;
    }

    public void setContentDescription(String contentDescription) {
        this.contentDescription = contentDescription;
    }

    public String getContentPdfLink() {
        return contentPdfLink;
    }

    public void setContentPdfLink(String contentPdfLink) {
        this.contentPdfLink = contentPdfLink;
    }

    public String getContentVdoLink() {
        return contentVdoLink;
    }

    public void setContentVdoLink(String contentVdoLink) {
        this.contentVdoLink = contentVdoLink;
    }
}
