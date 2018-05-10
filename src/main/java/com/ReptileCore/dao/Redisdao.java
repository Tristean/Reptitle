package com.ReptileCore.dao;

import java.util.List;

public interface Redisdao {
     List<String> getUrlPath();
     boolean saveUrlPath(List<String> urls);
     boolean deleteUrl(List<String> urls);

    void close();
}
