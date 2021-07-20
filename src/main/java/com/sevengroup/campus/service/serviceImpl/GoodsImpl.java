package com.sevengroup.campus.service.serviceImpl;

import com.sevengroup.campus.bean.GoodsBean;
import com.sevengroup.campus.mapper.GoodsMapper;
import com.sevengroup.campus.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsImpl implements GoodsService{
    @Autowired
    private GoodsMapper goodsMapper;
    @Override
    public List<GoodsBean> information(){
        return goodsMapper.information();
    }
    @Override
    public void saveGoods(String description,String contact,String name,String imgurl){
        goodsMapper.saveGoods(description,contact,name,imgurl);
    }
    @Override
    public List<GoodsBean> search(String name){
        String input = "%" + name + "%";
        return goodsMapper.search(input);
    }

}
