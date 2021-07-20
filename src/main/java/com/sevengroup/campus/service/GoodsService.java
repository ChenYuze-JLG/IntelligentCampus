package com.sevengroup.campus.service;

import com.sevengroup.campus.bean.GoodsBean;

import java.util.List;

public interface GoodsService {
      List<GoodsBean> information();
      void saveGoods(String description,String contact,String name,String imgurl);
      List<GoodsBean> search(String name);

}
