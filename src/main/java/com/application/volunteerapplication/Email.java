package com.application.volunteerapplication;
import javafx.fxml.FXML;

import java.util.Scanner;
/**
 * Note: For my volunteer application it doesn't need any Abstract Classes since my goal is to just implement methods inside of a text field to validated the users email
 * and since scene builder also has the ability to restrict radio buttons which I was going to make a class for but ended up not needing to due to scene builders implementation.
 * Also my volunteer application does not have inheritance/polymorphism since scene builder was able to take care of the vast majority of my classes that was going to be implemented
 * and since my goal is to provide feedback to the user and in this case it would only be one section of the application, however, if I decide to add more requirements then I would implement more classes and inherit them from this class
 */
/**
 * Made a webpage to find a wolunteer application to make it so that the experience for the user is similar to when visiting a normal web site.
 * In this webpage you are able to interact with this webpage in order to get to you desired Volunteer Application, in which helps guide you towards submitting an application.
 * @KarenS
 */

/**
 * UML CONCRETE CLASS DIAGRAM:
 * -----------------------------
 * Email
 * -----------------------------
 * email : String
 * ch : char
 * -----------------------------
 * + isValidEmail(String email)
 * +isSpecialCharacter(char ch)
 *
 *
 */

public class Email {

    public static void main(String[] args) {
        // Create a Scanner object to receive user input from keyboard
        Scanner input = new Scanner(System.in);

        String email;

        // Prompt user for an email until they enter a valid email
        do {
            System.out.println("Please enter your Email:");
            email = input.nextLine();
        } while (!isValidEmail(email));
        System.out.println("Valid!");
    }

    /**Methods**/

    /**
     * Makes sure that the email inputted is valid with making sure it has the @ symbol
     * @param email
     * @return returns a boolean false if false then make sure it has an error message if valid then have a success message
     */
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
    /*NOTE: this method is a bit of a fluke and needs tweaking due to it accepting an email like 12345678@ even if it doesn't have the address */

    /**
     * Making a method in which the email is able to have special characters inplemented in them
     * @param ch
     * @return boolean
     */
    public static boolean isSpecialCharacter(char ch) {
        return (ch >= '!' || ch <= '/' || ch == '.');
    }


}