package com.ReptileCore.service;

import java.util.List;

public interface ResovleService {

    List<String> getFromRedis();

    List<String> getImg(String html);

    boolean saveUrl(String html);

    boolean deleteUrl(List<String> urls);

    void close();
}
