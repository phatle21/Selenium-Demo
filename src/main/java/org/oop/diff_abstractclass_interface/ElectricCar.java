package org.oop.diff_abstractclass_interface;

// Lớp ElectricCar kết hợp cả hai
class ElectricCar extends Vehicle implements Movable {
    public ElectricCar(String brand) {
        super(brand);
    }

    @Override
    public void move() {
        System.out.println(brand + " electric car is moving silently.");
    }
}
