package com.javarush.task.task14.task1417;

public abstract class Money {
    private double amount = 0.0;


    public Money(double amount) {
        this.amount = amount;
    }

    public Money() {
        amount = 0.;
    }

    public double getAmount() {
        return this.amount;
    }


    public abstract String getCurrencyName();
}

