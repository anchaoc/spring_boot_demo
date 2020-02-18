package com.ac.dao;

import com.ac.model.Book;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author anchao
 * @since 2020-02-17
 */
public interface BookMapper extends BaseMapper<Book> {

    List<Book> listEnum();
}
