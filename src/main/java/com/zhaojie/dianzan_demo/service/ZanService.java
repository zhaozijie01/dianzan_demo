package com.zhaojie.dianzan_demo.service;

import com.github.pagehelper.PageInfo;
import com.zhaojie.dianzan_demo.bean.Zan;

import java.util.List;

public interface ZanService {






    void insertObject(Zan example);

    void delAll(String id);

    List<Zan> upd(Integer id);

    void updObject(Zan example);

    List<Zan> selObject(Integer id);

    PageInfo<Zan> selectList(Integer page, Integer rows, Zan zan);
}
