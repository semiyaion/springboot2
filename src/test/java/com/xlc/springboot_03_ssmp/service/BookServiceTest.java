package com.xlc.springboot_03_ssmp.service;

import com.xlc.springboot_03_ssmp.pojo.Book;
import com.xlc.springboot_03_ssmp.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Classname BookServiceTest
 * @Description TODO
 * @Date 2024/12/6 10:44
 * @Created by cxx
 */
@SpringBootTest
public class BookServiceTest {
    @Autowired
    private BookService bookService;

    @Test
    void testgetbyid() {
        Book book = bookService.getbyID(4);
        System.out.println(book);
    }

    @Test
    void testinsert() {
        Book book = new Book();
        book.setBookname("败犬女主太多了");
        book.setCost("24");
        book.setType("青春恋爱");
        bookService.update(book);
    }

    @Test
    void selectpage() {
        bookService.getPage(1, 5);
    }
}
