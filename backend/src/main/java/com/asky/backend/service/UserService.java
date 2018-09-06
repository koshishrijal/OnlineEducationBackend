package com.asky.backend.service;

import com.asky.backend.entity.User;
import com.asky.backend.model.UserDtoForGet;
import com.asky.backend.repository.UserRepository;
import com.asky.backend.service.Iservice.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
      return  userRepository.findAll();

    }

    @Override
    public User getUserByUserId(int id) {

        return userRepository.findOneUserByUserId(id);
    }

    @Override
    public void deleteUserByUserId(int id) {
        //userRepository.findOne();

        userRepository.delete(userRepository.getOne(id));
      //  userRepository.flush();
    }

    @Override
    public User insertUser(User user) {

        return userRepository.saveAndFlush(user);
    }

    @Override
    public User updateUser(User user)
    {
        return userRepository.saveAndFlush(user);
    }

    @Override
    public boolean isUserExists(int userId) {
        return userRepository.existsById(userId);
    }

    @Override
    public User findUserByUserNameAndPassword(String  username,String password) {

       return userRepository.findUserByUserNameAndPassword(username,password);
    }

    @Override
    public User findUserByUserName(String username) {
        return userRepository.findUserByUserName(username);
    }
}
