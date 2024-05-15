package org.moquer.utileria;

public class Convertidor {

    public static int convertToDecimal(String binaryNumber) {
        int decimalValue = 0;
        int power = 0;

        for (int i = binaryNumber.length() - 1; i >= 0; i--) {
            int digit = Character.getNumericValue(binaryNumber.charAt(i));

            decimalValue += digit * Math.pow(2, power);

            power++;
        }
        return decimalValue;
    }
}