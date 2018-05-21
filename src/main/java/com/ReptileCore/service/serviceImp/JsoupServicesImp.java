package com.ReptileCore.service.serviceImp;

import com.ReptileCore.dao.Redisdao;
import com.ReptileCore.dao.daoImp.RedisdaoImp;
import com.ReptileCore.dao.daoImp.UrlDaoImp;
import com.ReptileCore.service.ResovleService;
import com.ReptileCore.dao.UrlDao;
import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class JsoupServicesImp implements ResovleService {
    private static Logger logger = Logger.getLogger(JsoupServicesImp.class);
    private UrlDao urlService = new UrlDaoImp();
    private Redisdao redisdao = new RedisdaoImp("120.78.198.157",6379);


    private Document parse(String html) {
        return Jsoup.parse(html);
    }

    private List<String> getUrl(Document document) {
        Elements elements = document.getElementsByTag("a");
        List<String> list = new ArrayList<String>();

        for (Element element : elements) {
            String url = element.attr("href");
            list.add(url);
        }
        return list;
    }

    public List<String> getImg(String html) {
        if (html == "kong")
            return null;
        Document document = parse(html);
        Elements elements = document.getElementsByTag("img");
        List<String> imgs = new ArrayList<String>();

        for (Element element : elements) {
            String img = element.attr("src");
            img = urlService.ChangeUrl(img);
            System.out.println("图片地址为" + img);
            imgs.add(img);
        }
        return imgs;
    }

    public List<String> getFromRedis() {
        return redisdao.getUrlPath();
    }

    public boolean saveUrl(String html) {
        if (html == "kong")
            return false;
        Document document = parse(html);
        List<String> urls = getUrl(document);
        return redisdao.saveUrlPath(urls);
    }

    @Override
    public boolean deleteUrl(List<String> urls) {
        return redisdao.deleteUrl(urls);
    }

    public void close() {
       redisdao.close();
    }
}
