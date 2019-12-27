package com.ac;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

/**
 * @author anchao
 * @date 2019/10/9 14:42
 */
public class MainTest {

    public static void main(String[] args) {
        test9();
    }



    private static void test9(){
    }

    /**
     * 解决KEY相同时问题
     */
    private static void test8(){
        UserBean userBean = new UserBean(1L, "anchao");
        UserBean userBean2 = new UserBean(4L, "haha");
        UserBean userBean3 = new UserBean(2L, "hehe");
        UserBean userBean4 = new UserBean(1L, "weihongda");
        ArrayList<UserBean> userBeanArrayList = Lists.newArrayList(userBean, userBean2, userBean3, userBean4);
        Map<Long, UserBean> collect = userBeanArrayList.stream().collect(Collectors.toMap(UserBean::getId
                ,u -> u,(v1,v2) ->v1
                , Maps::newConcurrentMap));
        System.out.println(collect);
    }


    /**
     * 实体 集合 参数值 比对
     */
    private static void test7(){
        UserBean userBean = new UserBean(1L, "anchao");
        UserBean userBean2 = new UserBean(1L, "anchao");
        userBean.setUserBeans(Arrays.asList(userBean));
        userBean2.setUserBeans(Arrays.asList(userBean2));
        System.out.println("实体比对"+userBean.equals(userBean2));
        System.out.println("集合比对"+Arrays.equals(userBean.getUserBeans().toArray(),userBean2.getUserBeans().toArray()));
    }


    private static void test6(){
        //localDate 转 date
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant());
        System.out.println(simpleDateFormat.format(date));
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


}
