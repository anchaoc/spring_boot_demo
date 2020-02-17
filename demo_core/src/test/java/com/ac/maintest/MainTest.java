package com.ac.maintest;

import com.ac.model.Book;

import java.util.TreeSet;

/**
 * @author anchao
 * @date 2020/2/14 18:01
 */
public class MainTest {


    public static void main(String[] args) {
        TreeSet<Book> books = new TreeSet<>();
        books.add(new Book("a"));
        books.add(new Book("c"));
        books.add(new Book("b"));

        System.out.println(books);
    }


}
