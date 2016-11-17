package com.interviewbit.DP;

import java.util.HashMap;
import java.util.Map;
/**
 * You are given a sequence of black and white horses, and a set of K stables numbered 1 to K. You have to accommodate the horses into the stables in such a way that the following conditions are satisfied:

You fill the horses into the stables preserving the relative order of horses. For instance, you cannot put horse 1 into stable 2 and horse 2 into stable 1. You have to preserve the ordering of the horses.
No stable should be empty and no horse should be left unaccommodated.
Take the product (number of white horses * number of black horses) for each stable and take the sum of all these products. This value should be the minimum among all possible accommodation arrangements
Example:


Input: {WWWB} , K = 2
Output: 0

Explanation:
We have 3 choices {W, WWB}, {WW, WB}, {WWW, B}
for first choice we will get 1*0 + 2*1 = 2.
for second choice we will get 2*0 + 1*1 = 1.
for third choice we will get 3*0 + 0*1 = 0.

Of the 3 choices, the third choice is the best option. 

If a solution is not possible, then return -1
 * @author ankurkap
 *
 */

public class ArrangeII2
{
    public int arrange( String val, int K )
    {
        int N = val.length();
        if( K > N) return -1;
        
        if( K == N) return 0;
        
        Integer[][] dp = new Integer[N][K];
        return calcMin( 0, 0, K, val.toCharArray(), Integer.MAX_VALUE, dp);
        //return min == Integer.MAX_VALUE ? -1 : min;
    }
    
    private int calcMin( int horse, int stable, int K, char[] val, int min, final Integer[][] dp )
    {
        if( horse >= val.length )
        {
            return min;
        }
        
        int w = 0;
        int b = 0;
        
        if( null != dp[horse][stable] )
        {
            return dp[horse][stable];
        }
        
        if( K-1 == stable )
        {
            for( int i = horse; i <val.length; i++ )
            {
                if( val[i] == 'W' )w++;
                else if( val[i] == 'B' )b++;
            }
            min = Math.min( min, 0 ) + w*b;
            
            return min;
        }
        
        for( int i = horse; i <val.length; i++ )
        {
            if( val[i] == 'W' )w++;
            else if( val[i] == 'B' )b++;
            
            min = Math.min( calcMin( i+1, stable+1, K, val, min, dp )+ (w * b), min )  ;
        }
        
        dp[horse][stable] = min;
        
        return min != Integer.MAX_VALUE ? min : -1;
    }
    
    public static void main( String[] args )
    {
        final ArrangeII2 ar = new ArrangeII2();
        
        System.out.println( ar.arrange( "BWBWWWWBWBBWBWBWBBWBBBWWWBWBWBWWWBWBWBWBBWBW", 19 ) ); 
    }
}
