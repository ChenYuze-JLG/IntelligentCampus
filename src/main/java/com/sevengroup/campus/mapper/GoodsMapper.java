package com.sevengroup.campus.mapper;

import com.sevengroup.campus.bean.GoodsBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GoodsMapper {
    List<GoodsBean> information();
    void saveGoods(String description,String contact,String name,String imgurl);
    List<GoodsBean> search(String name);

}
