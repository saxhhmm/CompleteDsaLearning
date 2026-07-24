class Solution {
    public int[] countBits(int n) {
        // Output array banaya n + 1 size ka (kyunki 0 se n tak jana hai)
        int[] ans = new int[n + 1];
        
        // Base case: ans[0] default 0 hi rahega, isliye loop 1 se start kiya
        for (int i = 1; i <= n; i++) {
            // i >> 1 ka matlab hai i / 2
            // i & 1 ka matlab hai i % 2 (odd hone par 1 dega, even par 0)
            ans[i] = ans[i >> 1] + (i & 1);
        }
        
        return ans;
    }
}