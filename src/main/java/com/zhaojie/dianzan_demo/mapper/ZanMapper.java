package com.zhaojie.dianzan_demo.mapper;

import com.zhaojie.dianzan_demo.bean.Zan;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface ZanMapper {
    List<Zan> home();

    Zan dianzan(@Param("id") Integer id);



    void insertObject(Zan example);

    void delAll(@Param("id")String id);

    List<Zan> upd(@Param("id")Integer id);

    void updObject(Zan example);

    List<Zan> selObject(Integer id);

    List<Zan> selectList(@Param("zan")Zan zan);
}
