class Solution {
    public String maxSumOfSquares(int num, int sum) {
        // If the required sum is greater than the maximum possible sum with 'num' digits
        if (sum > 9 * num) {
            return "";
        }
        
        StringBuilder sb = new StringBuilder();
        
        // Append as many 9s as possible
        while (sum >= 9 && num > 0) {
            sb.append('9');
            sum -= 9;
            num--;
        }
        
        // Append the remaining sum if there are still digits left
        if (num > 0) {
            sb.append((char) ('0' + sum));
            num--;
        }
        
        // Fill the rest with 0s to maintain the exact length 'num'
        while (num > 0) {
            sb.append('0');
            num--;
        }
        
        return sb.toString();
    }
}