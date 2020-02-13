package com.ac.collection;

import com.google.common.collect.Sets;
import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.LinkedList;

/**
 * @author anchao
 * @date 2020/2/3 11:41
 */
@Slf4j
public class CollectionTest {

    public static void main(String[] args) {
        s("anchao");
    }

    private static void t(){
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.addFirst(1);
        linkedList.removeFirst();
        System.out.println(linkedList);

    }


    private  static <T> void s(T t){
        HashSet<T> hashSet = Sets.newHashSet();
        hashSet.add(t);
        System.out.println(hashSet);

    }


}
