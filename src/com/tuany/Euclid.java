package com.tuany;

import java.lang.Math;

public class Euclid {

    private static int factor = 1;
    private static int limit = 100;

    // Declare a static method that calculates the GCD of two numbers using the Euclidean Algorithm.
    public static int gcd(int a, int b) {
        int remainder = Math.max(a, b) % Math.min(a, b);
        if (remainder == 0) {
            return Math.min(a,b);
        }
        else if (Math.min(a,b) % remainder == 0) {
            return remainder;
        }
        else {
            return gcd(Math.min(a, b), remainder);
        }
    }

    // Declare a static method that finds the 1 (mod modulus) given an encryption key and modulus.
    public static int findModulusOne(int encryptionKey, int phiN) {

        // If the factor for the encryptionKey exceeds factor limit expectation, return 0.
        if(factor > limit) {
            return 0;
        }

        // Otherwise, continue to find the possible key.
        // Formula: (factor * phiN + 1) / encryptionKey
        double possibleKey = (factor * phiN + 1) / (double) encryptionKey;

        // If this key is 1 (mod modulus), then return this key. Reset the instance variable factor and limit to 1 and 100 respectively.
        if (possibleKey % 1 == 0) {
            factor = 1;
            limit = 100;
            return (int) possibleKey;
        }

        // Otherwise, increase the factor by 1 and return a recursion of the findModulusOne function.
        else {
            factor++;
            return findModulusOne(encryptionKey, phiN);
        }
    }

    // Declare an overloaded method that sets a limit for the findModulusOne function.
    public static int findModulusOne(int encryptionKey, int modulus, int iterationLimit) {
        limit = iterationLimit;
        return findModulusOne(encryptionKey, modulus);
    }

}
