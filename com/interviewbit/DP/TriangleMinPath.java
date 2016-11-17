package com.interviewbit.DP;

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
public class TriangleMinPath
{
    public int minimumTotal(List<List<Integer>> triangle) 
    {
        int sum = triangle.get( 0 ).get( 0 );
                        
        sum += findMin( triangle, triangle.size(),1, 0, 1 );
        
        return sum;
    }

    private int findMin( List<List<Integer>> a, int n, int row, int i, int j )
    {
        if ( row == n )
        {
            return 0;
        }

        // int minIndex = a.get( row ).get( i ) > a.get( row ).get( j ) ? j : i;

        return Math.min( a.get( row ).get( i ), a.get( row ).get( j ) )
            + Math.min( findMin( a, n, row + 1, i, i + 1 ), findMin( a, n, row + 1, j, j + 1 ) );
    }
    
    public static void main( String[] args )
    {
        TriangleMinPath hp = new TriangleMinPath();
        
        int[] nums ={0, -1, 3, 100, 70, 50};
        
        //System.out.println( " Highest Product = " + hp.maxProduct( nums ) );
    }
}
