class Solution {
    public String intToRoman(int num) {
        // Store all possible symbols and their values from largest to smallest
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        
        StringBuilder result = new StringBuilder();
        
        // Loop through the values
        for (int i = 0; i < values.length; i++) {
            // While the number is large enough to use the current symbol
            while (num >= values[i]) {
                num -= values[i];                 // Subtract the value
                result.append(symbols[i]);        // Add the symbol to our answer
            }
        }
        
        return result.toString();
    }
}