import java.util.Arrays;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Array to store the last seen index of each ASCII character
        int[] charIndex = new int[128];
        
        // Initialize all indices to -1 (meaning not seen yet)
        Arrays.fill(charIndex, -1);
        
        int left = 0;
        int maxLength = 0;
        
        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            
            // If the character was seen and is within the current window, move the left pointer
            if (charIndex[currentChar] >= left) {
                left = charIndex[currentChar] + 1;
            }
            
            // Update the last seen index of the current character
            charIndex[currentChar] = right;
            
            // Update the maximum length of the valid window
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
}