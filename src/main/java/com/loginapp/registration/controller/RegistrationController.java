package com.loginapp.registration.controller;

import com.loginapp.registration.model.User;
import com.loginapp.registration.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController // the difference b/n controller and restcontroller is that restcontroller is used to return json data
@CrossOrigin(origins = "http://localhost:4200")
public class RegistrationController {

  @Autowired

  private RegistrationService service;

  @PostMapping("/asme") // this is the url that will be used to access this method (for register user)! this is the url

  @CrossOrigin(origins = "http://localhost:4200")
  // that will be used to access this method (for register user)!

  public User registerUser(@RequestBody User user) throws Exception {
    String tempEmailId = user.getEmailId(); // this is the email id that the user enters
    if (tempEmailId != null && !"".equals(tempEmailId)) {
      User userObj = service.fetchUserByEmailId(tempEmailId);
      if (userObj != null) {
        throw new RuntimeException("User with" + tempEmailId + "this email already exists"); // this is the error message that will be displayed if the email id already exists
      }
    }

    User userObj = null;
    userObj = service.saveUser(user);
    return userObj;

  }

  @PostMapping ("/login") // this is the url that will be used to access this method (for login user)
  public User loginUser(@RequestBody User user) throws Exception {   // this is the url that will be used to access this method (for login user)!
    String tempEmailId = user.getEmailId();
    String tempPass = user.getPassword();
    User userObj = null;
    if (tempEmailId != null && tempPass != null) {
     userObj= service.fetchUserByEmailIdAndPassword(tempEmailId, tempPass);
    }
    if (userObj == null) {
      throw new RuntimeException("Bad credentials");
    }

    return userObj;

    }
    }




