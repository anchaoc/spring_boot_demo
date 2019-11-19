package com.ac.model;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

/**
 * @author anchao
 */
@Data
public class User {

    @Excel(name = "ID")
    private Long id;

    @Excel(name = "名称")
    private String name;


}
