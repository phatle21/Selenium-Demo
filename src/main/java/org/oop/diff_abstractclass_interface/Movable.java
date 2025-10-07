package org.oop.diff_abstractclass_interface;

// Interface
interface Movable {
    void move();
    default void stop() {
        System.out.println("Vehicle has stopped.");
    }
}
