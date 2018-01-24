package com.tw.refactoring.movierental;

/**
 * @author pzzheng
 * @date 1/24/18
 */
public interface Statement<T> {

    T statement(Customer customer);
}
