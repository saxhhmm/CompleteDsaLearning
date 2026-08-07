/*class Solution{
    public int climbStairs(int n){
        //base case
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }

        int ans= climbStairs(n-1) + climbStairs(n-2);
        return ans;

    



    }
*/
class Solution {
    public int climbStairs(int n) {
        // Base cases: 1 step has 1 way, 2 steps have 2 ways
        if (n <= 2) {
            return n;
        }
        
        int prev2 = 1; // Represents ways to reach step n-2
        int prev1 = 2; // Represents ways to reach step n-1
        
        // Start calculating from step 3 up to n
        for (int i = 3; i <= n; i++) {
            int current = prev1 + prev2; // The core Fibonacci logic
            prev2 = prev1;               // Shift prev2 up
            prev1 = current;             // Shift prev1 up
        }
        
        return prev1; // prev1 will hold the answer for step n
    }
}