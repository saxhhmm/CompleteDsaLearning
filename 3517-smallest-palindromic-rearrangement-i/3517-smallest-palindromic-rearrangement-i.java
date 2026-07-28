import java.util.Arrays;

class Solution {
    public String smallestPalindrome(String s) {
        int n = s.length();
        int halfLen = n / 2;
        
        // Extract the first half of the string
        char[] half = s.substring(0, halfLen).toCharArray();
        
        // Sort to get lexicographically smallest order
        Arrays.sort(half);
        
        String sortedHalf = new String(half);
        StringBuilder sb = new StringBuilder(sortedHalf);
        
        // If odd length, append the middle character
        if (n % 2 != 0) {
            sb.append(s.charAt(halfLen));
        }
        
        // Append the reversed sorted half to complete the palindrome
        sb.append(new StringBuilder(sortedHalf).reverse());
        
        return sb.toString();
    }
}