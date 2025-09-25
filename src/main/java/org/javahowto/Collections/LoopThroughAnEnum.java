package org.javahowto.Collections;

enum Level {
    LOW,
    MEDIUM,
    HIGH
}

public class LoopThroughAnEnum {
    public static void main(String[] args) {
        for (Level myVar : Level.values()) {
            System.out.println(myVar);
        }
    }
}
