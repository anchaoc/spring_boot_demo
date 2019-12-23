package com.ac.enums;

/**
 * @author anchao
 * @date 2019/12/23 10:45
 */
public enum TestEnum implements  TestEnumInterface{

    /**
     *
     */


    A{
        @Override
        public String get() {
            System.out.println("A..");
            return "A1";
        }
    },


    B{
        @Override
        public String get() {
            System.out.println("B..");
            return "B1";
        }
    }
}
