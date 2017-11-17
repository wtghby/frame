package com.conny.frame.material.dao;

import com.conny.frame.application.LocalApplication;
import com.conny.frame.bean.PersonBean;

import java.util.List;

/**
 * Created by Administrator on 2017/11/18 0018.
 */

public class Dao {
    public static void insert(PersonBean bean) {
        LocalApplication.getDaoInstant().getPersonBeanDao().insert(bean);
    }

    public static List<PersonBean> queryAll() {
        return LocalApplication.getDaoInstant().getPersonBeanDao().loadAll();
    }
}
