package com.ReptileCore.Util;

public class UrlUtil {
    public static String addHttp(String url){
        String subUrl = "http://gyxzs.net/" + url;
        return subUrl;
    }

    public static boolean hasFeature(String url) {
        if (url.equals("") || url.length() < 2) {
            return false;
        }
        if (url.contains("javascript")) {
            return false;
        }
        if (url.charAt(0) == '/')
            return true;
        return false;
    }
}
