class Solution {
    public int maximumLengthSubstring(String s) {
        int[] freq = new int[26];
        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            int charIndex = s.charAt(right) - 'a';
            freq[charIndex]++;

            // Shrink window from the left if the character appears more than twice
            while (freq[charIndex] > 2) {
                freq[s.charAt(left) - 'a']--;
                left++;
            }

            // Update the maximum length of the valid window
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}