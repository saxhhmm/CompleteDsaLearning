class Solution {
    public int minOperations(String s) {
        int n = s.length();
        boolean isSorted = true;
        char[] cs = s.toCharArray();
        
        char mn = cs[0], mx = cs[0];
        for (int i = 1; i < n; ++i) {
            mn = (char) Math.min(mn, cs[i]);
            mx = (char) Math.max(mx, cs[i]);
            if (cs[i] < cs[i - 1]) {
                isSorted = false;
            }
        }

        // If already sorted
        if (isSorted) {
            return 0;
        }

        // If length is 2 and out of order, it's impossible
        if (n == 2) {
            return -1;
        }

        // If the smallest char is already at the beginning or largest is at the end
        if (cs[0] == mn || cs[n - 1] == mx) {
            return 1;
        }

        // If min or max character lies in the interior
        for (int i = 1; i < n - 1; ++i) {
            if (cs[i] == mn || cs[i] == mx) {
                return 2;
            }
        }

        // Worst case: min is at the end and max is at the beginning
        return 3;
    }
}