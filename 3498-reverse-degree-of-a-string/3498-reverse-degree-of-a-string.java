class Solution {
    public int reverseDegree(String s) {
        int total = 0;
        int n = s.length();
        
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            
            // Reversed alphabet position: 'a' = 26, 'b' = 25, ..., 'z' = 1
            int reverseAlphabetValue = 'z' - c + 1;
            
            // String index is 1-based (i + 1)
            int stringPosition = i + 1;
            
            total += reverseAlphabetValue * stringPosition;
        }
        
        return total;
    }
}