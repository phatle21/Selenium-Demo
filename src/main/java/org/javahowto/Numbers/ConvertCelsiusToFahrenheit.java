package org.javahowto.Numbers;

public class ConvertCelsiusToFahrenheit {
    public static void main(String[] args) {
        double celsius = 23.5;
        double fahrenheit = celsius * 9 / 5 + 32;

        System.out.println(celsius + "C = " + fahrenheit + "F");
    }
}
