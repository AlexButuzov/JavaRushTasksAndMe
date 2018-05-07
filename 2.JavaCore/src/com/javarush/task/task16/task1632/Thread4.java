package com.javarush.task.task16.task1632;

public class Thread4 extends Thread implements  Message {

    boolean alive = true;




    @Override
    public void showWarning() {
        alive = false;
    }

    @Override
    public void run() {
        while(alive){}
    }
}
