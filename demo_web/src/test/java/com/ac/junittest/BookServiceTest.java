package com.ac.junittest;

import com.ac.WebApplication;
import com.ac.model.Book;
import com.ac.service.BookService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.google.common.collect.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;

/**
 * @author anchao
 * @date 2020/2/20 11:17
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,classes = WebApplication.class)
public class BookServiceTest {

    @Resource
    private BookService bookService;

    @Test
    public void test(){

        ArrayList<Book> books = Lists.newArrayList();

        long idInit;

        LambdaQueryWrapper<Book> lambdaQuery = Wrappers.lambdaQuery();
        lambdaQuery.orderByDesc(Book::getId);
        lambdaQuery.last("limit 1");


        Book one = bookService.getOne(lambdaQuery);
        Book book = new Book();

        idInit =one.getId()+1;
        book.setId(idInit);
        book.setBookName("哈哈书1");

        Book book2 = new Book();
        idInit +=1;
        book2.setId(idInit);
        book2.setBookName("哈哈书2");

        Book book3 = new Book();
        idInit +=1;
        book3.setId(idInit);
        book3.setBookName("哈哈书3");


        Book book4 = new Book();
        idInit +=1;
        book4.setId(idInit);
        book4.setBookName("哈哈书4");



        books.add(book);
        books.add(book2);
        books.add(book3);
        books.add(book4);



        bookService.saveBatch(books);

        System.out.println(books);
    }
}
