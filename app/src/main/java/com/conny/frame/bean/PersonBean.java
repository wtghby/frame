package com.conny.frame.bean;

import com.orm.SugarRecord;

import java.io.Serializable;

/**
 * Desc:
 * Created by zhanghui on 2017/11/17.
 */

public class PersonBean extends SugarRecord implements Serializable {
    public String name;
    public int age;
    public String adderss;
}
