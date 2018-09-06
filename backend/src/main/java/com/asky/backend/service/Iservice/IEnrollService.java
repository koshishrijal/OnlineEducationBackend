package com.asky.backend.service.Iservice;

import com.asky.backend.entity.User;
import org.springframework.stereotype.Service;


public interface IEnrollService {

    public User enrollUser(int userId,int courseId);
}
