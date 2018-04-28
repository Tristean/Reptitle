package com.Reptile.serviceImp;

import com.Reptile.service.ResovleService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class JsoupServices implements ResovleService {
    @Override
    public Document parse(String html) {
        return Jsoup.parse(html);
    }

}
