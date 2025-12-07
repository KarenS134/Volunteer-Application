package com.application.volunteerapplication;
import javafx.fxml.FXML;

import java.util.Scanner;

/**
 * @KarenS
 */

public class Email {

    public static void main(String[] args) {
        // Create a Scanner object to receive user input from keyboard
        Scanner input = new Scanner(System.in);

        String email;

        // Prompt user for a password until they enter a valid password
        do {
            System.out.println("Please enter your Email:");
            email = input.nextLine();
        } while (!isValidEmail(email));
        System.out.println("Valid!");
    }

    public static boolean isValidEmail(String email) {
        boolean hasSymbol = false;
        boolean hasSpecial = false;
        boolean hasMin = false;
        boolean hasInvalid = false;

        if (8 <= email.length()) {
            hasMin = true;
        }
        for (int i = 0; i < email.length(); i++) {
            char ch = email.charAt(i);
            if (isSpecialCharacter(ch)) {
                hasSpecial = true;
            } else
                hasInvalid = true;
        }
        if (!hasMin) {
            System.err.println("Email must be 8 or more characters");
        }
        if (!hasSpecial) {
            System.err.println("Email must contain a special character!!!");
        }
        if (hasInvalid) {
            System.err.println("Email cannot contain invalid character!!!");
        }
        return !hasInvalid && hasSpecial && hasMin;
    }

    public static boolean isSpecialCharacter(char ch) {
        return (ch >= '!' || ch <= '/' || ch == '.');
    }


}