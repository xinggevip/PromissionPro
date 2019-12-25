package com.qiangssvip.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter@Setter@ToString
public class Employee {
    private Long id;

    private String username;

    private Date inputtime;

    private String tel;

    private String email;

    private Boolean state;

    private Boolean admin;

    private Long depId;

    private String password;

}