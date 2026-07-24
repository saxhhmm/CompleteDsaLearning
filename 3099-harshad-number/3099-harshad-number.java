class Solution {
    public int sumOfTheDigitsOfHarshadNumber(int x) {
        int sum = 0;
        int temp = x;
        
        // Step 1: Digits ka sum nikalna
        while (temp > 0) {
            sum += temp % 10; // Aakhiri digit nikal kar add karo
            temp /= 10;       // Aakhiri digit ko hata do
        }
        
        // Step 2: Check karna ki number sum se divisible hai ya nahi
        if (x % sum == 0) {
            return sum;
        } else {
            return -1;
        }
    }
}