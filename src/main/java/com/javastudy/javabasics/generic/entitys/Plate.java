package com.javastudy.javabasics.generic.entitys;

/**
 * @author zhengyang.chen
 * @version 1.0.0
 * @ClassName Plate.java
 * @Description TODO
 * @createTime 2021/5/21 14:37
 */
public class Plate<T> {
    T item;

    public Plate(T t){
        item=t;
    }

    public void set(T t) {
        item=t;
    }

    public T get() {
        return item;
    }

    public static void main(String[] args) {
        Plate<? extends Fruit> p=new Plate<Apple>(new Apple());
    }
}
