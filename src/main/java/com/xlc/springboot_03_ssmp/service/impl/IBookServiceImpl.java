package com.xlc.springboot_03_ssmp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xlc.springboot_03_ssmp.mapper.BookMapper;
import com.xlc.springboot_03_ssmp.pojo.Book;
import com.xlc.springboot_03_ssmp.service.IBookService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Classname IBookServiceImpl
 * @Description TODO
 * @Date 2024/12/6 11:06
 * @Created by cxx
 */
@Service
public class IBookServiceImpl extends ServiceImpl<BookMapper, Book> implements IBookService {
    @Autowired
    private BookMapper mapper;

    @Override
    public Boolean modify(Book book) {
        return mapper.updateById(book) > 0;
    }

    @Override
    public Boolean delete(Integer id) {
        return mapper.deleteById(id) > 0;
    }

    @Override
    public IPage<Book> getpage(Integer currentPage, Integer pageSize) {
        Page<Book> bookPage = new Page(currentPage, pageSize);
        mapper.selectPage(bookPage, null);
        return bookPage;
    }

    @Override
    public Boolean savebook(Book book) {
        return mapper.insert(book) > 0;
    }

    @Override
    public IPage<Book> getby(Integer currentPage, Integer pageSize, Book book) {
        LambdaQueryWrapper<Book> lqw = new LambdaQueryWrapper<>();
        lqw.like(Strings.isNotEmpty(book.getType()), Book::getType, book.getType());
        lqw.like(Strings.isNotEmpty(book.getBookname()), Book::getBookname, book.getBookname());
        lqw.like(Strings.isNotEmpty(book.getCost()), Book::getCost, book.getCost());
        Page page = new Page(currentPage, pageSize);
        mapper.selectPage(page, lqw);
        return page;
    }
}
