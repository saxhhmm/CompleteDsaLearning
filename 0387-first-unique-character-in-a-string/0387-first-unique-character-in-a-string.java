class Solution {
    public int firstUniqChar(String s) {
        int[] freq = new int[26];
        
        // Step 1: Count the frequency of each character
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }
        
        // Step 2: Find the first character with a frequency of 1
        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        
        // Step 3: If no unique character exists, return -1
        return -1;
    }
}