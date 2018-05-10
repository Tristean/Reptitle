package com.test.ThreadPool;

public class Task implements Runnable {
    private String name;

    public Task(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        double num = Math.random();
        System.out.println("任务生成数为" + num);
    }
}
