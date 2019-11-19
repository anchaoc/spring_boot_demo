package com.ac;

import com.google.common.collect.Lists;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author anchao
 * @date 2019/10/9 14:42
 */
public class MainTest {

    /**
     * 并发保证原子性
     */
    private static void testAtomic(){
        AtomicReference<Integer> one = new AtomicReference<>(1);
        Integer oneGet = one.get();
        one.compareAndSet(oneGet,2);
        System.out.println(one.get());
    }


    public static void test(){
        List<Integer> list = Arrays.asList(1, 2, 3);
        Optional<Integer> max = list.stream().max(Comparator.comparing(Integer::intValue));
        max.ifPresent(t ->{
            System.out.println(t);
        });
    }





    public static void main(String[] args) {

        System.out.println(testReturn());

    }



    private static Integer testReturn(){
        Integer[] integerArr = {1,2,3,4,5,6,null,null,7,8};

        for (Integer integer : integerArr) {

            if(integer==null){
                return 999;
            }

        }

        return 1;
    }

}
