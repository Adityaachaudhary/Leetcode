class Solution {
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int[][] dp = new int[n][n];

        for(int i = 0;i<n;i++){
            dp[i][i] = piles[i];
        }

        for(int l = 2;l<=n;l++){
            for(int i = 0;i<=n-l;i++){
                int j = i+ l - 1;

                int left = piles[i] - dp[i+1][j];
                int right = piles[j] - dp[i][j-1];

                dp[i][j] = Math.max(left, right);
            }
        }

        return dp[0][n-1] > 0;
        
    }
}