package org.oop.diff_overriding_overloading;

// Lớp con kế thừa Vehicle, minh họa overriding và overloading
class Car extends Vehicle {
    // Overriding: Ghi đè phương thức move() từ lớp cha
    @Override
    public void move() {
        System.out.println("Car is driving on the road");
    }

    // Overloading: Tạo thêm phiên bản khác của move() với tham số khác
    public void move(String destination) {
        System.out.println("Car is driving to " + destination);
    }

    // Overloading: Một phiên bản khác của move() với tham số bổ sung
    public void move(String destination, int speed) {
        System.out.println("Car is driving to " + destination + " at " + speed + " km/h");
    }
}