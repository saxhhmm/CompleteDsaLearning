class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        
        int start = 0;
        int end = 0;
        
        for (int i = 0; i < s.length(); i++) {
            // Check for odd length palindrome (center is one character)
            int len1 = expandAroundCenter(s, i, i);
            
            // Check for even length palindrome (center is between i and i+1)
            int len2 = expandAroundCenter(s, i, i + 1);
            
            // Get the max length from the two cases
            int len = Math.max(len1, len2);
            
            // If we found a longer palindrome, update the start and end pointers
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        
        // Return the longest palindromic substring
        return s.substring(start, end + 1);
    }
    
    private int expandAroundCenter(String s, int left, int right) {
        // Expand outwards as long as the characters match and we stay in bounds
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // Return the length of the palindrome found
        // Subtract 1 because the loop breaks when characters don't match or go out of bounds
        return right - left - 1;
    }
}