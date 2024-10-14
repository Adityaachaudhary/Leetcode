class Solution {
    //top down dp solution
    /*private int[] dp = new int[31];
    public int fib(int n) {
        if(n <= 1)
        return n ;
        if( n == 2)
        return 1;
        memoize(n);
        return dp[n];
    }
    public int memoize(int n){
        if(dp[n] != 0)
        return dp[n];
        if(n<3)
        return 1;
        else
        dp[n] = memoize(n-1) + memoize(n-2);
        return memoize(n);
    }
        
}*/

//bottom up 
public int fib(int n){
    if(n==0) return 0;
    int[] dp= new int[n+1];
    dp[0] = 0;
    dp[1] = 1;
    for(int i =2;i<=n;i++){
        dp[i] = dp[i-1] + dp[i-2];
    }
    return dp[n];
}
}
