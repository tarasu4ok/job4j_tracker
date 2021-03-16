package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void go() {
        System.out.println("Едем-едем");
    }

    @Override
    public void passengers(int count) {
        System.out.println("В автобус вошло " + count + " пассажиров");
    }

    @Override
    public double refuel(int litersCount) {
        double price = 45.50;
        return price * litersCount;
    }
}
