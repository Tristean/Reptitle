package com.Reptile.Util;

public class UrlUtil {
    public static String addHttp(String url){
        String subUrl = "https:" + url;
        return subUrl;
    }

    public static boolean hasFeature(String url) {
        if (url.equals("") || url.length() < 2) {
            return false;
        }
        if (url.contains("javascript")) {
            return false;
        }
        if (url.charAt(0) == '/' && url.charAt(1) == '/')
            return true;
        return false;
    }
}
