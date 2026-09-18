import java.util.*;

class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        int n = s.length();
        int[] first = new int[26];
        int[] last = new int[26];
        Arrays.fill(first, -1);
        Arrays.fill(last, -1);
        
        // Step 1: Record the first and last occurrence of each character
        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';
            if (first[c] == -1) {
                first[c] = i;
            }
            last[c] = i;
        }
        
        List<int[]> intervals = new ArrayList<>();
        
        // Step 2: Expand ranges for every character to form valid candidates
        for (int i = 0; i < 26; i++) {
            if (first[i] == -1) continue;
            
            int start = first[i];
            int end = last[i];
            boolean isValid = true;
            
            for (int j = start; j <= end; j++) {
                int c = s.charAt(j) - 'a';
                // If a character inside starts before our interval, this candidate is invalid
                if (first[c] < start) {
                    isValid = false;
                    break;
                }
                // Expand end boundary if necessary
                end = Math.max(end, last[c]);
            }
            
            if (isValid) {
                intervals.add(new int[]{start, end});
            }
        }
        
        // Step 3: Sort intervals by end time for Greedy selection
        intervals.sort((a, b) -> Integer.compare(a[1], b[1]));
        
        List<String> result = new ArrayList<>();
        int prevEnd = -1;
        
        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];
            
            // Greedily pick non-overlapping valid substrings
            if (start > prevEnd) {
                result.add(s.substring(start, end + 1));
                prevEnd = end;
            }
        }
        
        return result;
    }
}