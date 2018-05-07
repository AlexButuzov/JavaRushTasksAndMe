package com.javarush.task.task14.task1413;

public class Computer {
    private Keyboard keyboard;
    private Monitor monitor;
    private Mouse mouse;

    /**
     * 15.03.2018
     */
    public Computer(Keyboard keyboard, Mouse mouse, Monitor monitor) {
        this.keyboard = keyboard;
        this.monitor = monitor;
        this.mouse = mouse;
    }

    public Keyboard getKeyboard() {
        return this.keyboard;
    }

    public Monitor getMonitor() {
        return this.monitor;
    }

    public Mouse getMouse() {
        return this.mouse;
    }
}
