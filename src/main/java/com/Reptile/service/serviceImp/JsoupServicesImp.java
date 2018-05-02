package com.Reptile.service.serviceImp;

import com.Reptile.dao.Redisdao;
import com.Reptile.dao.daoImp.RedisdaoImp;
import com.Reptile.service.ResovleService;
import com.Reptile.service.UrlService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class JsoupServicesImp implements ResovleService {
    private UrlService urlService = new UrlServiceImp();
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
        Document document = parse(html);
        Elements elements = document.getElementsByTag("img");
        List<String> imgs = new ArrayList<String>();

        for (Element element : elements) {
            String img = element.attr("src");
            img = urlService.ChangeUrl(img);
            imgs.add(img);
        }
        return imgs;
    }

    public List<String> getFromRedis() {
        return redisdao.getUrlPath();
    }

    public boolean saveUrl(String html) {
        Document document = parse(html);
        List<String> urls = getUrl(document);
        return redisdao.saveUrlPath(urls);
    }
}
