package com.ac.model;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

/**
 * @author anchao
 */
@Data
public class User {

    @Excel(name = "ID",orderNum = "1")
    private Long id;

    @Excel(name = "名称",orderNum = "2",width = 20)
    private String name;


}
