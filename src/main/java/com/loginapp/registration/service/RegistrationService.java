package com.loginapp.registration.service;

import com.loginapp.registration.model.User;
import com.loginapp.registration.repo.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

  @Autowired
  private RegistrationRepository repo;

  public User saveUser( User user) {
    return repo.save(user);

  }
  public User fetchUserByEmailId(String email) {  // this method is used to check if the email id already exists in the database
    return repo.findByEmailId(email);
  }

  public User fetchUserByEmailIdAndPassword(String email, String password) {
    return repo.findByEmailIdAndPassword(email, password);

  }
}

