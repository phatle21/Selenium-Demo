package org.oop.diff_abstractclass_interface;

// Abstract class
abstract class Vehicle {
    protected String brand;

    public Vehicle(String brand) {
        this.brand = brand;
    }

    public void start() {
        System.out.println(brand + " vehicle is starting.");
    }

    abstract void move();
}
