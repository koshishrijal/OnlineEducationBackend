package com.asky.backend.repository;

import com.asky.backend.entity.UserHasCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userHasCourseRepository")
public interface UserHasCourseRepository extends JpaRepository<UserHasCourse,Integer> {

    //query ko barema ramro sanga padhera matrae lekhnu
    //@Query("Select * From UserHasCourse u Where u.user.userId:userId")
   // public List<UserHasCourse>  getUserHasCourseListByUserId(int userId);
}
