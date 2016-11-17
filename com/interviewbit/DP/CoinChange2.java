package com.interviewbit.DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
Given a value N, if we want to make change for N cents, and we have infinite supply of each of S = { S1, S2, .. , Sm} valued coins, how many ways can we make the change? The order of coins doesn’t matter.

For example, for N = 4 and S = {1,2,3}, there are four solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}. So output should be 4. For N = 10 and S = {2, 5, 3, 6}, there are five solutions: {2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} and {5,5}. So the output should be 5.

 */
public class CoinChange2
{
    public int coinchange2(ArrayList<Integer> a, int n )
    {
        int m = a.size();
                        
        final int[][] dp = new int[m+1][n+1];
        
        for( int i =0; i <= n; i++ )
        {
            dp[0][i] = 0;
        }
        
        for( int i =0; i <= m; i++ )
        {
            dp[i][0] = 1;
        }
        
        for( int i = 1; i <= m; i++ )
        {
            for( int j = 1; j <= n; j++ )
            {
                if( j >= a.get( i-1 ))
                {
                    dp[i][j] = (dp[i-1][j]%1000007 + dp[i][j-a.get( i-1 )]%1000007)%1000007;
                }
                else
                {
                    dp[i][j] = dp[i-1][j]%1000007;
                }
            }
        }
        
        return dp[m][n];
    }
    
    
    public static void main( String[] args )
    {
        CoinChange2 hp = new CoinChange2();
        
        Integer[] nums ={2, 5, 3, 6};
        
        final ArrayList<Integer> a = new ArrayList<>(Arrays.asList( nums ));
        System.out.println( " Coin Change = " + hp.coinchange2( a, 10 ) );
    }
}
