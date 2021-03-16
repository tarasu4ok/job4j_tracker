package ru.job4j.oop;

public class Train implements Vehicle {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName()
                + ": Рельсы-рельсы, шпалы-шпалы, едет поезд запоздалый");
    }
}
