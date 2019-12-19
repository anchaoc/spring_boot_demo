package com.ac.functionalinterface;


/**
 * @author anchao
 * @date 2019/12/9 15:56
 */
@FunctionalInterface
public interface LogFuncationalInterface<T> {

    String print(T t);
}
