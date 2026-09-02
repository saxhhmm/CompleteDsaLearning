class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        
        // s1 cannot be a substring of s2 if it is longer than s2
        if (len1 > len2) {
            return false;
        }
        
        int[] count1 = new int[26];
        int[] count2 = new int[26];
        
        // Setup the frequency maps for the very first window
        for (int i = 0; i < len1; i++) {
            count1[s1.charAt(i) - 'a']++;
            count2[s2.charAt(i) - 'a']++;
        }
        
        // Slide the window across s2
        for (int i = 0; i < len2 - len1; i++) {
            // If frequencies match, we found a permutation
            if (matches(count1, count2)) {
                return true;
            }
            
            // Slide the window: add the new character on the right, remove the old character on the left
            count2[s2.charAt(i + len1) - 'a']++;
            count2[s2.charAt(i) - 'a']--;
        }
        
        // Check the very last window after the loop finishes
        return matches(count1, count2);
    }
    
    // Helper function to check if the two frequency arrays are identical
    private boolean matches(int[] count1, int[] count2) {
        for (int i = 0; i < 26; i++) {
            if (count1[i] != count2[i]) {
                return false;
            }
        }
        return true;
    }
}