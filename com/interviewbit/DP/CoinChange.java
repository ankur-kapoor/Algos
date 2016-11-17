package com.interviewbit.DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
Given a value N, if we want to make change for N cents, and we have infinite supply of each of S = { S1, S2, .. , Sm} valued coins, how many ways can we make the change? The order of coins doesn’t matter.

For example, for N = 4 and S = {1,2,3}, there are four solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}. So output should be 4. For N = 10 and S = {2, 5, 3, 6}, there are five solutions: {2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} and {5,5}. So the output should be 5.

 */
public class CoinChange
{
    public int count(int[] a, int n )
    {
        final List<List<Integer>> res = new ArrayList<>();
        final List<Integer> path = new ArrayList<>();
        
        Arrays.sort( a );
        
        solveCoins( a, n, 0, path, 0, res );
        
        System.out.println( "Result Set = " + res );
        
        return res.size();
    }
    
    private void solveCoins( int[]a, int n, int s, List<Integer> path, int sum, List<List<Integer>> res)
    {
        if( sum == n  )
        {
            res.add( new ArrayList<>(path) );
            return;
        }
        
        if( sum > n )
        {
            return;
        }
        
        for( int i = s; i < a.length; i++ )
        {
            path.add( a[i] );
            sum += a[i];
            solveCoins( a, n, i, path, sum, res );
            path.remove( path.size()-1 );
            sum -= a[i];
        }
    }
    
    public static void main( String[] args )
    {
        CoinChange hp = new CoinChange();
        
        int[] nums ={2, 5, 3, 6};
        
        System.out.println( " Coin Change = " + hp.count( nums, 10 ) );
    }
}
