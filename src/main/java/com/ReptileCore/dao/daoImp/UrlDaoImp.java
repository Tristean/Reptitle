package com.ReptileCore.dao.daoImp;

import com.ReptileCore.Util.UrlUtil;
import com.ReptileCore.dao.UrlDao;
import org.apache.log4j.Logger;

public class UrlDaoImp implements UrlDao {
    private static Logger logger = Logger.getLogger(UrlDaoImp.class);
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

    public String changeUrlFromRelative(String url) {
        if ((!url.contains("http") || !url.contains("https")) && !url.equals("")) {
            String new_url = UrlUtil.addHttpWithRelative(url);
            System.out.println("新加的url为"+new_url);
            return new_url;
        }
        return url;
    }
}
