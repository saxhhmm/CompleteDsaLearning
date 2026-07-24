import java.util.HashSet;

class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> seen = new HashSet<>();
        
        // Loop tab tak chalega jab tak n 1 na ho, aur cycle me na fase
        while (n != 1 && !seen.contains(n)) {
            seen.add(n);        // Current number ko set me daal do
            n = getNextSum(n);  // Naya sum nikalo
        }
        
        // Agar n = 1 par ruk gaya hai toh Happy hai, warna cycle me fasa hai
        return n == 1;
    }
    
    // Helper function jo digits ke squares ka sum nikalega
    private int getNextSum(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;       // Aakhiri digit nikalo
            sum += digit * digit;     // Uska square add karo
            n /= 10;                  // Aakhiri digit hata do
        }
        return sum;
    }
}