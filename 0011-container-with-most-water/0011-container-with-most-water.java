class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxWater = 0;

        while (left < right) {
            // Width dono pointers ke beech ka distance hai
            int width = right - left;
            
            // Paani utna hi bharega jitni chhoti wall ki height hogi
            int currentHeight = Math.min(height[left], height[right]);
            
            // Current container ka area
            int currentWater = width * currentHeight;
            
            // Maximum area ko update kar lo
            maxWater = Math.max(maxWater, currentWater);

            // Jis taraf ki wall choti hai, use aage badhao
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxWater;
    }
}