class Solution {
    public int numRookCaptures(char[][] board) {
        int rookRow = -1;
        int rookCol = -1;
        
        // Step 1: Find the position of the Rook ('R')
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == 'R') {
                    rookRow = i;
                    rookCol = j;
                    break;
                }
            }
            if (rookRow != -1) {
                break;
            }
        }
        
        int captures = 0;
        // 4 directions: Up, Down, Left, Right
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        // Step 2: Explore each direction
        for (int[] dir : directions) {
            int r = rookRow;
            int c = rookCol;
            
            while (true) {
                r += dir[0];
                c += dir[1];
                
                // Stop if out of bounds
                if (r < 0 || r >= 8 || c < 0 || c >= 8) {
                    break;
                }
                // Stop if blocked by a white bishop
                if (board[r][c] == 'B') {
                    break;
                }
                // Capture if a black pawn is found, then stop
                if (board[r][c] == 'p') {
                    captures++;
                    break;
                }
            }
        }
        
        return captures;
    }
}