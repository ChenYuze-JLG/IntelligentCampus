package com.sevengroup.campus.controller;

import com.sevengroup.campus.bean.ArticleBean;
import com.sevengroup.campus.bean.NewsBean;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class newsController {

    @Autowired
    NewsService newsService;

    NewsBean now;

    @RequestMapping("/news")
    String showNews(Map<String, Object> map) {
        List<NewsBean> news = newsService.listNews();
        for(NewsBean _new : news) {
            System.out.println(_new.getTitle());
        }
        map.put("news", news);
        return "news";
    }

    @RequestMapping("/launchNews")
    String launchNews() {
        return "launchNews";
    }

    @RequestMapping("/getNewsHtml")
    String getHtml(ArticleBean acticle, Model model) {
        System.out.println(acticle.getContent());
        newsService.saveNews(acticle.getAuthor(), acticle.getTitle(), acticle.getContent());
        return "news";
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
            @RequestParam(value = "img", required = true)MultipartFile file,
            HttpServletRequest request
            ) {
        Map<String, Object> res = new HashMap<>();
        res.put("url", "");
        res.put("success", 1);
        res.put("message", "upload sucesss!");
        return res;
    }

}
