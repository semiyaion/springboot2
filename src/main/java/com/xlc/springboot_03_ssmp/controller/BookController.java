package com.xlc.springboot_03_ssmp.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xlc.springboot_03_ssmp.controller.until.R;
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
@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    IBookService iBookService;

    @GetMapping
    public R getAll() {
        return new R(true, iBookService.list());
    }

    @PostMapping
    public R insertBook(@RequestBody Book book) {
        return new R(iBookService.savebook(book));
    }

    @PutMapping
    public R updateBook(@RequestBody Book book) {
        return new R(iBookService.modify(book));
    }

    @DeleteMapping("{id}")
    public R deledte(@PathVariable Integer id) {
        return new R(iBookService.delete(id));
    }

    @GetMapping("{id}")
    public R getByid(@PathVariable Integer id) {
        return new R(true, iBookService.getById(id));
    }

    //    @GetMapping("{page}/{pagesize}")
//    public R bypage(@PathVariable Integer page ,@PathVariable Integer pagesize){
//        IPage<Book> iPage = iBookService.getpage(page, pagesize);
//        //如果当前页码值大于总页码值，那么重新执行查询操作，使用最大页码值作为当前页码值
//        if(page>iPage.getPages()){
//            IPage<Book> iPage1 = iBookService.getpage((int) iPage.getPages(), pagesize);
//        }
//        return new R(true,iBookService.getpage(page,pagesize));
//    }
    @GetMapping("{currentPage}/{pageSize}")
    public R getPage(@PathVariable int currentPage, @PathVariable int pageSize, Book book) {
//        System.out.println("参数==>"+book);

        IPage<Book> page = iBookService.getby(currentPage, pageSize, book);
        //如果当前页码值大于了总页码值，那么重新执行查询操作，使用最大页码值作为当前页码值
        if (currentPage > page.getPages()) {
            page = iBookService.getby((int) page.getPages(), pageSize, book);
        }
        return new R(true, page);
    }


}
