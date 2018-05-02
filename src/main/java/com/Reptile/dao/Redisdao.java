package com.Reptile.dao;

import java.util.List;

public interface Redisdao {
     List<String> getUrlPath();
     boolean saveUrlPath(List<String> urls);
}
