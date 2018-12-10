package com.jd.bean;

import lombok.Data;
import lombok.Generated;
import org.springframework.data.annotation.Id;


@Data
public class User {
    @Id
    @Generated
    private int id;
    private String name;
    private int age;
    private double money;

}
