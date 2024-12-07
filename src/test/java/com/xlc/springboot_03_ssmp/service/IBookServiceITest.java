package com.xlc.springboot_03_ssmp.service;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xlc.springboot_03_ssmp.pojo.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @Classname IBookServiceITest
 * @Description TODO
 * @Date 2024/12/6 11:07
 * @Created by cxx
 */
@SpringBootTest
public class IBookServiceITest {
    @Autowired
    private IBookService iBookService;

    @Test
    void testsleect() {
        Book byId = iBookService.getById(5);
        System.out.println(byId);
    }

    @Test
    void sleectbypage() {
        IPage<Book> page = new Page<Book>(1, 5);
        IPage<Book> page1 = iBookService.page(page, null);
        System.out.println(page1);
    }

    @Test
    void selectall() {
        List<Book> list = iBookService.list();
        System.out.println(list);
    }
}
