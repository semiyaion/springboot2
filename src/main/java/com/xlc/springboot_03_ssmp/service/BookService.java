package com.xlc.springboot_03_ssmp.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xlc.springboot_03_ssmp.pojo.Book;

import java.util.List;

/**
 * @Classname BookService
 * @Description TODO
 * @Date 2024/12/6 10:37
 * @Created by cxx
 */
public interface BookService {
    Boolean save(Book book);

    Boolean update(Book book);

    Boolean delete(Integer id);

    Book getbyID(Integer id);

    List<Book> getAll();

    IPage<Book> getPage(Integer currentPage, Integer pageSize);

    LambdaQueryWrapper<Book> selbylamname(String name);


}
