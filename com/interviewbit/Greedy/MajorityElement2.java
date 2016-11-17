package com.interviewbit.Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times. The algorithm should run in linear time and in O(1) space.

Hint:

How many majority elements could it possibly have?
*/

public class MajorityElement2
{
    public List<Integer> majorityElement(int[] nums) 
    {
        
        int n = nums.length;
        final List<Integer> res = new ArrayList<>();
        
        if( n == 0)
        {
            return res;
        }
        if( n == 1)
        {
            res.add( nums[0] );
            return res;
        }
        
        int m = n/3;
        Arrays.sort( nums );
        
        int c = 1;
        int prev = nums[0];
        
        for(int i=1 ; i < n; i++ )
        {
            if( nums[i]-prev == 0 )
            {
                c++;
            }
            else
            {
                if( c > m )
                {
                    res.add( prev );
                }
                c = 1;
            }
            prev = nums[i];
        }
        
        if( c > m )
        {
            res.add( prev );
        }
        
        return res;
    }
    
    public static void main( String[] args )
    {
        int[] ratings = {5,5,2};
        
        final MajorityElement2 c = new MajorityElement2();
        
        //System.out.println( " Min Candy = " + c.candy( ratings ) );
    }
}
