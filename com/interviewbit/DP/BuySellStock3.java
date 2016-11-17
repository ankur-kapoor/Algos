package com.interviewbit.DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.

You can do at most 2 transaction.
 
 */

public class BuySellStock3
{
    /**
     * Create a 2D DP array, where ith row represents the max no. of transactions permitted, in this case its 2,
     * and jth coloum represents the price of the share at the jth day.
     * 
     * dp[i][j] = Max{ dp[i][j-1], maxDiff + price[j]}
     *            maxDiff = Max{ maxDiff, dp[i-1][j]-price[j]}   
     */
    public int maxProfit(final List<Integer> prices) 
    {
        if( null == prices || prices.size() <= 1 )
        {
            return 0;
        }
        int n = prices.size();
        int[][] dp = new int[3][n];
        int maxDiff = 0;
        for( int i = 1; i < 3; i++ )
        {
            maxDiff = dp[i-1][0]-prices.get( 0 );
            for( int j = 1; j < n; j++ )
            {
                dp[i][j] = Math.max( dp[i][j-1], maxDiff + prices.get( j ) );
                maxDiff = Math.max( maxDiff, dp[i-1][j]-prices.get( j ) );
            }
        }
        
        return dp[2][n-1];
    }
    
    public static void main( String[] args )
    {
        BuySellStock3 hp = new BuySellStock3();
        
        int[] nums ={0, -1, 3, 100, 70, 50};
        
        //System.out.println( " Climbing Stairs " + hp.climbStairs( 4 ) );
    }
}
