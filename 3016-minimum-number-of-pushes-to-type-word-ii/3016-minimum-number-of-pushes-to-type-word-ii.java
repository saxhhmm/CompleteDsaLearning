import java.util.Arrays;

class Solution {
    public int minimumPushes(String word) {
        int[] count = new int[26];
        for (char c : word.toCharArray()) {
            count[c - 'a']++;
        }
        
        // Sort frequencies in ascending order
        Arrays.sort(count);
        
        int totalPushes = 0;
        for (int i = 0; i < 26; i++) {
            // Pick from the back (highest frequencies first)
            int freq = count[26 - 1 - i];
            if (freq == 0) {
                break;
            }
            totalPushes += freq * (i / 8 + 1);
        }
        
        return totalPushes;
    }
}