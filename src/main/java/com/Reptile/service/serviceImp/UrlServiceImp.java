package com.Reptile.service.serviceImp;

import com.Reptile.Util.UrlUtil;
import com.Reptile.service.UrlService;

public class UrlServiceImp implements UrlService {

    @Override
    public String ChangeUrl(String url) {
        if (!url.contains("http") || !url.contains("https")) {
            String new_url = UrlUtil.addHttp(url);
            System.out.println(new_url);
            return new_url;
        }
        return url;
    }
}
