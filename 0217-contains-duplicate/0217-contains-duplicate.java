import java.util.HashSet;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();

        for (int num : nums) {
            // Agar number pehle se set me hai, matlab duplicate hai
            if (seen.contains(num)) {
                return true;
            }
            // Warna set me daal do
            seen.add(num);
        }

        // Agar saare elements unique nikle
        return false;
    }
}