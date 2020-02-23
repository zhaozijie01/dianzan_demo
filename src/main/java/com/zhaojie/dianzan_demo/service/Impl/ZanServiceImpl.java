package com.zhaojie.dianzan_demo.service.Impl;

import com.github.pagehelper.PageInfo;
import com.zhaojie.dianzan_demo.bean.Zan;
import com.zhaojie.dianzan_demo.mapper.ZanMapper;
import com.zhaojie.dianzan_demo.service.ZanService;
import org.springframework.beans.factory.annotation.Autowired;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZanServiceImpl implements ZanService {
    @Autowired
    ZanMapper zanMapper;


    @Override
    public void insertObject(Zan example) {
        zanMapper.insertObject(example);
    }

    @Override
    public void delAll(String id) {
        zanMapper.delAll(id);
    }

    @Override
    public List<Zan> upd(Integer id) {
        return zanMapper.upd(id);
    }

    @Override
    public void updObject(Zan example) {
        zanMapper.updObject(example);
    }

    @Override
    public List<Zan> selObject(Integer id) {
        return zanMapper.selObject(id);
    }

    @Override
    public PageInfo<Zan> selectList(Integer page, Integer rows, Zan zan) {
        PageHelper.startPage(page,rows);
        List<Zan> list = zanMapper.selectList(zan);
        return new PageInfo<Zan>(list);
    }
}
