package com.Reptile.service;

import org.jsoup.nodes.Document;

import java.util.List;

public interface ResovleService {

    List<String> getFromRedis();

    List<String> getImg(String html);

    boolean saveUrl(String html);
}
