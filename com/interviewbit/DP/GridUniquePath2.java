package com.interviewbit.DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 *
 */
public class GridUniquePath2
{
    public int uniquePathsWithObstacles(ArrayList<ArrayList<Integer>> dp ) 
    {
        if( null == dp || dp.size() == 0 )
        {
            return 0;
        }
        
        int m = dp.size();
        int n = dp.get( 0 ).size();
        
        for( int i = 0; i < m; i++ )
        {
            for( int j = 0; j < n; j++ )
            {
                if( dp.get( i ).get( j ) == 1 )
                {
                    dp.get( i ).set( j, -1 );
                }
            }
        }
        
        boolean f = false;
        for( int i = 0; i < m ; i++ )
        {
            if( dp.get( i ).get( 0 ) == -1 )
            {
                f = true;
                continue;
            }
            
            dp.get( i ).set( 0, f ? -1: 1 );
        }
        
        f= false;
        
        for( int i = 0; i < n ; i++ )
        {
            if( dp.get( 0 ).get( i ) == -1 )
            {
                f = true;
                continue;
            }
            dp.get( 0 ).set( i, f ? -1: 1 );
        }
        
        for( int i =1; i < m; i++ )
        {
            for( int j =1; j < n; j++ )
            {
                if( dp.get( i ).get( j ) == -1 ) continue;
                
                if( dp.get(i-1).get( j ) != -1 && dp.get( i ).get( j-1 ) != -1 )
                {
                    dp.get( i ).set( j, dp.get( i-1 ).get( j ) + dp.get( i ).get(j-1) );
                }
                else if( dp.get( i-1 ).get( j ) != -1 )
                {
                    dp.get( i ).set( j, dp.get( i-1 ).get( j ) );
                }
                else if( dp.get( i ).get( j-1 ) != -1 )
                {
                    dp.get( i ).set( j, dp.get( i ).get( j-1 ) );
                }
                else
                {
                    dp.get( i ).set( j, -1 );
                }
            }
        }
        
        if( dp.get( m-1 ).get( n-1 ) == -1 )
        {
            return 0;
        }
        
        return dp.get( m-1 ).get( n-1 );
    }
    
    public static void main( String[] args )
    {
        GridUniquePath2 hp = new GridUniquePath2();
        
        int[][] nums ={{1,0}};
        
        //System.out.println( " Min Path = " + hp.uniquePathsWithObstacles( nums ) );
    }
}
