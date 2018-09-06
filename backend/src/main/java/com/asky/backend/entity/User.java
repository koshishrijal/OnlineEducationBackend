package com.asky.backend.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.CollectionId;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="tbl_user")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User implements Serializable{

    @Column(name="role")
    private String role;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private int userId;
    @Column(name="user_name")
    private String username;
    @Column(name="email")
    private String email;
    @Column(name="password")
    private String password;

    @Column(name="added_date",insertable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date addedDate;

    @Column(name="modified_date",nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    @JsonBackReference
    private List<UserHasCourse> userHasCourseList;

    public List<UserHasCourse> getUserHasCourseList() {
        return userHasCourseList;
    }

    public void setUserHasCourseList(List<UserHasCourse> userHasCourseList) {
        this.userHasCourseList = userHasCourseList;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    //implementations

    @Override
    public String toString() {
        return "User [id=" + userId + ", username=" + username + ", password=" + password +
                ",]";
    }





}
