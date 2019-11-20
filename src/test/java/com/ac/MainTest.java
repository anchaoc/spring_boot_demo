package com.ac;

import com.google.common.collect.Lists;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

/**
 * @author anchao
 * @date 2019/10/9 14:42
 */
public class MainTest {

    public static void main(String[] args) {
        test4();

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


    /**
     * 取最大
     */
    public static void test(){
        List<Integer> list = Arrays.asList(1, 2, 3);
        Optional<Integer> max = list.stream().max(Comparator.comparing(Integer::intValue));
        max.ifPresent(t ->{
            System.out.println(t);
        });
    }



    /**
     * 部分去重
     */
    private static void test4(){
        UserBean userBean = new UserBean(1L, "anchao");
        UserBean userBean2 = new UserBean(4L, "haha");
        UserBean userBean3 = new UserBean(2L, "hehe");
        UserBean userBean4 = new UserBean(1L, "weihongda");
        List<UserBean> userBeans = Arrays.asList(userBean, userBean2, userBean3, userBean4);
        TreeSet<UserBean> treeSet = userBeans.stream().collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(UserBean::getId))));

        ArrayList<UserBean> collect = userBeans.stream().collect(Collectors.collectingAndThen(Collectors.
                toCollection(() -> new TreeSet<>(Comparator.comparing(UserBean::getId))), Lists::newArrayList));

        System.out.println(treeSet);
        System.out.println(collect);
        System.out.println(userBean);
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
