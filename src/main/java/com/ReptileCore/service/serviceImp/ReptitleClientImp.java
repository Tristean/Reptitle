package com.ReptileCore.service.serviceImp;

import com.ReptileCore.service.ReptitleService;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReptitleClientImp implements ReptitleService {
    private List<NameValuePair> list = new ArrayList<NameValuePair>();
    public HttpClient getClient() {
        HttpClient client = new DefaultHttpClient();
        return client;
    }

    public String httpGet(String url) {
        if (url == null || !url.contains("http") || url.equals(""))
            return "kong";
        HttpClient client = getClient();
        System.out.println("httpget的url" + url);
        HttpGet httpGet = new HttpGet(url);
        try {
            HttpResponse response = client.execute(httpGet);
            HttpEntity   entity = response.getEntity();
            String result = EntityUtils.toString(entity);
            return result;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String httpPost(String url,HashMap<String,String>nameValuePair) {
        HttpClient client = getClient();
        HttpPost post = new HttpPost(url);

        if (nameValuePair != null) {
            addNameValuePair(nameValuePair);
        }
        try {
            post.setEntity(new UrlEncodedFormEntity(list));
            HttpResponse response = client.execute(post);
            System.out.println(response.getStatusLine());
            HttpEntity entity = response.getEntity();
            return EntityUtils.toString(entity);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void addNameValuePair(HashMap<String,String> map) {
        if (map != null) {
            for (Map.Entry<String,String> entry : map.entrySet()) {
                list.add(new BasicNameValuePair(entry.getKey(),entry.getValue()));
            }
        }
    }
}
