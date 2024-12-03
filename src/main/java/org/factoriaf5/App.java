package org.factoriaf5;

import java.util.Scanner;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            CalcucatorDni calcucatorDni = new CalcucatorDni();
            // calcucatorDni.calculateDni(88889999);
            calcucatorDni.run(scanner);
        }
    }
}
