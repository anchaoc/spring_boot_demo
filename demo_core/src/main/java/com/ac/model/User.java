package com.ac.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author anchao
 */
@Data
@TableName("test_user")
public class User implements Serializable {

    @TableId(value = "id",type = IdType.AUTO)
    private Long id;

    private String name;


}
