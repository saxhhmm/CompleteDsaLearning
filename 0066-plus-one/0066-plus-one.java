class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        
        // Peeche (right side) se loop shuru karenge
        for (int i = n - 1; i >= 0; i--) {
            // Agar digit 9 se choti hai, toh bas 1 add karo aur array wapas bhej do
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            
            // Agar digit 9 hai, toh wo 0 ban jayegi aur loop agle peeche wale digit par jayega (carry)
            digits[i] = 0;
        }
        
        // Agar yahan tak code aa gaya, iska matlab saare digits 9 the (jaise [9, 9])
        // Toh ek naya array banayenge jiska size ek bada hoga
        int[] newDigits = new int[n + 1];
        newDigits[0] = 1; // Pehla digit 1 hoga, baaki sab by default 0 rahenge
        
        return newDigits;
    }
}