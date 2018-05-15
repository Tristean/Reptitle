package com.ReptileCore.Util;

public class UrlUtil {
    private static String f_url;

    public static String getF_url() {
        return f_url;
    }

    public static void setF_url(String f_url) {
        UrlUtil.f_url = f_url;
    }

    public static String addHttp(String url){
        String subUrl = "http:" + url;
        return subUrl;
    }

    public static String addHttpWithRelative(String url) {
        System.out.println("添加的基础url为" + getF_url());
        String subUrl = getF_url() + url;
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
            return false;
        return true;
    }
}
