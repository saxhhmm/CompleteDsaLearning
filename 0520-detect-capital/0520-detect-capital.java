class Solution {
    public boolean detectCapitalUse(String word) {
        int uppercaseCount = 0;
        int n = word.length();

        for (int i = 0; i < n; i++) {
            if (Character.isUpperCase(word.charAt(i))) {
                uppercaseCount++;
            }
        }

        // Case 1: All uppercase
        if (uppercaseCount == n) {
            return true;
        }

        // Case 2: All lowercase
        if (uppercaseCount == 0) {
            return true;
        }

        // Case 3: Only the first character is uppercase
        if (uppercaseCount == 1 && Character.isUpperCase(word.charAt(0))) {
            return true;
        }

        return false;
    }
}