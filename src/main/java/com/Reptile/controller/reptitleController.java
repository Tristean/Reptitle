package com.Reptile.controller;

import com.Reptile.service.ReptitleService;
import com.Reptile.service.ResovleService;
import com.Reptile.service.serviceImp.JsoupServicesImp;
import com.Reptile.service.serviceImp.ReptitleClientImp;


import java.util.ArrayList;
import java.util.List;


public class reptitleController {
    private static ReptitleService reptitleService = new ReptitleClientImp();
    private static ResovleService  resovleService = new JsoupServicesImp();
    private static boolean isContinue = true;
    static List<List<String>> listOfImg = new ArrayList<List<String>>();
    private static  int count = 0;

    public static boolean isContinue() {
        return isContinue;
    }
    public static void setContinue(boolean aContinue) {
        isContinue = aContinue;
    }

    public static void getText(String url) {
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
        System.out.println(" url = " + url );
        String html = reptitleService.httpGet(url);
        List<String> imgs = resovleService.getImg(html);
        listOfImg.add(imgs);
        resovleService.saveUrl(html);
        List<String> urls = resovleService.getFromRedis();
        for (int i = 0; i < urls.size(); i++) {
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
    }

    public static void main(String [] args) {
        getText("https://www.zhihu.com/signup?next=%2F");
        System.out.println("https://www.zhihu.com/signup?next=%2F".contains("http"));
        System.out.println(listOfImg.size());
    }
}
