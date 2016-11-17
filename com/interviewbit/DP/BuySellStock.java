package com.interviewbit.DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 */
public class BuySellStock
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
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int minIndex = 0;
        int maxProfit = Integer.MIN_VALUE;
        for( int i =0; i < prices.size(); i++ )
        {
            if( prices.get( i ) < min )
            {
                min = prices.get( i );
                minIndex = i;
                max = Integer.MIN_VALUE;
            }
            
            if( i >= minIndex && prices.get( i ) > max )
            {
                max = prices.get( i );
            }
            
            if( max != Integer.MIN_VALUE && min != Integer.MAX_VALUE  && (max-min) > maxProfit)
            {
                    maxProfit = (max-min);
            }
        }
        
        return maxProfit;
    }
    
    public static void main( String[] args )
    {
        BuySellStock hp = new BuySellStock();
        
        int[] nums ={0, -1, 3, 100, 70, 50};
        
        //System.out.println( " Climbing Stairs " + hp.climbStairs( 4 ) );
    }
}
