package com.asky.backend.controller;

import com.asky.backend.entity.Course;
import com.asky.backend.entity.User;
import com.asky.backend.entity.UserHasCourse;
import com.asky.backend.model.CourseModel.CourseDtoForGet;
import com.asky.backend.model.UserDtoForGet;
import com.asky.backend.model.UserDtoForInsert;
import com.asky.backend.model.UserDtoForLogin;
import com.asky.backend.service.EnrollService;
import com.asky.backend.service.UserHasCourseService;
import com.asky.backend.service.UserService;
import com.asky.backend.util.PersonalModelMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.JsonPath;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/users")
public class UserController {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserService userService;
    @Autowired
    private EnrollService enrollService;
    @Autowired
    private UserHasCourseService userHasCourseService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getAllUsers() {
      //  String message="";

        List<User> userList = userService.getAllUsers();
        if (userList == null) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
       // PersonalModelMapper pmm=new PersonalModelMapper();
       List<UserDtoForGet> userDtoForGetList=new ArrayList<>();
        PersonalModelMapper.mapListEntityToListDtos(userList,UserDtoForGet.class).forEach((UserDtoForGet userDtoForGet)->{
         userDtoForGet.setCourseList(addCourseListToUserDto(userDtoForGet.getUserId()));
         userDtoForGetList.add(userDtoForGet);
       });
            return ResponseEntity.ok().body(userDtoForGetList);
       // return new ResponseEntity<List<UserDtoForGet>>(userDtoForGetList, HttpStatus.OK);
    }
    @GetMapping("/user/{userId}")
    public ResponseEntity<?> getUserById(@PathVariable("userId") int userId){
        User user=userService.getUserByUserId(userId);
        UserDtoForGet userDtoForGet=modelMapper.map(user,UserDtoForGet.class);
        userDtoForGet.setCourseList(addCourseListToUserDto(userDtoForGet.getUserId()));
        String errorMessage="";
        if(user==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(user);

    }
    @GetMapping("/{username}")
    public ResponseEntity<?> getUserByUsername(@PathVariable("username") String username){
        User user=userService.findUserByUserName(username);
        UserDtoForGet userDtoForGet=modelMapper.map(user,UserDtoForGet.class);
        userDtoForGet.setCourseList(addCourseListToUserDto(userDtoForGet.getUserId()));
        String errorMessage="";
        if(user==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(user);

    }
//this method inserts students only
    @PostMapping("/students/student")
    public ResponseEntity<?> insertUser(@Valid @RequestBody UserDtoForInsert user, Errors errors) {
        String errorMessage="";

        if(errors.hasErrors()){
          errorMessage=collectAndFlattenAllErrorMessages(errors);
            return ResponseEntity.badRequest().body(errorMessage);
        }
        user.setRole("student");
      User userCreated=userService.insertUser(modelMapper.map(user,User.class));
       // String uriLocationOfCreatedObject="/api/users/"+userCreated.getUserId();
        URI location= URI.create("/api/users/students"+userCreated.getUserId());
      return  ResponseEntity.created(location).build();

    }

    @PutMapping()
    public ResponseEntity<?> updateFullUser(@Valid @RequestBody User user,Errors errors){
        String errorMessage="";
        if(errors.hasErrors()){
            errorMessage=collectAndFlattenAllErrorMessages(errors);
            return ResponseEntity.badRequest().body(errorMessage);
        }
        userService.updateUser(user);
        return ResponseEntity.noContent().build();

    }
    @DeleteMapping("/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable("userId") int userId){
        String errorMessage="";
       if(!userService.isUserExists(userId)){
           return ResponseEntity.notFound().build();
       }
       userService.deleteUserByUserId(userId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{userId}/enroll/{courseId}")
    public ResponseEntity<?> enroll(@PathVariable("userId") int userId,@PathVariable("courseId") int courseId){
        String errorMessage="";
        UserDtoForGet userDtoForGet=modelMapper.map(enrollService.enrollUser(userId,courseId),UserDtoForGet.class);
        if(userDtoForGet==null){
            errorMessage="error occured while processing your request";
            return ResponseEntity.status(500).body(errorMessage);
        }
        return  ResponseEntity.ok().build();
    }

    //returns courseList for a user with user id
    private List<CourseDtoForGet> addCourseListToUserDto(int userId){
       return PersonalModelMapper.mapListEntityToListDtos(userHasCourseService.getListofCourseEnrolledByUserId(userId),CourseDtoForGet.class);

    }

//    @PatchMapping("/{userId}")
//    public ResponseEntity<?> partialUpdateUser( @RequestBody User user,@PathVariable("userId") int userId){
//        User userForUpdate=userService.getUserByUserId(userId);
//
//      return null;
//    }



//provide which list to be changed as first parameter
    //provide the type required for the output list ie class as second parameter


        private String collectAndFlattenAllErrorMessages(Errors errors){
          return   errors.getAllErrors().stream().map(error->error.getDefaultMessage()).collect(Collectors.joining(","));
        }
}
