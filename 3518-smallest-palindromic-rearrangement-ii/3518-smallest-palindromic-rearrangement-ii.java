

class Solution {
    public String smallestPalindrome(String s, int k) {
        int n = s.length();
        int[] count = new int[26];
        for (int i = 0; i < n; i++) {
            count[s.charAt(i) - 'a']++;
        }

        // Half character frequencies
        int[] halfCount = new int[26];
        char midChar = 0;
        for (int i = 0; i < 26; i++) {
            halfCount[i] = count[i] / 2;
            if (count[i] % 2 != 0) {
                midChar = (char) ('a' + i);
            }
        }

        int halfLen = n / 2;
        
        // Total valid permutations check
        long totalPerms = countPermutations(halfCount, halfLen, k);
        if (totalPerms < k) {
            return "";
        }

        StringBuilder firstHalf = new StringBuilder();

        for (int i = 0; i < halfLen; i++) {
            for (int c = 0; c < 26; c++) {
                if (halfCount[c] > 0) {
                    halfCount[c]--;
                    
                    // Count permutations remaining with candidate 'c'
                    long ways = countPermutations(halfCount, halfLen - 1 - i, k);
                    
                    if (ways >= k) {
                        firstHalf.append((char) ('a' + c));
                        break; // Move to next character position
                    } else {
                        k -= ways;
                        halfCount[c]++; // Backtrack candidate
                    }
                }
            }
        }

        // Construct full palindrome
        StringBuilder result = new StringBuilder(firstHalf);
        if (midChar != 0) {
            result.append(midChar);
        }
        result.append(new StringBuilder(firstHalf).reverse());

        return result.toString();
    }

    // Corrected multinomial coefficient calculator with safe capping
    private long countPermutations(int[] counts, int totalLen, long limit) {
        long ways = 1;
        int remaining = totalLen;
        
        for (int i = 0; i < 26; i++) {
            int cnt = counts[i];
            for (int j = 1; j <= cnt; j++) {
                ways = ways * (remaining - cnt + j) / j;
                if (ways >= limit) {
                    return limit; // Safe cap to prevent overflow without distorting logic
                }
            }
            remaining -= cnt;
        }
        return Math.min(ways, limit);
    }
}