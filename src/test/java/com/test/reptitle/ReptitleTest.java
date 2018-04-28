package com.test.reptitle;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class ReptitleTest {
    public static void main(String[]args) {
        HttpClient httpclient = new DefaultHttpClient();
        HttpGet httpget = new HttpGet("https://www.baidu.com/");
        try {
            HttpResponse response1 = httpclient.execute(httpget);
            System.out.println(response1.getStatusLine());
            HttpEntity entity = response1.getEntity();
            String text = EntityUtils.toString(entity);
            System.out.println(text);
        } catch (ClientProtocolException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
