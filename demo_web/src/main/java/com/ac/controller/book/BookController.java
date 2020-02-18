package com.ac.controller.book;


import com.ac.model.Book;
import com.ac.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author anchao
 * @since 2020-02-17
 */
@Controller
@RequestMapping("/demo/book")
public class BookController {

    @Resource
    private BookService bookService;


    @GetMapping("list")
    @ResponseBody
    public List list(){
        List<Book> list = bookService.listEnum();
        System.out.println(list);
        return list;
    }

}
