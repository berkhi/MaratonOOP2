package com.berkhayta;

import java.util.Scanner;

public class InputUtil {
    static Scanner scanner = new Scanner(System.in);

    public static String getStringValue(String input){
        System.out.println(input);
        return scanner.nextLine();
    }

    public static double getDoubleValue(String input){
        System.out.println(input);
        double deger = scanner.nextDouble();
        scanner.nextLine();
        return deger;
    }

    public static int getIntegerValue(String input){
        System.out.println(input);
        int deger = scanner.nextInt();
        scanner.nextLine();
        return deger;
    }
}
