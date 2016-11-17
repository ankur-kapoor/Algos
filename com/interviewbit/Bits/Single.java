package com.interviewbit.Bits;

import java.util.Arrays;
import java.util.List;

/**
 * 
 *Given an array of integers, every element appears twice except for one. Find that single one.

Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Example :

Input : [1 2 2 3 1]
Output : 3
 *
 */
public class Single
{
    public int singleNumber(final List<Integer> a) 
    {
        int res = 0;
        
        for( int num : a)
        {
            res ^= num;
        }
        
        return res;
    }
    
    public static void main( String[] args )
    {
        Single nb = new Single();
        
        Integer[] nums = {1,2,2,1,3};
        
        final List<Integer> numList = Arrays.asList( nums );
        
        System.out.println( "Duplicate Missing= " + nb.singleNumber( numList ) );
    }
}
