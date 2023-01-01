package com.enigmacamp.psbb;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner inputNumber = new Scanner(System.in);
        System.out.println("Input the number of families : ");
        Integer inputNumberOfFamilies = inputNumber.nextInt();

        System.out.println("Input the number of members in the family (separated by a space): ");
        Scanner inputString = new Scanner(System.in);
        String inputMemberOfFamilies = inputString.nextLine();

        String result = countBusRequired(inputNumberOfFamilies, inputMemberOfFamilies);

        System.out.println(result);
    }

    static String countBusRequired(Integer numberOfFamilies, String memberofFamilies) {
        int busCapacity = 4;
        int space = 0;
        int total = 0;
        int totalBusRequired = 0;
        String whiteSpace = "";
        for (int i = 0; i < memberofFamilies.length(); i++) {
            if (memberofFamilies.charAt(i) == ' ') {
                space++;
            }
        }

        String[] passengers = new String[space + 1];

        for (int i = 0, j = 0; i < memberofFamilies.length(); i++) {
            if (memberofFamilies.charAt(i) == ' ') {
                passengers[j] = whiteSpace;
                j++;
                whiteSpace = "";
            } else {
                whiteSpace = whiteSpace + memberofFamilies.charAt(i);
            }
            passengers[j] = whiteSpace;
        }

        if (numberOfFamilies != passengers.length) {
            return "Input must be equal with count of family";
        } else {
            for (int i = 0; i < passengers.length; i++) {
                total = total + Integer.parseInt(passengers[i]);
            }

            if (total % busCapacity > 0) {
                totalBusRequired = Math.round((total / busCapacity) + 1);
            } else {
                totalBusRequired = total / busCapacity;
            }
        }
        return "Minimum bus required is : " + totalBusRequired;
    }
}
