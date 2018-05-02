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

    public static boolean isContinue() {
        return isContinue;
    }
    public static void setContinue(boolean aContinue) {
        isContinue = aContinue;
    }

    public static void getText(String url) {

        for (int i = 0; i < 10; i++) {
            int id = 0;
            String html = reptitleService.httpGet(url);
            List<String> imgs = resovleService.getImg(html);
            resovleService.saveUrl(html);
            List<String> urls = resovleService.getFromRedis();
            getText(urls.get(id));
            urls.remove(id++);
        }
    }

    public static void main(String [] args) {

    }
}
