package ru.job4j.search;

import java.util.LinkedList;

public class Task {
    private String desc;
    private int priority;

    public Task(String desc, int priority) {
        this.desc = desc;
        this.priority = priority;
    }

    public String getDesc() {
        return desc;
    }

    public int getPriority() {
        return priority;
    }

    public static void main(String[] args) {
        LinkedList<String> tasks = new LinkedList<>();
        tasks.add(1, "");
        System.out.println(tasks.size());
    }
}
