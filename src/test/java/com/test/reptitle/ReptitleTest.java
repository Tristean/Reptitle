package com.test.reptitle;

import com.Reptile.dao.Redisdao;
import com.Reptile.dao.daoImp.RedisdaoImp;
import com.Reptile.service.ReptitleService;
import com.Reptile.service.ResovleService;
import com.Reptile.service.serviceImp.JsoupServicesImp;
import com.Reptile.service.serviceImp.ReptitleClientImp;
import org.jsoup.nodes.Document;

import java.util.List;

public class ReptitleTest {
    private static ReptitleService reptitleService = new ReptitleClientImp();
    private static ResovleService resovleService = new JsoupServicesImp();
    private static Redisdao redisdao = new RedisdaoImp("120.78.198.157",6379);
    public static void main(String[]args) {

    }
}
