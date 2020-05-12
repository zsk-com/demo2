package com.zsk.service;

import com.zsk.bean.Date;

import java.util.List;

public interface BaseDateService {
    /**
     * 查询所有数据
     * @return list集合
     */
    List<Date> list();
}
