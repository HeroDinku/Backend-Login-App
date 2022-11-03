package com.loginapp.registration.repo;


import com.loginapp.registration.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationRepository extends JpaRepository<User, Long> {


 public User findByEmailId(String email);// this method is used to check if the email id already exists in the database

 public  User findByEmailIdAndPassword(String email, String password);

}
