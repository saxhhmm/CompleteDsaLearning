class Solution {
    public int[] validSequence(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        
        // Step 1: Precompute how much of word2's suffix can be matched in word1
        int[] rightMatch = new int[n + 1];
        int j = m - 1;
        
        for (int i = n - 1; i >= 0; i--) {
            // If characters match, we successfully matched one more suffix character
            if (j >= 0 && word1.charAt(i) == word2.charAt(j)) {
                rightMatch[i] = rightMatch[i + 1] + 1;
                j--;
            } else {
                rightMatch[i] = rightMatch[i + 1];
            }
        }
        
        // Step 2: Greedily pick indices from left to right
        int[] seq = new int[m];
        int seqIdx = 0;
        boolean usedChange = false;
        j = 0; // Reset j to start of word2
        
        for (int i = 0; i < n && j < m; i++) {
            if (word1.charAt(i) == word2.charAt(j)) {
                // Exact match: always take it immediately
                seq[seqIdx++] = i;
                j++;
            } else if (!usedChange && rightMatch[i + 1] >= m - 1 - j) {
                // Mismatch, but we haven't used our change yet AND 
                // the rightMatch array confirms the REST of word2 can be found ahead.
                usedChange = true;
                seq[seqIdx++] = i;
                j++;
            }
        }
        
        // If we found all characters for word2, return the indices
        if (seqIdx == m) {
            return seq;
        }
        
        // Otherwise, it's impossible
        return new int[0];
    }
}