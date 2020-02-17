package com.ac.maintest;

import com.google.common.collect.Maps;

import java.util.*;

/**
 * @author anchao
 * @date 2020/2/12 17:11
 */
public class MainTest {

    public static void main(String[] args) {
        // tochar();
        //testCollections();
        //testCollections2();
    }

    /**
     * 集合 ： 置换 洗牌
     */
    private static void testCollections2() {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        Collections.shuffle(integers);
        System.out.println(integers.subList(0,3));
    }


    /**
     * 集合排序
     */
    private static void testCollections() {
        List<String> stringList = Arrays.asList("zhilei", "weihongda", "liuli", "daling","anchao");
        stringList.sort(Comparator.naturalOrder());
       // Collections.sort(stringList,Comparator.naturalOrder());
        System.out.println(stringList);

    }


    /**
     * 统计字符出现次数并去重
     */
    private static void tochar() {
        String str = "vdaxswijgrepmsfmpfkgdsvbnfigefasnlnsangonsodfpgrdnNVXZKckndgiegpawfsfnskgn";
        char[] chars = str.toCharArray();
        TreeMap<Character, Integer> treeMap = Maps.newTreeMap();

        for (char c : chars) {
            //忽略大小写 统一小写
            String s = String.valueOf(c).toLowerCase();
            c = s.toCharArray()[0];
            Integer o = treeMap.get(c);
            if (o == null) {
                treeMap.put(c, 1);
            } else {
                o++;
                treeMap.put(c, o);
            }
        }
        System.out.println(treeMap);
    }



}
