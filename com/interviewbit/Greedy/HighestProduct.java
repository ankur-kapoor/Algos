package com.interviewbit.Greedy;

import java.util.Arrays;

/**
 * Find the contiguous subarray within an array (containing at least one number) which has the largest product.

For example, given the array [2,3,-2,4],
the contiguous subarray [2,3] has the largest product = 6.
 *
 */
public class HighestProduct
{
    public int maxProduct(int[] nums) 
    {
        int n = nums.length;
        if( n == 0) return 0;
        
        int maxProduct = nums[0];
        int min = nums[0];
        int max = nums[0];
        
        int st = 0;
        int k = 0;
        for( int i =1; i < n; i++ )
        {
            int t = max;
            
            max = Math.max( Math.max( max * nums[i], min * nums[i] ), nums[i] );
            min = Math.min( Math.min( t * nums[i], min * nums[i] ), nums[i] );
            
            if( max > maxProduct )
            {
                maxProduct = max;
                k++;
            }
            
            if( k == 3 )
            {
                i = st;
                st++;
                max = nums[st];
                min = nums[st];
            }
        }
        return maxProduct;
    }

    
    
    public static void main( String[] args )
    {
        HighestProduct hp = new HighestProduct();
        
        int[] nums ={0, -1, 3, 100, 70, 50};
        
        System.out.println( " Highest Product = " + hp.maxProduct( nums ) );
    }
}
