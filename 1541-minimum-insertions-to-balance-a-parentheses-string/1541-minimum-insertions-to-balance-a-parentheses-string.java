class Solution {
    public int minInsertions(String s) {
        int insertions = 0;
        int openNeeded = 0; // Number of ')' needed

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                // If we needed an odd number of ')', insert one ')' to close the previous pair
                if (openNeeded % 2 != 0) {
                    insertions++;
                    openNeeded--;
                }
                openNeeded += 2; // Each '(' needs two ')'
            } else { // c == ')'
                openNeeded--;

                // Unexpected ')' without matching '('
                if (openNeeded < 0) {
                    insertions++; // Insert one '('
                    openNeeded += 2; // Now we need one more ')' to pair with the newly inserted '('
                }
            }
        }

        // Add remaining needed ')'
        return insertions + openNeeded;
    }
}