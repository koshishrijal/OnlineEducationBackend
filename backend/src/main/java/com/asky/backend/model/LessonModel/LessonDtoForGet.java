package com.asky.backend.model.LessonModel;

import com.asky.backend.entity.Topic;

public class LessonDtoForGet {

    private int lessonId;

    private String lessonName;

    private String lessonDescription;

    private int lessonNumber;

    private Topic topic;

    public int getLessonId() {
        return lessonId;
    }

    public void setLessonId(int lessonId) {
        this.lessonId = lessonId;
    }

    public String getLessonName() {
        return lessonName;
    }

    public void setLessonName(String lessonName) {
        this.lessonName = lessonName;
    }

    public String getLessonDescription() {
        return lessonDescription;
    }

    public void setLessonDescription(String lessonDescription) {
        this.lessonDescription = lessonDescription;
    }

    public int getLessonNumber() {
        return lessonNumber;
    }

    public void setLessonNumber(int lessonNumber) {
        this.lessonNumber = lessonNumber;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }
}
