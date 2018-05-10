package com.ReptileCore.controller;

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
    private  boolean isContinue = true;
    static List<List<String>> listOfImg = new ArrayList<List<String>>();
    private   int count = 0;

    public  boolean isContinue() {
        return isContinue;
    }
    public  void setContinue(boolean aContinue) {
        isContinue = aContinue;
    }

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
        System.out.println(" 要抓取的页面为url = " + url );
        String html = reptitleService.httpGet(url);
        resolve(html);
    }

    public void getTextFromPost(String url, HashMap<String,String> map) {
        System.out.println("url = " + url);
        String html = reptitleService.httpPost(url, map);
        resolve(html);
    }

    public void resolve(String html) {
        List<String> imgs = resovleService.getImg(html);
        listOfImg.add(imgs);
        resovleService.saveUrl(html);
        List<String> urls = resovleService.getFromRedis();
        System.out.println("要抓取的页面url总数为" + urls.size());
        try {
            for (int i = 0; i < urls.size(); i++) {
                System.out.println("第" + i + "个");
                String tempUrl = urls.get(i);
                if (tempUrl == null || tempUrl.equals("")) {
                    continue;
                }
                html = reptitleService.httpGet(urls.get(i));
                imgs = resovleService.getImg(html);
                listOfImg.add(imgs);
                resovleService.saveUrl(html);
            }
            resovleService.deleteUrl(urls);
            resovleService.close();
        } catch (Exception e)  {
            e.printStackTrace();
            resovleService.deleteUrl(urls);
        }
    }

    public void main(String [] args) {
        getText("http://gyxzs.net/");
        System.out.println(listOfImg.size());
    }
}
