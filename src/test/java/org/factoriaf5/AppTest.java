package org.factoriaf5;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class AppTest {

    @Test
    void testMainValidDni() {
        // Simulate valid user input for DNI
        String simulatedInput = "12345678\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);

        // Capture the output to validate the program behavior
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Execute main
        App.main(new String[]{});

        // Verify that the expected message appears in the output
        String expectedOutputPart1 = "Please enter a DNI number:";
        assertTrue(outputStream.toString().contains(expectedOutputPart1));

        // Verify that the correct DNI with letter is calculated and displayed
        int remainder = 12345678 % 23;
        CalcucatorDni calculator = new CalcucatorDni();
        String[] parts = calculator.stringCharDni.split(",");
        String normalizedString = String.join("", parts).replace(" ", "");
        char expectedLetter = normalizedString.charAt(remainder);
        String expectedDniOutput = "12345678-" + expectedLetter;

        assertTrue(outputStream.toString().contains(expectedDniOutput));
    }

    @Test
    void testMainInvalidAndValidDni() {
        // Simulate invalid input followed by valid input
        String simulatedInput = "abcd\n999999999\n12345678\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);

        // Capture the output to validate the program behavior
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Execute main
        App.main(new String[]{});

        // Verify that the program prompts for valid input after invalid attempts
        String invalidMessage = "Invalid input! Enter a valid number from 00000000 to 99999999:";
        assertTrue(outputStream.toString().contains(invalidMessage));

        // Verify that the correct DNI with letter is eventually calculated and displayed
        int remainder = 12345678 % 23;
        CalcucatorDni calculator = new CalcucatorDni();
        String[] parts = calculator.stringCharDni.split(",");
        String normalizedString = String.join("", parts).replace(" ", "");
        char expectedLetter = normalizedString.charAt(remainder);
        String expectedDniOutput = "12345678-" + expectedLetter;

        assertTrue(outputStream.toString().contains(expectedDniOutput));
    }
}

