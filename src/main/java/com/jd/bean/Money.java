package com.jd.bean;

import lombok.Data;
import lombok.Generated;
import org.springframework.data.annotation.Id;

@Data
public class Money {
    @Id
    @Generated
    private int id;
    private int basic;
    private int reward;
    private int punishment;
}
