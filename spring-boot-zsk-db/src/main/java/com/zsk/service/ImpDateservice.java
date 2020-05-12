package com.zsk.service;

import com.zsk.bean.Date;
import com.zsk.handler.GetData;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ImpDateservice implements BaseDateService {
    /**
     * 查询所有数据
     *
     * @return list集合
     */
    @Override
    public List<Date> list() {
        return GetData.getDate();
    }
}
