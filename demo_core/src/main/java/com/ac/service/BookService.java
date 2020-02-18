package com.ac.service;

import com.ac.model.Book;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author anchao
 * @since 2020-02-17
 */
public interface BookService extends IService<Book> {

    List<Book> listEnum();
}
