package com.jsonhandling.javaobjectintojsonformat;

public class Car {

    private String name;
    private double price;
    private String color;
    private double speed;

    public Car(double speed, String color, double price, String name) {
        this.speed = speed;
        this.color = color;
        this.price = price;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getColor() {
        return color;
    }

    public double getSpeed() {
        return speed;
    }
}
