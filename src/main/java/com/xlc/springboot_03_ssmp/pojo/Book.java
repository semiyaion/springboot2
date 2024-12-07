package com.xlc.springboot_03_ssmp.pojo;

import lombok.Data;

/**
 * @Classname Book
 * @Description TODO
 * @Date 2024/12/5 23:52
 * @Created by cxx
 */
@Data
public class Book {
    private Integer id;
    private String type;
    private String bookname;
    private String cost;
}
