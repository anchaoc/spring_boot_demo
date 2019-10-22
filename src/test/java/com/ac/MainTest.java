package com.ac;

import com.ac.utils.GsonUtil;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author anchao
 * @date 2019/10/9 14:42
 */
public class MainTest {

    public static void main(String[] args) {
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

}
