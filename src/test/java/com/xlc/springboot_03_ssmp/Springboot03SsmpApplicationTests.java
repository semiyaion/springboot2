package com.xlc.springboot_03_ssmp;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xlc.springboot_03_ssmp.mapper.BookMapper;
import com.xlc.springboot_03_ssmp.pojo.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class Springboot03SsmpApplicationTests {
    @Autowired
    private BookMapper bookMapper;


    @Test
    void contextLoads() {
        Book book = bookMapper.selectById(1);
        System.out.println(book);
        Book book1 = new Book();
        book1.setType("玄幻");
        book1.setCost("24");
        book1.setBookname("斗罗大陆");
        bookMapper.insert(book1);
    }

    @Test
    void insert01() {
        Book book1 = new Book();
        book1.setType("玄幻");
        book1.setCost("24");
        book1.setBookname("斗罗大陆");
        bookMapper.insert(book1);

    }

    @Test
    void delete01() {
        bookMapper.deleteById(7);
    }

    @Test
    void testGetPage() {
        IPage page = new Page(1, 5);
        bookMapper.selectPage(page, null);
        List records = page.getRecords();
        System.out.println(records);//获取当前页里的所以数据
        System.out.println(page.getPages());//一共可以分为几页
        System.out.println(page.getTotal());//当前数据库一个有多少条记录

    }

    @Test
    void testGetBy() {
        QueryWrapper<Book> qw = new QueryWrapper<>();
        //条件查询
        //相当于 select *from tbl_book where bookname like '%三%';
        qw.like("bookname", "三");
        bookMapper.selectList(qw);
    }

    @Test
    void testGetBy2() {
        String name = null;
        LambdaQueryWrapper<Book> lqw = new LambdaQueryWrapper<Book>();
        lqw.like(name != null, Book::getBookname, "三");
        //如果name不为空则连接，如果为空则不连接
        //使用lambda表达式来确定，确保参数不会出错
        bookMapper.selectList(lqw);

    }

}
