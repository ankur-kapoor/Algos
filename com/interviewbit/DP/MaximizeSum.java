package com.interviewbit.DP;

import java.util.ArrayList;

public class MaximizeSum
{
    public int adjacent( ArrayList<ArrayList<Integer>> a )
    {
        if( null == a || a.size() == 0 ) return 0;
        
        int n = a.get( 0 ).size();
        
        int[][] dp = new int[2][n];
        
        dp[0][1] = Math.max( a.get( 0 ).get( 0 ), a.get( 1 ).get( 0 ) );
        
        for( int i =1; i < n; i++ )
        {
            int cur = Math.max( a.get( 0 ).get( i ), a.get( 1 ).get( i ) );
            
            dp[0][i] = Math.max( dp[0][i-1], dp[1][i-1] );
            dp[1][i] = cur + dp[0][i-1];
        }
        
        return Math.max( dp[0][n-1], dp[1][n-1] );
    }
    
    public static void main( String[] args )
    {
        ArrayList<ArrayList<Integer>> nums = new ArrayList<>();
        
        ArrayList<Integer> a = new ArrayList<>();
        a.add( 74 );
        a.add( 37 );
        a.add( 82 );
        a.add( 1 );
        
        nums.add( a );
        
        a = new ArrayList<>();
        a.add( 66 );
        a.add( 38 );
        a.add( 16 );
        a.add( 1 );
        
        nums.add( a );
        
        final MaximizeSum ms = new MaximizeSum();
        
        System.out.println( "Maximum Sum = "+ ms.adjacent( nums ) );
    }
}
