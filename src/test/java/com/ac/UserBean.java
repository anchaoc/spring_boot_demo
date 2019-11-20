package com.ac;

import lombok.Builder;
import lombok.Data;

/**
 * @author anchao
 * @date 2019/11/3 20:26
 */
@Data
public class UserBean {
    private Long id;
    private String name;
    private boolean flag;

    public UserBean(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
