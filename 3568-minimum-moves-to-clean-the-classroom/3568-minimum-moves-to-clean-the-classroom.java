import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length;
        int n = classroom[0].length();
        int[][] litterIds = new int[m][n];
        int startX = -1, startY = -1;
        int litterCount = 0;
        
        // Step 1: Scan the grid to find the start position and assign an ID to each litter
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = classroom[i].charAt(j);
                if (c == 'S') {
                    startX = i;
                    startY = j;
                } else if (c == 'L') {
                    litterIds[i][j] = litterCount++;
                }
            }
        }
        
        // Edge case: No litter to collect
        if (litterCount == 0) {
            return 0;
        }
        
        // Step 2: Initialize our 4D visited array to track unique states
        // Dimensions: [x][y][energy][bitmask]
        boolean[][][][] visited = new boolean[m][n][energy + 1][1 << litterCount];
        
        // Queue will store states as int arrays: {x, y, current_energy, mask}
        Queue<int[]> q = new LinkedList<>();
        int startMask = (1 << litterCount) - 1; // All bits set to 1
        
        q.offer(new int[]{startX, startY, energy, startMask});
        visited[startX][startY][energy][startMask] = true;
        
        // Standard direction arrays for Up, Right, Down, Left
        int[] dirs = {-1, 0, 1, 0, -1};
        int moves = 0;
        
        // Step 3: BFS Traversal
        while (!q.isEmpty()) {
            int size = q.size();
            
            // Process all nodes at the current "move" distance
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                int x = curr[0];
                int y = curr[1];
                int curEnergy = curr[2];
                int mask = curr[3];
                
                // If mask is 0, we have successfully collected all litter!
                if (mask == 0) {
                    return moves;
                }
                
                // If we have no energy left (and didn't just win), we can't make any more moves
                if (curEnergy == 0) {
                    continue;
                }
                
                // Check all 4 adjacent directions
                for (int d = 0; d < 4; d++) {
                    int nx = x + dirs[d];
                    int ny = y + dirs[d + 1];
                    
                    // If within bounds and not an obstacle
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                        char nextCell = classroom[nx].charAt(ny);
                        
                        if (nextCell != 'X') {
                            // Calculate new energy: Instantly maxes out on 'R', otherwise drops by 1
                            int nxtEnergy = (nextCell == 'R') ? energy : curEnergy - 1;
                            int nxtMask = mask;
                            
                            // If it's litter, use bitwise AND with a negated shifted bit to mark it as collected (0)
                            if (nextCell == 'L') {
                                nxtMask &= ~(1 << litterIds[nx][ny]);
                            }
                            
                            // If we have not been in this exact state before, queue it up
                            if (!visited[nx][ny][nxtEnergy][nxtMask]) {
                                visited[nx][ny][nxtEnergy][nxtMask] = true;
                                q.offer(new int[]{nx, ny, nxtEnergy, nxtMask});
                            }
                        }
                    }
                }
            }
            moves++; // Increment move count after processing the current level
        }
        
        // If the queue empties out and we haven't returned, it's impossible.
        return -1; 
    }
}