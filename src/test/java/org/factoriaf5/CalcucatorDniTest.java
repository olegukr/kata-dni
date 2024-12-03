package org.factoriaf5;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class CalcucatorDniTest {

    @Test
    void testCalculateDniValidNumber() {
        CalcucatorDni calculator = new CalcucatorDni();

        // Capture the output to validate the result
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Valid DNI number
        int dniNumber = 12345678;
        calculator.calculateDni(dniNumber);

        // Expected result
        int remainder = dniNumber % 23;
        String[] parts = calculator.stringCharDni.split(",");
        String normalizedString = String.join("", parts).replace(" ", "");
        char expectedLetter = normalizedString.charAt(remainder);
        String expectedOutput = String.format("%08d", dniNumber) + "-" + expectedLetter;

        // Validate the output
        assertTrue(outputStream.toString().contains(expectedOutput));
    }

    @Test
    void testInputNumberDniValidInput() {
        // Simulate valid user input
        String simulatedInput = "12345678\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        Scanner scanner = new Scanner(inputStream);

        CalcucatorDni calculator = new CalcucatorDni();
        int inputNumber = calculator.inputNumberDni(scanner);

        // Validate the input number is correctly returned
        assertEquals(12345678, inputNumber);
    }

    @Test
    void testInputNumberDniInvalidAndValidInput() {
        // Simulate invalid input followed by valid input
        String simulatedInput = "abcd\n-99999999\n12345678\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        Scanner scanner = new Scanner(inputStream);

        CalcucatorDni calculator = new CalcucatorDni();
        int inputNumber = calculator.inputNumberDni(scanner);

        // Validate the program correctly handles invalid input and accepts valid input
        assertEquals(12345678, inputNumber);
    }

    @Test
    void testRunMethod() {
        // Simulate user input
        String simulatedInput = "12345678\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        Scanner scanner = new Scanner(inputStream);

        // Capture the output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        CalcucatorDni calculator = new CalcucatorDni();
        calculator.run(scanner);

        // Validate the interaction
        String expectedPartialOutput = "Please enter a DNI number:";
        assertTrue(outputStream.toString().contains(expectedPartialOutput));
    }

    @Test
    void testCalculateDniEdgeCases() {
        CalcucatorDni calculator = new CalcucatorDni();

        // Capture the output to validate the result
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Test lower edge case
        calculator.calculateDni(0);
        int remainderLow = 0 % 23;
        String normalizedStringLow = String.join("", calculator.stringCharDni.split(",")).replace(" ", "");
        char expectedLetterLow = normalizedStringLow.charAt(remainderLow);
        assertTrue(outputStream.toString().contains("00000000-" + expectedLetterLow));

        // Clear the output stream
        outputStream.reset();

        // Test upper edge case
        calculator.calculateDni(99999999);
        int remainderHigh = 99999999 % 23;
        String normalizedStringHigh = String.join("", calculator.stringCharDni.split(",")).replace(" ", "");
        char expectedLetterHigh = normalizedStringHigh.charAt(remainderHigh);
        assertTrue(outputStream.toString().contains("99999999-" + expectedLetterHigh));
    }
}
