package com.ac.enums;

import com.google.common.collect.Maps;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Map;
import java.util.concurrent.ConcurrentMap;

/**
 * @author anchao
 * @date 2019/12/20 13:40
 */
@AllArgsConstructor
@Getter
public enum UserStatus {

    /**
     * 用户账号状态
     */
    DISABLED(1,"已禁用"),
    NORMAL(0,"正常");





    private int code;
    private String msg;



    public static Map getUserStatus(){

        UserStatus[] values = UserStatus.values();
        ConcurrentMap<Object, Object> concurrentMap = Maps.newConcurrentMap();
        for (UserStatus value : values) {
            concurrentMap.put(value.getCode(),value.getMsg());
        }

        return concurrentMap;
    }
}
