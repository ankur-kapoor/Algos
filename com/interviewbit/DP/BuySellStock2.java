package com.interviewbit.DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 */
public class BuySellStock2
{
    public int maxProfit(final List<Integer> prices) 
    {
        if( null == prices || prices.size() == 0 )
        {
            return 0;
        }
        
        if( prices.size() == 1 )
        {
            return 0;
        }
        
        int maxProfit = 0;
        for( int i =1; i < prices.size(); i++ )
        {
            if( prices.get(i)-prices.get( i-1 ) > 0 )
            {
                maxProfit += prices.get( i )-prices.get( i-1 );
            }
        }
        
        return maxProfit;
    }
    
    public static void main( String[] args )
    {
        BuySellStock2 hp = new BuySellStock2();
        
        int[] nums ={0, -1, 3, 100, 70, 50};
        
        //System.out.println( " Climbing Stairs " + hp.climbStairs( 4 ) );
    }
}
