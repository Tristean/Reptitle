package com.test.ThreadPool;

import com.ReptitleThreads.ReptitleTitlePool;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPoolTest {

    public static void main(String [] args) {
        List<String>  testUrl = new ArrayList<String>();
        testUrl.add("https://www.baidu.com/");
        testUrl.add("https://blog.csdn.net");
        ReptitleTitlePool reptitleTitlePool = new ReptitleTitlePool(testUrl);
        reptitleTitlePool.executeTask();
    }

}
