import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Integer> reservedMap = new HashMap<>();
        
        // Step 1 & 2: Build the bitmask for each row with reservations
        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int col = seat[1];
            int bit = 0;
            
            if (col == 2 || col == 3) bit = 1;         // 0001
            else if (col == 4 || col == 5) bit = 2;    // 0010
            else if (col == 6 || col == 7) bit = 4;    // 0100
            else if (col == 8 || col == 9) bit = 8;    // 1000
            
            if (bit != 0) {
                reservedMap.put(row, reservedMap.getOrDefault(row, 0) | bit);
            }
        }
        
        // Step 3: Calculate for rows with no reservations at all
        int maxFamilies = (n - reservedMap.size()) * 2;
        
        // Calculate for rows that have at least one reservation
        for (int mask : reservedMap.values()) {
            // Left is free (bits 0 and 1) -> mask & 3 (0011) == 0
            // Right is free (bits 2 and 3) -> mask & 12 (1100) == 0
            // Middle is free (bits 1 and 2) -> mask & 6 (0110) == 0
            
            if ((mask & 3) == 0 && (mask & 12) == 0) {
                maxFamilies += 2;
            } else if ((mask & 3) == 0 || (mask & 12) == 0 || (mask & 6) == 0) {
                maxFamilies += 1;
            }
        }
        
        return maxFamilies;
    }
}