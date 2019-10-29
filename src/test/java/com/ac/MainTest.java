package com.ac;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author anchao
 * @date 2019/10/9 14:42
 */
public class MainTest {

    public static void main(String[] args) {
        replace();
    }


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


    public static void replace(){

    }
}
