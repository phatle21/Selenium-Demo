package org.oop.diff_overriding_overloading;

// Lớp chính để chạy thử
public class VehicleDemo {
    public static void main(String[] args) {
        // Tạo đối tượng Vehicle
        Vehicle vehicle = new Vehicle();
        vehicle.move(); // Gọi phương thức move() của Vehicle

        // Tạo đối tượng Car
        Car car = new Car();

        // Overriding: Gọi phương thức move() đã ghi đè
        car.move();

        // Overloading: Gọi các phiên bản khác của move()
        car.move("City");
        car.move("Highway", 100);
    }
}