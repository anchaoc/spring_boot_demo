package com.ac.service.impl;

import com.ac.dao.BookMapper;
import com.ac.model.Book;
import com.ac.service.BookService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author anchao
 * @since 2020-02-17
 */
@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements BookService {

    @Resource
    private BookMapper bookMapper;

    @Override
    public List<Book> listEnum() {
        Book book = (Book)this.one(Book.class);
        return bookMapper.listEnum();
    }


    private Object one(Class<?> c){
        try {
            QueryWrapper objectQueryWrapper = new QueryWrapper<>();
            objectQueryWrapper.orderByDesc("id");
            return this.getOne(objectQueryWrapper);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
