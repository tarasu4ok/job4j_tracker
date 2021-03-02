package ru.job4j.io;

import java.util.Random;
import java.util.Scanner;

public class MagicBall {
    public static void main(String[] args) {
        System.out.print("Я великий Оракул. Что ты хочешь узнать?" + '\n');
        Scanner input = new Scanner(System.in);
        String question = input.nextLine();
        int answer = new Random().nextInt(3);
        if (answer == 0) {
            System.out.println("Мой ответ - ДА!");
        } else if (answer == 1) {
            System.out.println("Мой ответ - НЕТ!");
        } else {
            System.out.println("Мой ответ - МОЖЕТ БЫТЬ!");
        }
    }
}
