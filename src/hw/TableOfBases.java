package hw;

// James Ding
public class TableOfBases {

    public static void main(String[] args) {
        System.out.println("Decimal     Binary     Octal     Hex     Character");
        for (int decimal = 65; decimal < 90 + 1; decimal++) {
            System.out.println(decimal + "          " + decimalToBinary(decimal) + "    " + decimalToOctal(decimal) +
                    "       " + decimalToHex(decimal) + "      " + (char) decimal);
        }

    }

    /**
     * Converts a decimal to binary
     * @param decimal The number in base 10 form
     * @return Binary
     */
    static int decimalToBinary(int decimal) {
        if (decimal == 0) return 0;
        return decimalToBinary(decimal / 2) * 10 + decimal % 2;
    }

    /**
     * Converts a decimal to octal
     * @param decimal The number in base 10 form
     * @return Octal
     */
    static int decimalToOctal(int decimal) {
        if (decimal == 0) return 0;
        return decimalToOctal(decimal / 8) * 10 + decimal % 8;
    }

    /**
     * Converts numbers 10-15 to the proper alphabetical representation
     * @param decimal The single number to convert to base 16 form
     * @return The hex string of the decimal specified
     */
    static String getHexString(int decimal) {
        switch (decimal) {
            case 10: return "A";
            case 11: return "B";
            case 12: return "C";
            case 13: return "D";
            case 14: return "E";
            case 15: return "F";
        }
        return Integer.toString(decimal);
    }

    /**
     * Converts a decimal to hex
     * @param decimal The number in base 10 form
     * @return Hexadecimal
     */
    static String decimalToHex(int decimal) {
        if (decimal == 0) return "";
        return decimalToHex(decimal / 16) + getHexString(decimal % 16);
    }

}
