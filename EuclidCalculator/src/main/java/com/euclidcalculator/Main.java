package com.euclidcalculator;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Instantiate the Scanner object.
        Scanner input = new Scanner(System.in);

        // Declare the gcd and programHasEnded variable.
        int gcd;
        int index;
        int[] numbers;
        int encryptionKey;
        int modulus;
        String selection;

        // Call the Euclid method and an input from the user.
        do {
            try {
                System.out.println("Find decryption key (decryptkey) or GCD (gcd)?");
                selection = input.nextLine().toLowerCase();

                if(selection.equals("gcd")) {
                    // Ask user for input and parse accordingly.
                    System.out.print("What are your numbers: ");
                    String[] parsedInput = input.nextLine().trim().split(" ");
                    numbers = new int[parsedInput.length];
                    index = 0;

                    // For each of the numbers in the parsed string, parse an integer and assign it to an index in numbers.
                    for (String number : parsedInput) {
                        numbers[index++] = Integer.parseInt(number);
                    }

                    // Sort the numbers array.
                    Arrays.sort(numbers);

                    // Assign a proper value to the GCD to start.
                    gcd = Euclid.gcd(numbers[0], numbers[1]);

                    // For each of the elements in numbers (should there be more than two), find the GCD of the current GCD and every other number.
                    for (int i = 2; i < numbers.length; i++) {
                        gcd = Euclid.gcd(gcd, numbers[i]);
                    }

                    // Print the result.
                    System.out.print("The GCD of the numbers is: ");
                    System.out.println(gcd);
                } else if(selection.equals("decryptkeys") || selection.equals("d")) {
                    // Ask user for the encryption key.
                    System.out.print("Encryption key value: ");
                    encryptionKey = Integer.parseInt(input.nextLine());

                    // Ask user for modulus.
                    System.out.print("Modulus (Phi N) value: ");
                    modulus = Integer.parseInt(input.nextLine());

                    // Ask the user if they would want to limit the count.
                    System.out.println("Limit the decryption key brute force count? Y/N");
                    String answer = input.nextLine().toLowerCase();

                    // Check if the answer was yes. If so, then ask for a limit, then send to Euclid 3-param .findModulusOne().
                    int result;
                    if(answer.equals("y") || answer.equals("yes")) {
                        System.out.print("Iteration Limit: ");
                        int limit = Integer.parseInt(input.nextLine());
                        result = Euclid.findModulusOne(encryptionKey, modulus, limit);
                    }
                    // Otherwise, send to Euclid 2-param .findModulusOne().
                    else {
                        result = Euclid.findModulusOne(encryptionKey, modulus);
                    }

                    // If the return value was zero, the decryption key was not found.
                    if(result == 0) {
                        System.out.println("There was no decryption key found given the limit.\n\n");
                    }
                    // Otherwise, if the return value was not zero, return the decryption key.
                    else {
                        System.out.println("Your possible decryption key is: " + result + "\n\n");
                    }
                }


            } catch (NumberFormatException e) {
                System.out.println("Please input number values only.\n");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Please input at least two number values.\n");
            }
        } while (true);
    }
}
