/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        
        while (left < right) {
            // Safe way to find the middle without integer overflow
            int mid = left + (right - left) / 2;
            
            if (isBadVersion(mid)) {
                // If mid is bad, the first bad version is either mid or before mid
                right = mid;
            } else {
                // If mid is good, the first bad version must be strictly after mid
                left = mid + 1;
            }
        }
        
        // left and right will eventually point to the exact same version
        return left;
    }
}