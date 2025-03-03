package com.hanteo.test.coin;

public class CoinTest {
    public static int countCoin(int[] coins, int sum) {
        int[] dp = new int[sum + 1];
        dp[0] = 1;

        for (int coin : coins) {
            for (int i = coin; i <= sum; i++) {
                dp[i] += dp[i - coin];
            }
        }

        return dp[sum];
    }

    public static void main(String[] args) {
        int sum = 10;
        int[] coins = {2, 5, 3, 6};
        System.out.println(countCoin(coins, sum));
    }
}
