import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        
        for (int i = 0; i <= rowIndex; i++) {
            row.add(1); // Add a 1 at the end for the current row
            
            // Update elements from right to left to avoid overwriting needed values
            for (int j = i - 1; j > 0; j--) {
                row.set(j, row.get(j) + row.get(j - 1));
            }
        }
        
        return row;
    }
}