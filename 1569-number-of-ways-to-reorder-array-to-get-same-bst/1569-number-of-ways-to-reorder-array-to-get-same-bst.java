import java.util.ArrayList;
import java.util.List;

class Solution {
    private static final int MOD = 1_000_000_007;
    private long[][] combination;

    public int numOfWays(int[] nums) {
        int n = nums.length;
        combination = new long[n + 1][n + 1];

        // Precompute Pascal's triangle for combinations (nCr)
        for (int i = 0; i <= n; i++) {
            combination[i][0] = 1;
            for (int j = 1; j <= i; j++) {
                combination[i][j] = (combination[i - 1][j - 1] + combination[i - 1][j]) % MOD;
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }

        // Subtract 1 because the problem asks for ways to *reorder* nums, 
        // and the original array itself doesn't count as a "reordering".
        return (int) (dfs(list) - 1 + MOD) % MOD;
    }

    private long dfs(List<Integer> nums) {
        if (nums.size() <= 2) {
            return 1;
        }

        int root = nums.get(0);
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        for (int i = 1; i < nums.size(); i++) {
            int val = nums.get(i);
            if (val < root) {
                left.add(val);
            } else {
                right.add(val);
            }
        }

        long leftWays = dfs(left);
        long rightWays = dfs(right);

        int lSize = left.size();
        int rSize = right.size();

        // Ways to interleave left and right subtree elements: C(lSize + rSize, lSize)
        long ways = combination[lSize + rSize][lSize];
        
        ways = (ways * leftWays) % MOD;
        ways = (ways * rightWays) % MOD;

        return ways;
    }
}