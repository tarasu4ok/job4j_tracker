package ru.job4j.oop;

public class Jukebox {
    public void music(int position) {
        if (position == 1) {
            System.out.println("Пусть бегут неуклюже,");
            System.out.println("Пешеходы по лужам,");
            System.out.println("А вода по асфальту рекой.");
            System.out.println("И неясно прохожим,");
            System.out.println("В этот день непогожий,");
            System.out.println("Почему я весёлый такой");
        } else if (position == 2) {
            System.out.println("Спят усталые игрушки, книжки спят,");
            System.out.println("Одеяла и подушки ждут ребят.");
            System.out.println("Даже сказка спать ложится,");
            System.out.println("Чтобы ночью нам присниться,");
            System.out.println("Ты ей пожелай: «Баю-бай!»");
        } else {
            System.out.println("Песня не найдена");
        }
    }

    public static void main(String[] args) {
        Jukebox jbox = new Jukebox();
        System.out.println("run method music() with parametr position = 1:");
        jbox.music(1);
        System.out.println("");
        System.out.println("run method music() with parametr position = 2:");
        jbox.music(2);
        System.out.println("");
        System.out.println("run method music() with parametr position = 3:");
        jbox.music(3);
    }
}
