package com.ac;

import com.ac.enums.TestEnum;

/**
 * @author anchao
 * @date 2019/12/23 10:47
 */
public class TestM {

    public static void main(String[] args) {
        TestEnum.valueOf("A").get();
        TestEnum.valueOf("B").get();
    }

}
