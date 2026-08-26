class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        String bestStr = "";
        int left = 0;
        int ones = 0;
        
        for (int right = 0; right < s.length(); right++) {
            // Expand the window
            if (s.charAt(right) == '1') {
                ones++;
            }
            
            // Shrink the window if we have too many 1s, 
            // or if we have exactly k 1s but the leftmost character is a 0 (unnecessary length)
            while (ones > k || (ones == k && s.charAt(left) == '0')) {
                if (s.charAt(left) == '1') {
                    ones--;
                }
                left++;
            }
            
            // If we have exactly k ones, evaluate this substring
            if (ones == k) {
                String candidate = s.substring(left, right + 1);
                
                if (bestStr.isEmpty() || 
                    candidate.length() < bestStr.length() || 
                   (candidate.length() == bestStr.length() && candidate.compareTo(bestStr) < 0)) {
                    bestStr = candidate;
                }
            }
        }
        
        return bestStr;
    }
}