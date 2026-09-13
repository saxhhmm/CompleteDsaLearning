import java.util.*;

class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        List<int[]> ones1 = new ArrayList<>();
        List<int[]> ones2 = new ArrayList<>();
        
        // Step 1: Collect coordinates of all 1s in both images
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (img1[i][j] == 1) ones1.add(new int[]{i, j});
                if (img2[i][j] == 1) ones2.add(new int[]{i, j});
            }
        }
        
        // Step 2 & 3: Tally the required shifts to align pairs of 1s
        // We use an offset of 'n' to avoid negative indices (shifts range from -n+1 to n-1)
        int[][] shiftCount = new int[2 * n][2 * n];
        int maxOverlap = 0;
        
        for (int[] p1 : ones1) {
            for (int[] p2 : ones2) {
                int dx = p2[0] - p1[0] + n;
                int dy = p2[1] - p1[1] + n;
                
                shiftCount[dx][dy]++;
                maxOverlap = Math.max(maxOverlap, shiftCount[dx][dy]);
            }
        }
        
        return maxOverlap;
    }
}