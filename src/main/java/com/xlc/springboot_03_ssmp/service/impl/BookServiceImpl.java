package com.xlc.springboot_03_ssmp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xlc.springboot_03_ssmp.mapper.BookMapper;
import com.xlc.springboot_03_ssmp.pojo.Book;
import com.xlc.springboot_03_ssmp.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Classname BookServiceImpl
 * @Description TODO
 * @Date 2024/12/6 10:40
 * @Created by cxx
 */
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookMapper bookMapper;

    @Override
    public Boolean save(Book book) {
        return bookMapper.insert(book) > 0;
    }

    @Override
    public Boolean update(Book book) {
        return bookMapper.insert(book) > 0;
    }

    @Override
    public Boolean delete(Integer id) {
        return bookMapper.deleteById(id) > 0;
    }

    @Override
    public Book getbyID(Integer id) {
        return bookMapper.selectById(id);
    }

    @Override
    public List<Book> getAll() {
        return bookMapper.selectList(null);
    }

    @Override
    public IPage<Book> getPage(Integer currentPage, Integer pageSize) {
        IPage<Book> page = new Page<Book>(currentPage, pageSize);
        return bookMapper.selectPage(page, null);
    }

    @Override
    public LambdaQueryWrapper<Book> selbylamname(String name) {
        LambdaQueryWrapper<Book> bookLambdaQueryWrapper = new LambdaQueryWrapper<>();
        LambdaQueryWrapper<Book> like = bookLambdaQueryWrapper.like(Book::getBookname, name);
        return like;
    }
}
