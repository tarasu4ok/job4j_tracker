package ru.job4j.oop;

public class Fix {
    private String desc;

    private Fix(String text) {
        this.desc = text;
    }

    public static void main(String[] args) {
        Fix fix = new Fix("Fix for task #1");
    }
}
