class Solution {
    private Boolean[][][] memo;
    private int m, n;

    public boolean hasValidPath(char[][] grid) {
        m = grid.length;
        n = grid[0].length;

        // An odd total path length can never form balanced parentheses
        if ((m + n - 1) % 2 != 0) return false;
        // Path must start with '(' and end with ')'
        if (grid[0][0] == ')' || grid[m - 1][n - 1] == '(') return false;

        int maxBalance = (m + n) / 2;
        memo = new Boolean[m][n][maxBalance + 1];

        return dfs(grid, 0, 0, 0);
    }

    private boolean dfs(char[][] grid, int r, int c, int balance) {
        // Update balance for current cell
        balance += (grid[r][c] == '(') ? 1 : -1;

        // Invalid if balance drops below 0 or exceeds half the path length
        if (balance < 0 || balance > (m + n) / 2) return false;

        // Base case: reached bottom-right cell
        if (r == m - 1 && c == n - 1) {
            return balance == 0;
        }

        // Return memoized result if already computed
        if (memo[r][c][balance] != null) {
            return memo[r][c][balance];
        }

        boolean possible = false;

        // Move Right
        if (c + 1 < n) {
            possible |= dfs(grid, r, c + 1, balance);
        }

        // Move Down
        if (!possible && r + 1 < m) {
            possible |= dfs(grid, r + 1, c, balance);
        }

        return memo[r][c][balance] = possible;
    }
}