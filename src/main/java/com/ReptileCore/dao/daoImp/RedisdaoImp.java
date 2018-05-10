package com.ReptileCore.dao.daoImp;

import com.ReptileCore.dao.Redisdao;
import com.ReptileCore.dao.UrlDao;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.ArrayList;
import java.util.List;

public class RedisdaoImp implements Redisdao {
    private int id = 0;
    private JedisPool jedisPool;
    private UrlDao urlService = new UrlDaoImp();
    private Jedis      jedis  ;
    private JedisPoolConfig config = new JedisPoolConfig();

    public RedisdaoImp(String ip, int port) {
        setConfig(config);
        this.jedisPool = new JedisPool(config,ip,port);
        jedis = jedisPool.getResource();
    }

    private void setConfig(JedisPoolConfig config) {
       config.setMaxIdle(8);
       config.setMaxTotal(200);
       config.setMinIdle(8);
       config.setMaxWaitMillis(10000);
       config.setTestOnBorrow(false);
       config.setTestOnReturn(true);
       config.setTestWhileIdle(true);
       config.setTimeBetweenEvictionRunsMillis(30000);
       config.setNumTestsPerEvictionRun(10);
       config.setMinEvictableIdleTimeMillis(60000);
    }

    @Override
    public List<String> getUrlPath() {
        jedis.auth("guliangjing52");
        List<String> list = new ArrayList<String>();

        for (int i = 0;i < 1000; i++) {
            String url = jedis.get(i+"");
            if (url == null) {
                break;
            }
            if (!url.contains("http:") && urlService.hasFeature(url)) {
                url = urlService.ChangeUrl(url);
            }
            list.add(url);
        }
        System.out.println("取出成功");
        return list;
    }

    @Override
    public boolean saveUrlPath(List<String> urls) {
        jedis.auth("guliangjing52");
        try {
          for (int i = 0; i < urls.size(); i++) {
              jedis.set(id+"",urls.get(i));
              id++;
          }
          System.out.println("存储success");
          return true;
        } catch (Exception e) {
            e.printStackTrace();
            jedis.close();
            System.out.println("异常关闭jedis");
        }
        return false;
    }

    @Override
    public boolean deleteUrl(List<String> urls) {
        for (int i = 0; i < urls.size(); i++) {
            jedis.del(i+"");
        }
        System.out.println("url已经删除");
        return true;
    }

    @Override
    public void close() {
        if (jedis != null) {
            jedis.close();
            System.out.println("jedis关闭成功");
        }
    }
}
