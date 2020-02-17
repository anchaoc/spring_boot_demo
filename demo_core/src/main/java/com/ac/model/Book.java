package com.ac.model;

import lombok.ToString;

/**
 * @author anchao
 * @date 2020/2/10 19:33
 */
@ToString
public class Book implements Comparable<Book> {

    private String bookName;


    public Book(String bookName) {
        this.bookName = bookName;
    }

    @Override
    public int compareTo(Book o1) {
       return this.bookName.compareTo(o1.bookName);
    }
}
