package com.interviewbit.DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 */
public class RodCutting2
{
    public ArrayList<Integer> rodCut( int N, ArrayList<Integer> B ) 
    {
        B.add( 0, 0 );
        B.add( N );
        
        int n = B.size();
        final ArrayList<Integer> res = new ArrayList<>();
        
        final Long[] C = new Long[n];
        
        for( int i=0; i < n; i++ )
        {
            C[i] = Long.valueOf( B.get( i ) );
        }
        
        final Long[][] dp = new Long[n][n];
        final int[][] pIndex = new int[n][n];
        
        recRod( C, dp, pIndex, 0, n-1 );
        
        backTrack( 0, n-1, pIndex, res, B );
        return res;
    }
    
    //f(i,j) = C[j] - C[i] + f(i,k) + f(k,j)
    private Long recRod( final Long[] C, final Long[][] dp, final int[][]pIndex, int i, int j )
    {
        if( i+1 >= j )
        {
            return new Long(0);
        }
        
        if( null != dp[i][j])
        {
            return dp[i][j];
        }
        
        Long retVal = Long.MAX_VALUE;
        
        int bestIndex = 0;
        
        for( int k = i+1; k < j; k++ )
        {
            Long l = C[j] - C[i] + recRod( C, dp, pIndex, i, k ) + recRod( C, dp, pIndex, k, j ) ;
            
            if( l < retVal )
            {
                retVal = l;
                bestIndex = k;
            }
        }
        pIndex[i][j] = bestIndex;
        dp[i][j] = retVal;
        
        return retVal;
    }
    
    private void backTrack( int i, int j, final int[][]pIndex, final ArrayList<Integer> res, final ArrayList<Integer> B )
    {
        if( i+1 >= j )
        {
            return;
        }
        
        res.add( B.get( pIndex[i][j] ) );
        backTrack( i, pIndex[i][j], pIndex, res, B );
        backTrack( pIndex[i][j],j, pIndex, res, B );
    }
    public static void main( String[] args )
    {
        RodCutting2 hp = new RodCutting2();
        
        Integer[] nums ={1, 2, 7, 8};
        int n =9;
        final ArrayList<Integer> a = new ArrayList<>( Arrays.asList( nums ));
        
        System.out.println( " Minium Cost = " + hp.rodCut( n, a ) );
    }
}
