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
public class MatrixMinPath
{
    public int minPathSum(ArrayList<ArrayList<Integer>> grid) 
    {
        if( null == grid || grid.size() == 0 )
        {
            return 0;
        }
        
        int m = grid.size();
        int n = grid.get( 0 ).size();
        
        Integer[][] dp = new Integer[m][n];
        dp[m-1][n-1] = grid.get( m-1 ).get( n-1 );
        
        return findMin( grid, 0, 0, dp );
    }
    
    private int findMin( ArrayList<ArrayList<Integer>> grid, int r, int c, Integer[][] dp )
    {
        if( r == grid.size()-1 && c == grid.get(0).size()-1 )
        {
            return grid.get( r ).get( c );
        }
        
        if( dp[r][c] != null )
        {
            return dp[r][c];
        }
        
        if( r == grid.size()-1 )
        {
            dp[r][c] = grid.get( r ).get( c ) + findMin( grid, r, c+1, dp );
            return dp[r][c];
        }
        
        if( c == grid.get( 0 ).size()-1 )
        {
            dp[r][c] = grid.get( r ).get( c ) + findMin( grid, r+1, c, dp ); 
            return dp[r][c];
        }
        
        dp[r][c] = grid.get( r ).get( c ) + Math.min( findMin( grid, r+1, c, dp ), findMin( grid, r, c+1, dp ) ); 
        
        return dp[r][c];
    }
    
    public static void main( String[] args )
    {
        MatrixMinPath hp = new MatrixMinPath();
        
        int[][] nums ={{5,0,1,1,2,1,0,1,3,6,3,0,7,3,3,3,1},
            {1,4,1,8,5,5,5,6,8,7,0,4,3,9,9,6,0},
            {2,8,3,3,1,6,1,4,9,0,9,2,3,3,3,8,4},
            {3,5,1,9,3,0,8,3,4,3,4,6,9,6,8,9,9},
            {3,0,7,4,6,6,4,6,8,8,9,3,8,3,9,3,4},
            {8,8,6,8,3,3,1,7,9,3,3,9,2,4,3,5,1},
            {7,1,0,4,7,8,4,6,4,2,1,3,7,8,3,5,4},
            {3,0,9,6,7,8,9,2,0,4,6,3,9,7,2,0,7},
            {8,0,8,2,6,4,4,0,9,3,8,4,0,4,7,0,4},
            {3,7,4,5,9,4,9,7,9,8,7,4,0,4,2,0,4},
            {5,9,0,1,9,1,5,9,5,5,3,4,6,9,8,5,6},
            {5,7,2,4,4,4,2,1,8,4,8,0,5,4,7,4,7},
            {9,5,8,6,4,4,3,9,8,1,1,8,7,7,3,6,9},
            {7,2,3,1,6,3,6,6,6,3,2,3,9,9,4,4,8}};
        
        //System.out.println( " Min Path = " + hp.minPathSum( nums ) );
    }
}
