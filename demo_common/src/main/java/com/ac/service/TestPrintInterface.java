package com.ac.service;

import com.ac.other.PrintInterface;

/**
 * @author anchao
 * @date 2020/1/19 15:02
 */
public class TestPrintInterface {


    public static void print(PrintInterface printInterface,int a,int b){
        System.out.println(printInterface.sum(a, b));
    }



    public static void main(String[] args) {
        print((a,b)-> a+b,1,2);

    }
}
