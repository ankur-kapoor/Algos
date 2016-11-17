package com.interviewbit.Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array. *
 */

public class MajorityElement
{
    public int majorityElement(final List<Integer> nums) 
    {
        int n = nums.size();
        
        if( n == 1) return nums.get( 0 );
        
        int m = n/2;
        
        
        Collections.sort( nums );
        
        int c = 0;
        int i =0;
        for( ; i < n-1; i++ )
        {
            if( nums.get( i+1 )-nums.get( i ) == 0 )
            {
                c++;
            }
            else
            {
                c = 0;
            }
            
            if( c >= m ) break;
        }
        
        return nums.get( i );
    }
    
    public static void main( String[] args )
    {
        int[] ratings = {5,5,2};
        
        final MajorityElement c = new MajorityElement();
        
        //System.out.println( " Min Candy = " + c.candy( ratings ) );
    }
}
