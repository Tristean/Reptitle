package com.test.reptitle;

import com.ReptileCore.dao.Redisdao;
import com.ReptileCore.dao.daoImp.RedisdaoImp;
import com.ReptileCore.service.ReptitleService;
import com.ReptileCore.service.ResovleService;
import com.ReptileCore.service.serviceImp.JsoupServicesImp;
import com.ReptileCore.service.serviceImp.ReptitleClientImp;

public class ReptitleTest {
    private static ReptitleService reptitleService = new ReptitleClientImp();
    private static ResovleService resovleService = new JsoupServicesImp();
    private static Redisdao redisdao = new RedisdaoImp("120.78.198.157",6379);
    public static void main(String[]args) {

    }
}
