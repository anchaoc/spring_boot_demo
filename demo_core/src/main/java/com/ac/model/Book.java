package com.ac.model;

import com.ac.enums.BookTypeEnum;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

/**
 * @author anchao
 * @date 2020/2/10 19:33
 */
@Data
@ToString
@TableName("book")
public class Book{

    @TableId(value = "id", type = IdType.INPUT)
    private Long id;


    private String bookName;

    private BookTypeEnum bookType;


}
