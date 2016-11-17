package com.interviewbit.DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Find the contiguous subarray within an array (containing at least one number) which has the largest product.

For example, given the array [2,3,-2,4],
the contiguous subarray [2,3] has the largest product = 6.
 *
 */
public class HighestProduct
{
    public int maxProduct(List<Integer> nums) 
    {
        int n = nums.size();
        if( n == 0) return 0;
        
        int maxProduct = nums.get( 0 );
        int min = nums.get( 0 );
        int max = nums.get( 0 );
        
        for( int i =1; i < n; i++ )
        {
            int t = max;
            
            max = Math.max( Math.max( max * nums.get( i ), min * nums.get( i ) ), nums.get( i ) );
            min = Math.min( Math.min( t * nums.get(i), min * nums.get( i ) ), nums.get( i ) );
            
            if( max > maxProduct )
            {
                maxProduct = max;
            }
        }
        return maxProduct;
    }

    
    
    public static void main( String[] args )
    {
        HighestProduct hp = new HighestProduct();
        
        int[] nums ={0, -1, 3, 100, 70, 50};
        
        //System.out.println( " Highest Product = " + hp.maxProduct( nums ) );
    }
}
