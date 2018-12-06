package com.jd.demo;


import lombok.Data;
import org.springframework.data.annotation.Id;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


//jap（注解表示Java持久层）实体
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //id属性增加了两个注解，这个字段是唯一实体标识，并且这个字段是自动生成的
    private Long id;
    private String Reader;
    private String isbn;
    private String tittle;
    private String author;
    private String description;

}
