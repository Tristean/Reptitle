package com.Reptile.service.serviceImp;

import com.Reptile.Util.UrlUtil;
import com.Reptile.service.UrlService;

public class UrlServiceImp implements UrlService {

    @Override
    public String ChangeUrl(String url) {
        if ((!url.contains("http") || !url.contains("https")) && !url.equals("")) {
            String new_url = UrlUtil.addHttp(url);
            System.out.println("新加的url为"+new_url);
            return new_url;
        }
        return url;
    }

    public boolean hasFeature(String url) {
        return UrlUtil.hasFeature(url);
    }
}
