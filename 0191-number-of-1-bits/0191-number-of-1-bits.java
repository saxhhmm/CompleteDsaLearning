class Solution {
    public int hammingWeight(int n) {
        int count = 0;
        
        while (n != 0) {
            // Har step me rightmost set bit (1) ko hata dete hain
            n = n & (n - 1);
            count++;
        }
        
        return count;
    }
}