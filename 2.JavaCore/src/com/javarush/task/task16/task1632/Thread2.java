package com.javarush.task.task16.task1632;

public class Thread2 extends Thread4 {
    @Override
    public void run() {
        try {
            throw new InterruptedException();
        } catch (InterruptedException exp) {
            System.out.println("InterruptedException");
        }
    }
}
