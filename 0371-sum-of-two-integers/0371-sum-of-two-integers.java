class Solution {
    public int getSum(int a, int b) {
        // Jab tak carry zero nahi ho jata, loop chalega
        while (b != 0) {
            // Carry nikalne ke liye AND operator aur left shift use karte hain
            int carry = (a & b) << 1;
            
            // Bina carry ke sum ke liye XOR operator use karte hain
            a = a ^ b;
            
            // Carry ko b me assign kar dete hain taaki next iteration me add ho sake
            b = carry;
        }
        
        return a;
    }
}