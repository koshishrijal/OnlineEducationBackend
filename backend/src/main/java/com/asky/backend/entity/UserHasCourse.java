package com.asky.backend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="tbl_user_has_course")
public class UserHasCourse implements Serializable {
    @Column(name="user_has_course_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userHasCourseId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;

    @ManyToOne
    @JoinColumn(name="course_id")
    @JsonBackReference
    private Course course;

    @Column(name="added_date",insertable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date addedDate;

    @Column(name="course_completed")
    private boolean courseCompleted;


    public boolean isCourseCompleted() {
        return courseCompleted;
    }

    public void setCourseCompleted(boolean courseCompleted) {
        this.courseCompleted = courseCompleted;
    }

    public int getUserHasCourseId() {
        return userHasCourseId;
    }

    public void setUserHasCourseId(int userHasCourseId) {
        this.userHasCourseId = userHasCourseId;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
