class Solution {
    public boolean sumGame(String num) {
        int n = num.length();
        int sum1 = 0, sum2 = 0;
        int q1 = 0, q2 = 0;
        
        // Process the first half of the string
        for (int i = 0; i < n / 2; i++) {
            char c = num.charAt(i);
            if (c == '?') {
                q1++;
            } else {
                sum1 += c - '0';
            }
        }
        
        // Process the second half of the string
        for (int i = n / 2; i < n; i++) {
            char c = num.charAt(i);
            if (c == '?') {
                q2++;
            } else {
                sum2 += c - '0';
            }
        }
        
        // If the total number of '?' is odd, Alice gets the last move and always wins
        if ((q1 + q2) % 2 != 0) {
            return true;
        }
        
        // If total '?' is even, check if Bob's optimal pairing strategy can balance the sums
        int sumDiff = sum1 - sum2;
        int qDiff = q1 - q2;
        
        if (sumDiff + (qDiff / 2) * 9 == 0) {
            return false; // Bob wins
        }
        
        return true; // Alice wins
    }
}