package com.sevengroup.campus.controller;

import com.sevengroup.campus.bean.ArticleBean;
import com.sevengroup.campus.bean.NewsBean;
import com.sevengroup.campus.service.HeadService;
import com.sevengroup.campus.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
public class newsController {

    @Autowired
    NewsService newsService;
    @Autowired
    HeadService headService;

    NewsBean now;
    List<NewsBean> news;

    @RequestMapping("/news")
    String showNews(Map<String, Object> map) {
        news = newsService.listNews();
        for(NewsBean _new : news) {
            System.out.println(_new.getTitle());
        }
        map.put("news", news);
        headService.showHeadInfo(map);
        return "news";
    }

    @RequestMapping("/launchNews")
    String launchNews() {
        return "launchNews";
    }

    @RequestMapping("/getNewsHtml")
    String getHtml(ArticleBean acticle, Model model, Map<String, Object> map) {
        System.out.println(acticle.getContent());
        newsService.saveNews(acticle.getAuthor(), acticle.getTitle(), acticle.getContent());
        news = newsService.listNews();
        for(NewsBean _new : news) {
            System.out.println(_new.getTitle());
        }
        map.put("news", news);
        return "redirect:news";
    }

    @ResponseBody
    @RequestMapping(value = "/newsInfo", method = RequestMethod.POST)
    Map<String, Object> newsInfo(@RequestParam Map<String, Object> x) {
        String id = (String) x.get("id");
        String author = (String) x.get("auhthor");
        String title = (String) x.get("title");
        String info = (String) x.get("info");
        System.out.println(id + author + title + info);
        now = new NewsBean();
        now.setID(Integer.parseInt(id));
        now.setPublisher(author);
        now.setTitle(title);
        now.setInfo(info);
        return new HashMap<>();
    }

    @RequestMapping("/newsInfo")
    String showNewsInfo(Map<String, Object> map) {
        map.put("now", now);
        return "newsInfo";
    }

    @ResponseBody
    @RequestMapping(value = "/loadPic", method = RequestMethod.POST)
    public Map<String, Object> uploadPic(
            @RequestParam(value = "editormd-image-file", required = true)
                    MultipartFile file, HttpServletRequest request
            ) throws IOException {
        Map<String, Object> res = new HashMap<>();

        String path = System.getProperty("user.dir") + "/source/static/upload";
        System.out.println(path);

        // 将要上传的图片放在的本地位置
        File realPath = new File(path);
        if(!realPath.exists())
            realPath.mkdirs();

        String fileName = UUID.randomUUID().toString().replaceAll("-", "") + ".jpg";
        file.transferTo(new File(realPath + "/" + fileName));

        System.out.println("????????????");
        System.out.println(file.getOriginalFilename());
        res.put("url", "/source/static/upload/" + fileName);
        res.put("success", 1);
        res.put("message", "upload sucesss!");
        System.out.println(res);
        return res;
    }

}
