package com.javarush.task.task15.task1529;

public class Plane implements Flyable {
    public int  countPasagers;
    public void fly(){}

    public Plane(int countPasagers) {
        this.countPasagers=countPasagers;
    }

    public Plane() {
        new Plane(0);
    }
}
