class Solution {
    public int smallestNumber(int n, int t) {
        // Keep checking numbers sequentially starting from n
        while (true) {
            int product = getDigitProduct(n);
            
            // If the product is divisible by t, we found our answer
            if (product % t == 0) {
                return n;
            }
            
            // Otherwise, move to the next number
            n++;
        }
    }
    
    // Helper method to calculate the product of digits of a number
    private int getDigitProduct(int num) {
        int product = 1;
        
        // Extract digits one by one
        while (num > 0) {
            int digit = num % 10;
            product *= digit;
            num /= 10;
        }
        
        return product;
    }
}