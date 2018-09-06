package com.asky.backend.service.security;


import com.asky.backend.entity.User;
import com.asky.backend.model.UserDtoForLogin;
import com.asky.backend.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;


@Service
public class AppUserDetailService implements UserDetailsService {

    @Autowired
    private UserService userService;
    @Autowired
    private ModelMapper modelMapper;

@Autowired
private PasswordEncoder passwordEncoder;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

            User user=userService.findUserByUserName(s);

        user.setPassword(passwordEncoder.encode(user.getPassword()));
      return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),Collections.emptyList());
    }



}
