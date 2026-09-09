class Solution {
    public long countCommas(long n) {
        long total = 0;
        long threshold = 1000;
        
        // Count how many numbers cross each 1,000x boundary
        while (n >= threshold) {
            total += n - threshold + 1;
            threshold *= 1000;
        }
        
        return total;
    }
}