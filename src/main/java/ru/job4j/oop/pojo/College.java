package ru.job4j.oop.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFIO("Иванов Иван Иванович");
        student.setGroup(20201);
        student.setEnterDate(new Date());
        System.out.println("Студент: " + student.getFIO() + ", группа: " + student.getGroup() + ", дата поступления: " + student.getEnterDate());
    }
}
