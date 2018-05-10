package com.ReptileCore.service;

import org.apache.http.client.HttpClient;

import java.util.HashMap;

public interface ReptitleService {
   HttpClient getClient();
   String httpGet(String url);
   String httpPost(String url, HashMap<String,String> nameValuePair );
}
