package com.ReptitleThreads.Task;

import com.ReptileCore.controller.ReptitleController;

public class ReptitleTask implements Runnable {
    private String taskName;
    private String url;

    public ReptitleTask(String taskName, String url) {
        this.taskName = taskName;
        this.url = url;
    }

    private void getText(String url) {
        ReptitleController reptitleController = new ReptitleController();
        reptitleController.getText(url);
    }

    @Override
    public void run() {
        System.out.println("任务" + taskName + "正在执行");
        getText(url);
    }
}
