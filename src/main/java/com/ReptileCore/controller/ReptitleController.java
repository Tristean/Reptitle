package com.ReptileCore.controller;

import com.ReptileCore.Util.UrlUtil;
import com.ReptileCore.service.ReptitleService;
import com.ReptileCore.service.ResovleService;
import com.ReptileCore.service.serviceImp.JsoupServicesImp;
import com.ReptileCore.service.serviceImp.ReptitleClientImp;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class ReptitleController {
    private  ReptitleService reptitleService = new ReptitleClientImp();
    private  ResovleService  resovleService = new JsoupServicesImp();
    static List<List<String>> listOfImg = new ArrayList<List<String>>();

    public void getText(String url) {
        /*
        while(isContinue) {
            if (count == 10) {
                isContinue = false;
                System.out.println("结束");
            }
            System.out.println("url = " + url);
            String html = reptitleService.httpGet(url);
            List<String> imgs = resovleService.getImg(html);
            listOfImg.add(imgs);
            List<String> urls = resovleService.getFromRedis();
            resovleService.saveUrl(html);
            count ++;
            System.out.println("count = "+ count);
            getText(urls.get(count));
        }
        */
        UrlUtil.setF_url(url);
        System.out.println(" 要抓取的页面为url = " + url );
        String html = reptitleService.httpGet(url);
        if (html != null || !html.equals("")) {
            resolve(html);
        }
    }

    public void getTextFromPost(String url, HashMap<String,String> map) {
        System.out.println(" url = " + url);
        String html = reptitleService.httpPost(url, map);
        resolve(html);
    }

    protected void resolve(String html) {
        List<String> imgs = resovleService.getImg(html);
        listOfImg.add(imgs);
        resovleService.saveUrl(html);
        System.out.println("页面处理成功");
        /*
        List<String> urls = resovleService.getFromRedis();
        System.out.println("要抓取的页面url总数为" + urls.size());
        try {
            for (int i = 0; i < urls.size(); i++) {
                System.out.println("第" + i + "个");
                String tempUrl = urls.get(i);
                if (tempUrl == null || tempUrl.equals("")) {
                    continue;
                }
                html = reptitleService.httpGet(tempUrl);
                imgs = resovleService.getImg(html);
                listOfImg.add(imgs);
                resovleService.saveUrl(html);
            }
            resovleService.deleteUrl(urls);
            resovleService.close();
        } catch (Exception e)  {
            e.printStackTrace();
            resovleService.deleteUrl(urls);
        }*/
    }

    public List<String> getUrls() {
        return resovleService.getFromRedis();
    }
}
