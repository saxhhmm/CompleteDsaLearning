class Solution {
    public int minimumPushes(String word) {
        int n = word.length();
        int pushes = 0;
        int pushCost = 1;
        
        while (n > 0) {
            // We can place up to 8 characters at the current push cost
            int charsToPlace = Math.min(n, 8);
            pushes += charsToPlace * pushCost;
            
            // Decrease the remaining characters and move to the next push cost tier
            n -= charsToPlace;
            pushCost++;
        }
        
        return pushes;
    }
}