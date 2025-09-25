package org.javahowto.Collections;

import java.util.ArrayList;

public class ArrayListLoop {
    public static void main(String[] args) {
        ArrayList<String> cars = new ArrayList<String>();
        cars.add("Volvo");
        cars.add("BMW");
        cars.add("Mercedes");
        for (String i : cars) {
            System.out.println(i);
        }
    }
}
