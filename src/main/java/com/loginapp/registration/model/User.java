package com.loginapp.registration.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter

@Entity
@Table(name = "asmex")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(name = "emailId")
  private String emailId;

  @Column(name = "userName")
  private String userName;

  @Column(name = "password")
  private String password;



}
