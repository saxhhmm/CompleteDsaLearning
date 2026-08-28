class Solution {
    public String lexPalindromicPermutation(String s, String target) {
        int n = s.length();
        int[] count = new int[26];
        
        // Step 1: Count character frequencies
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        
        int oddCount = 0;
        char midChar = 0;
        for (int i = 0; i < 26; i++) {
            if (count[i] % 2 != 0) {
                oddCount++;
                midChar = (char) (i + 'a');
            }
        }
        
        // A palindrome cannot be formed if more than 1 character has an odd frequency
        if (oddCount > 1) {
            return "";
        }
        
        int half = n / 2;
        int[] halfFreq = new int[26];
        for (int i = 0; i < 26; i++) {
            halfFreq[i] = count[i] / 2;
        }
        
        // Step 2 & 3: Try to match the first half of the target for as long as possible
        int maxMatch = 0;
        while (maxMatch < half && halfFreq[target.charAt(maxMatch) - 'a'] > 0) {
            halfFreq[target.charAt(maxMatch) - 'a']--;
            maxMatch++;
        }
        
        // Step 4: If we matched the entire first half perfectly, check if the resulting palindrome is strictly greater
        if (maxMatch == half) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < half; i++) {
                sb.append(target.charAt(i));
            }
            String firstHalfStr = sb.toString();
            String fullPal = firstHalfStr + (oddCount == 1 ? midChar : "") + new StringBuilder(firstHalfStr).reverse().toString();
            
            if (fullPal.compareTo(target) > 0) {
                return fullPal;
            }
        }
        
        // Step 5: Divergence using Backtracking 
        int startPos = maxMatch;
        if (startPos == half) {
            startPos--;
            if (startPos >= 0) {
                halfFreq[target.charAt(startPos) - 'a']++; // Restore for backtracking
            }
        }
        
        for (int i = startPos; i >= 0; i--) {
            char tChar = target.charAt(i);
            char chosen = 0;
            
            // Find the smallest available character strictly greater than tChar
            for (int c = tChar - 'a' + 1; c < 26; c++) {
                if (halfFreq[c] > 0) {
                    chosen = (char) (c + 'a');
                    break;
                }
            }
            
            // If we found a valid divergence point, construct the new half and return the full palindrome
            if (chosen != 0) {
                StringBuilder sb = new StringBuilder();
                sb.append(target.substring(0, i));
                sb.append(chosen);
                halfFreq[chosen - 'a']--;
                
                // Greedily append remaining characters in ascending order
                for (int c = 0; c < 26; c++) {
                    while (halfFreq[c] > 0) {
                        sb.append((char) (c + 'a'));
                        halfFreq[c]--;
                    }
                }
                
                String firstHalfStr = sb.toString();
                return firstHalfStr + (oddCount == 1 ? midChar : "") + new StringBuilder(firstHalfStr).reverse().toString();
            }
            
            // Backtrack: Restore the target character to the pool if divergence failed
            if (i > 0) {
                halfFreq[target.charAt(i - 1) - 'a']++;
            }
        }
        
        return "";
    }
}