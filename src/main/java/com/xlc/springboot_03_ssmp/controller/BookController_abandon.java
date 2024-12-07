package com.xlc.springboot_03_ssmp.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xlc.springboot_03_ssmp.pojo.Book;
import com.xlc.springboot_03_ssmp.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Classname BookController
 * @Description TODO
 * @Date 2024/12/6 14:29
 * @Created by cxx
 */
//@RestController
//@RequestMapping("books")
public class BookController_abandon {

    @Autowired
    IBookService iBookService;

    @GetMapping
    public List<Book> getAll() {
        return iBookService.list();
    }

    @PostMapping
    public Boolean insertBook(@RequestBody Book book) {
        return iBookService.save(book);
    }

    @PutMapping
    public Boolean updateBook(@RequestBody Book book) {
        return iBookService.modify(book);
    }

    @DeleteMapping("{id}")
    public Boolean deldte(@PathVariable Integer id) {
        return iBookService.removeById(id);
    }

    @GetMapping("{id}")
    public Book getByid(@PathVariable Integer id) {
        return iBookService.getById(id);
    }

    @GetMapping("{page}/{pagesize}")
    public IPage<Book> bypage(@PathVariable Integer page, @PathVariable Integer pagesize) {
        return iBookService.getpage(page, pagesize);
    }


}
