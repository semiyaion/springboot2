package com.xlc.springboot_03_ssmp.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xlc.springboot_03_ssmp.pojo.Book;

/**
 * @Classname IBookService
 * @Description TODO
 * @Date 2024/12/6 11:03
 * @Created by cxx
 */
public interface IBookService extends IService<Book> {
    Boolean modify(Book book);

    Boolean delete(Integer id);

    IPage<Book> getpage(Integer currentPage, Integer pageSize);

    Boolean savebook(Book book);

    IPage<Book> getby(Integer currentPage, Integer pageSize, Book book);
}
