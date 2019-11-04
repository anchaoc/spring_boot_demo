package com.ac;

import lombok.Builder;
import lombok.Data;

/**
 * @author anchao
 * @date 2019/11/3 20:26
 */
@Data
@Builder
public class UserBean {
    private Long id;
    private String name;

}
