import java.util.*;

class Solution {
    class Interval {
        int l, r, w, id;
        Interval(int l, int r, int w, int id) {
            this.l = l;
            this.r = r;
            this.w = w;
            this.id = id;
        }
    }
    
    // Support for 2D Arrays (Standard LeetCode template for "2D integer array")
    public int[] maximumWeight(int[][] intervals) {
        int n = intervals.length;
        Interval[] arr = new Interval[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Interval(intervals[i][0], intervals[i][1], intervals[i][2], i);
        }
        return solve(arr, n);
    }
    
    // Support for List of Lists
    public int[] maximumWeight(List<List<Integer>> intervals) {
        int n = intervals.size();
        Interval[] arr = new Interval[n];
        for (int i = 0; i < n; i++) {
            List<Integer> list = intervals.get(i);
            arr[i] = new Interval(list.get(0), list.get(1), list.get(2), i);
        }
        return solve(arr, n);
    }
    
    private int[] solve(Interval[] arr, int n) {
        // Sort intervals by start time; use end time as a tie-breaker
        Arrays.sort(arr, (a, b) -> {
            if (a.l != b.l) return Integer.compare(a.l, b.l);
            return Integer.compare(a.r, b.r);
        });
        
        long[][] dpWeight = new long[n + 1][5];
        int[][][] dpIndices = new int[n + 1][5][];
        
        // Base case: 0 elements chosen yields empty arrays
        for (int i = 0; i <= n; i++) {
            for (int k = 0; k <= 4; k++) {
                dpIndices[i][k] = new int[0];
            }
        }
        
        // Process intervals from right to left
        for (int i = n - 1; i >= 0; i--) {
            // Binary search the first interval j that starts strictly after interval i ends
            int j = binarySearch(arr, i + 1, n, arr[i].r);
            
            for (int k = 1; k <= 4; k++) {
                // Option 1: Skip the current interval
                long skipWeight = dpWeight[i + 1][k];
                int[] skipIndices = dpIndices[i + 1][k];
                
                // Option 2: Pick the current interval
                long pickWeight = arr[i].w + dpWeight[j][k - 1];
                int[] nextIndices = dpIndices[j][k - 1];
                
                // Construct the indices array for picking (manually inserting the ID keeps it sorted)
                int len = nextIndices.length;
                int[] pickIndices = new int[len + 1];
                int id = arr[i].id;
                int p = 0;
                
                while (p < len && nextIndices[p] < id) {
                    pickIndices[p] = nextIndices[p];
                    p++;
                }
                pickIndices[p] = id;
                while (p < len) {
                    pickIndices[p + 1] = nextIndices[p];
                    p++;
                }
                
                // Choose the option that gives the maximum weight, 
                // or the lexicographically smaller array in the event of a weight tie
                if (pickWeight > skipWeight) {
                    dpWeight[i][k] = pickWeight;
                    dpIndices[i][k] = pickIndices;
                } else if (pickWeight < skipWeight) {
                    dpWeight[i][k] = skipWeight;
                    dpIndices[i][k] = skipIndices;
                } else {
                    if (isLexicographicallySmaller(pickIndices, skipIndices)) {
                        dpWeight[i][k] = pickWeight;
                        dpIndices[i][k] = pickIndices;
                    } else {
                        dpWeight[i][k] = skipWeight;
                        dpIndices[i][k] = skipIndices;
                    }
                }
            }
        }
        
        return dpIndices[0][4];
    }
    
    // Finds the first interval where start > targetRight
    private int binarySearch(Interval[] arr, int left, int right, int targetRight) {
        int l = left, r = right;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (arr[mid].l > targetRight) {
                r = mid; // First valid candidate could be mid
            } else {
                l = mid + 1; // mid is not valid, search to its right
            }
        }
        return l;
    }
    
    private boolean isLexicographicallySmaller(int[] a, int[] b) {
        int minLen = Math.min(a.length, b.length);
        for (int i = 0; i < minLen; i++) {
            if (a[i] < b[i]) return true;
            if (a[i] > b[i]) return false;
        }
        return a.length < b.length;
    }
}