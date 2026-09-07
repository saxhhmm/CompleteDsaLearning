class Solution {
    public int distinctSubseqII(String s) {
        int MOD = 1_000_000_007;
        
        // Array to store the number of distinct subsequences ending with each character
        long[] end = new long[26];
        long total = 0; // Total distinct subsequences so far
        
        for (char c : s.toCharArray()) {
            int index = c - 'a';
            
            // The number of new subsequences we can form by adding the current character
            long added = (total + 1) % MOD;
            
            // New total = Old total + newly added - duplicates (which is the old end[index])
            // We add MOD before taking modulo again to handle negative results in Java
            total = (total + added - end[index] + MOD) % MOD;
            
            // Update the number of subsequences ending with this character
            end[index] = added;
        }
        
        return (int) total;
    }
}