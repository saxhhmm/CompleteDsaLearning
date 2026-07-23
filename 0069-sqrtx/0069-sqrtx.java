class Solution {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }

        int left = 1;
        int right = x;
        int ans = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Integer overflow se bachne ke liye long use kiya hai
            if ((long) mid * mid == x) {
                return mid;
            }

            if ((long) mid * mid < x) {
                ans = mid; // Possible answer store kar lo
                left = mid + 1; // Aur bade numbers ke liye check karo
            } else {
                right = mid - 1; // Chote numbers ke liye range shift karo
            }
        }

        return ans;
    }
}