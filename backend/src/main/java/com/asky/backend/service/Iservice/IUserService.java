package com.asky.backend.service.Iservice;

import com.asky.backend.entity.User;
import com.asky.backend.model.UserDtoForGet;
import com.asky.backend.repository.UserRepository;

import java.util.List;


public interface IUserService{
    public List<User> getAllUsers();
    public User getUserByUserId(int id);
    public void deleteUserByUserId(int id);
    public User insertUser(User user);
    public User updateUser(User user);
    public boolean isUserExists(int userId);
    public User findUserByUserNameAndPassword(String username,String password);
    public User findUserByUserName(String username);


}
