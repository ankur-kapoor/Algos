package com.interviewbit.DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing all ones and return its area.
 *
 */
public class MaxRectangle
{
    public int maximalRectangle(ArrayList<ArrayList<Integer>> matrix) 
    {
        int maxArea = 0;
        final List<Integer> a = new ArrayList<>();
        
        for( int i =0; i < matrix.size(); i++ )
        {
            for( int j =0; j < matrix.get( 0 ).size(); j++ )
            {
                int num = matrix.get( i ).get( j );
                if( i == 0 )
                {
                    a.add( num );
                }
                else
                {
                    if( num == 0 )
                    {
                        a.set( j, num );
                    }
                    else
                    {
                        a.set( j, a.get( j ) + num );
                    }
                }
            }
            
            maxArea = Math.max( maxRectangle( a ), maxArea );
        }
        
        return maxArea;
    }
    
    private int maxRectangle( final List<Integer> a )
    {
        int i=0; 
        int n = a.size();
        
        final Stack<Integer> s = new Stack<>();
        int maxArea = 0;
        while( i < n )
        {
            if( s.isEmpty() || a.get( s.peek() ) < a.get( i ))
            {
                s.push( i++ );
            }
            else 
            {
                int c = s.pop();
                int m = a.get( c ) * ( s.isEmpty() ? i : i - s.peek() -1 );
                
                if( m > maxArea )
                {
                    maxArea = m;
                }
            }
        }
        
        while( !s.isEmpty())
        {
            int c = s.pop();
            int m = a.get( c ) * ( s.isEmpty() ? i : i - s.peek() -1 );
            
            if( m > maxArea )
            {
                maxArea = m;
            }
        }
        
        return maxArea;
    }
   /* public static void main( String[] args )
    {
        MaxRectangle hp = new MaxRectangle();
        
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
    }*/
}
