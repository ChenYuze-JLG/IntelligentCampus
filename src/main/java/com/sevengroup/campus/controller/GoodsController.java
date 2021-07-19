package com.sevengroup.campus.controller;

import com.alibaba.fastjson.JSONObject;
import com.sevengroup.campus.bean.GoodsBean;
import com.sevengroup.campus.bean.SortUtil;
import com.sevengroup.campus.service.GoodsService;
import com.sevengroup.campus.service.HeadService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class GoodsController {
    private String rootPath;

    private String imgPath;

    @Autowired
    GoodsService goodsService;

    @Autowired
    HeadService headService;

//    @Configuration    public class StateResourceConfigurer extends WebMvcConfigurerAdapter {
//        @Override
//        public void addResourceHandlers(ResourceHandlerRegistry registry){
//            rootPath = System.getProperty("user.dir") + "/source/static/LossAndFoundImg/";
//            System.out.println(rootPath);
//            registry.addResourceHandler("/static/**")
//                    .addResourceLocations("file:" + rootPath);
////                    .addResourceLocations("file:E://Intelligence-campus\\source\\static\\");
//            super.addResourceHandlers(registry);
//        }
//    }
    @RequestMapping("/allGoods")
    public String showMainInterface() {
      return "allGoods";
    }

    @RequestMapping(value = "/release", method = RequestMethod.GET)
    public String showRelease() {
      return "release";
    }
    @ResponseBody
    @RequestMapping(value = "/release", method = RequestMethod.POST)
    Map<String, Object> addImg(MultipartFile file, Map<String, Object> map) throws IOException {
        rootPath = System.getProperty("user.dir") + "/source/static/";

        System.out.println(file.getName());
        System.out.println(file.getOriginalFilename());
        System.out.println(file.getSize());
        System.out.println("OK");

        String[] temp = file.getOriginalFilename().split("\\.");
        String imgType = temp[temp.length - 1];
//        imgPath = "src\\main\\resources\\static\\activity";
//        imgPath = "E:\\Intelligence-campus/source/static/";
        imgPath = rootPath;
        for(int i = 0; i < temp.length - 1; ++i)
            imgPath = imgPath + temp[i];

        File img = new File(imgPath + "." + imgType);
        while(img.exists()) {
            imgPath = imgPath + "1";
            img = new File(imgPath + "." + imgType);
        }
        img.createNewFile();

        System.out.println(img.getPath());
        InputStream ins = file.getInputStream();
        try {
            OutputStream os = new FileOutputStream(img);
            int bytesRead = 0;
            byte[] buffer = new byte[8192];
            while ((bytesRead = ins.read(buffer, 0, 8192)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
            os.close();
            ins.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        imgPath = imgPath + "." + imgType;

        System.out.println("start");
        System.out.println(imgPath);

//        imgPath = imgPath.replace("E://Intelligence-campus/source/static", "../static/");
        imgPath = imgPath.replace(rootPath, "../static/");
        imgPath = imgPath.replace("\\", "/");
        System.out.println(imgPath);
        System.out.println("end");

        headService.showHeadInfo(map);

        return new HashMap<>();
    }

    @RequestMapping("/information")
    @ResponseBody
    public String information(
            @RequestParam(value = "page") Integer currPage, // 当前数据表格的页数
            @RequestParam(value = "limit") Integer currPageSize, // 当前数据表格每页的容量大小
            @RequestParam(value = "name", defaultValue = "") String getName
    ) throws JSONException {
      System.out.println(getName);
      List<GoodsBean> goodsInfo = goodsService.search(getName);
      for (int i = 0; i < goodsInfo.size(); i++) {
        System.out.println(goodsInfo.get(i).toString());
      }
      JSONObject jsonResult = new JSONObject();
      jsonResult.put("code", 0);
      jsonResult.put("msg", "");
      jsonResult.put("count", goodsInfo.size());
      SortUtil.anyProperSort(goodsInfo.equals("asc"));
      int fromIndex = (currPage - 1) * currPageSize;
      int toIndex = Math.min(currPage * currPageSize, goodsInfo.size());
      List<GoodsBean> goodsInfoPerPage = goodsInfo.subList(fromIndex, toIndex);
      jsonResult.put("data", goodsInfoPerPage);
//        System.out.println(currPage + " " + currPageSize);
//        System.out.println(sortField + " " + sortOrder);
      return jsonResult.toJSONString();
    }

    @RequestMapping(value = "/saveGoods", method = RequestMethod.POST)
    String saveGoods(
            @RequestParam("description") String description,
            @RequestParam("contact") String contact,
            @RequestParam("name") String name,
            Map<String,Object> map
    ) {
      System.out.println(description);
      System.out.println(contact);
      System.out.println(name);
      System.out.println(imgPath);
      goodsService.saveGoods(description, contact, name, imgPath);
      headService.showHeadInfo(map);
      return "allGoods";
    }

    @GetMapping("/search")
    public List<GoodsBean> searchAll(@RequestParam(value = "name") String getNmae) {
      System.out.println(getNmae);
      return goodsService.search(getNmae);
    }
  }

