package com.qixiaoyi.ycy_master;


import org.litepal.crud.DataSupport;

/**
 * Email 240336124@qq.com
 * Created by Darren on 2017/3/5.
 * Version 1.0
 * Description:
 */
public class Person extends DataSupport {

    private String name;
    private int age;

    // 默认的构造方法
    public Person(){

    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
