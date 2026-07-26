class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // Ek HashSet banaya jo current window ke elements ko track karega
        HashSet<Integer> window = new HashSet<>();
        
        for (int i = 0; i < nums.length; i++) {
            // Agar current element pehle se set me hai, matlab duplicate mil gaya distance k ke andar
            if (window.contains(nums[i])) {
                return true;
            }
            
            // Element ko window me add kar do
            window.add(nums[i]);
            
            // Agar window ka size k se bada ho jata hai, toh sabse pehle (leftmost) element ko hata do
            if (window.size() > k) {
                window.remove(nums[i - k]);
            }
        }
        
        // Agar poore loop me koi duplicate nahi mila, toh false return kar do
        return false;
    }
}
