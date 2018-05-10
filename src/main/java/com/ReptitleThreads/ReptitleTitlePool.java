package com.ReptitleThreads;

import com.ReptitleThreads.Task.ReptitleTask;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ReptitleTitlePool {
    private Executor executor = Executors.newCachedThreadPool();
    private List<String> list = null;
    private volatile int taskId = 0;

    public ReptitleTitlePool( List<String> list) {
        this.list = new CopyOnWriteArrayList<String>(list);
    }

    public void executeTask() {
        for (int i = 0; i < list.size(); i++) {
            ReptitleTask task = new ReptitleTask(taskId + "",list.get(i));
            executor.execute(task);
            taskId++;
        }
    }
}
