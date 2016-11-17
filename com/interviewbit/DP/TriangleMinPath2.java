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
 * Using Bottom Up approach
 */
public class TriangleMinPath2
{
    public int minimumTotal(ArrayList<ArrayList<Integer>> a ) 
    {
        final List<Integer> res = new ArrayList<>();
        int n = a.size();
        
        res.addAll( a.get( n-1 ) );
        
        for( int i = n-2; i >=0; i-- )
        {
            for( int j = 0; j <= i; j++ )
            {
                res.set( j, Math.min( res.get( j ), res.get( j+1 ) )+ a.get( i ).get( j ) );
            }
        }
        
        return res.get( 0 );
    }

        
    public static void main( String[] args )
    {
        TriangleMinPath2 hp = new TriangleMinPath2();
        
        //int[] nums ={0, -1, 3, 100, 70, 50};
        
        Integer[][] nums = {{2},{3,4},{6,5,7},{4,1,8,3}};
        
        //List<List<Integer>> tri = new ArrayList<>( A )
        //System.out.println( " Min Path Sum = " + hp.minimumTotal( nums ) );
    }
}
