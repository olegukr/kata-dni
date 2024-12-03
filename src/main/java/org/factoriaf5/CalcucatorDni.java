package org.factoriaf5;

import java.util.Arrays;
import java.util.Scanner;

public class CalcucatorDni {

    public final String stringCharDni = "T, R, W, A, G, M, Y, F, P, D, X, B, N, J, Z, S, Q, V, H, L, C, K, E";

    public CalcucatorDni() {
    }

    public void run(Scanner scanner) {
        int inputNumber = inputNumberDni(scanner);
        calculateDni(inputNumber);
    }
    public void calculateDni( int number) {
        int remainder  = number % 23;

        String[] parts = stringCharDni.split(",");
        System.out.println(Arrays.toString(parts));
        String normStringCharDni = String.join("", parts).replace(" ", "");
        char result = normStringCharDni.charAt(remainder);
        String resultString = String.format("%08d", number) + "-" + result;
        System.out.println(resultString);
    }

    public int inputNumberDni(Scanner scanner) {
        int inputNum = -1;
        System.out.print("Please enter a DNI number: ");
        while (true) {
            
            if (scanner.hasNextInt()) {
                inputNum = scanner.nextInt();
                scanner.nextLine(); // Clear the newline 
                System.out.println("You entered the number: " + inputNum);
                if (inputNum >= 0 && inputNum <= 99999999) {
                    break;

                } else {
                    System.out.print("Invalid input! Enter a valid number from 00000000 to 99999999: ");
                }
            } else {
                System.out.print("Invalid input! Enter a valid number from 00000000 to 99999999: ");
                scanner.nextLine(); 
            }
        }
    
        return inputNum;
    }
    
}
