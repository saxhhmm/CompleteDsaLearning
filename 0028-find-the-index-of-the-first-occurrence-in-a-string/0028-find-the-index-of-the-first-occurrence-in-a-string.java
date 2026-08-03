 class Solution {
    public int strStr(String haystack, String needle) {
        int hLen = haystack.length();
        int nLen = needle.length();
        
        // Loop through haystack up to the point where needle can still fit
        for (int i = 0; i <= hLen - nLen; i++) {
            int j = 0;
            // Check characters one by one
            while (j < nLen && haystack.charAt(i + j) == needle.charAt(j)) {
                j++;
            }
            // If we matched the entire needle, return the starting index i
            if (j == nLen) {
                return i;
            }
        }
        
        return -1;
    }
}