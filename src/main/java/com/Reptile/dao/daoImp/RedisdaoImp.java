package com.Reptile.dao.daoImp;

import com.Reptile.dao.Redisdao;
import com.Reptile.service.UrlService;
import com.Reptile.service.serviceImp.UrlServiceImp;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.ArrayList;
import java.util.List;

public class RedisdaoImp implements Redisdao {
    private int id = 0;
    private JedisPool jedisPool;
    private UrlService urlService = new UrlServiceImp();

    public RedisdaoImp(String ip, int port) {
        this.jedisPool = new JedisPool(ip,port);
    }

    @Override
    public List<String> getUrlPath() {
        Jedis jedis = jedisPool.getResource();
        jedis.auth("guliangjing52");
        List<String> list = new ArrayList<String>();

        for (int i = 0;i < 1000; i++) {
            String url = jedis.get(i+"");
            if (url == null) {
                break;
            }
            if (!url.contains("http:")) {
                url = urlService.ChangeUrl(url);
            }
            list.add(url);
        }
        return list;
    }

    @Override
    public boolean saveUrlPath(List<String> urls) {
        Jedis jedis = jedisPool.getResource();
        jedis.auth("guliangjing52");
        try {
          for (int i = 0; i < urls.size(); i++) {
              jedis.set(id+"",urls.get(i));
              id++;
          }
          System.out.println("success");
          return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        return false;
    }
}
