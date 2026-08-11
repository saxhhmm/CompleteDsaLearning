/*class Solution {

    static int solve(int amount,int[] coins, int index ){
        //base case
        if(amount == 0 ){
            return 1;
        }
        if(amount<0){
            return 0;
        }
        if(index>= coins.length){
            return 0;
        }

        //1 case khud solve karenge

        int includeAns= solve(amount-coins[index], coins, index);
        int excludeAns= solve(amount, coins,index+1);
        int finalAns= includeAns + excludeAns;
        return finalAns;
        
    }
    public int change(int amount, int[] coins) {
        int index=0;
        int ans= solve(amount,coins,index);
        return ans;
        
    }
}*/
class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        
        // Base case: 1 way to make amount 0 (using no coins)
        dp[0] = 1;

        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }

        return dp[amount];
    }
}