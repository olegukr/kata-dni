package org.factoriaf5;

import java.util.Arrays;
import java.util.Scanner;

public class CalcucatorDni {

    public final String stringCharDni = "T, R, W, A, G, M, Y, F, P, D, X, B, N, J, Z, S, Q, V, H, L, C, K, E";

    public CalcucatorDni() {
    }

    public void run() {
        int inputNumber = inputNumberDni();
        calculateDni(inputNumber);

    }
    public void calculateDni( int number) {
        int remainder  = number % 23;

        String[] parts = stringCharDni.split(",");
        System.out.println(Arrays.toString(parts));
        // String normStringCharDni = String.join("", parts).replace(" ", "");
        // char result = normStringCharDni.charAt(remainder);
        char result = Arrays.toString(parts).charAt(remainder);
        String resultString = String.format("%08d", number) + "-" + result;
        System.out.println(resultString);
    }

    public int inputNumberDni() {
        int inputNum;
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Please enter a DNI number:");
            inputNum = 0;
            while (true) {
                if (scanner.hasNextInt()) {
                    inputNum = scanner.nextInt(); // Зчитуємо число
                    System.out.println("You entered the number: " + inputNum);
                    String strNumber = String.valueOf(inputNum);
                
                    if (strNumber.length() == 8) {
                    break;
                    }
                } else {
                    System.out.println("Invalid input. Please enter a valid number from 00000000 to 99999999: ");
                }
            }
        }
        return inputNum;
    }
}
