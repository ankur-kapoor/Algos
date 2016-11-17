package com.interviewbit.DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

For example:
A = [2,3,1,1,4], return true.

A = [3,2,1,0,4], return false.

// Using BackTracking - very inefficient 
 *
 */
public class JumpGame2
{
    private int min = Integer.MAX_VALUE;
    public int jump(int[] nums) 
    {
        if( null == nums || nums.length == 0 )
        {
            return 0;
        }
        
        final List<Integer> res = new ArrayList<Integer>();
        calculateJump( nums, res , 0 );
        
        return min;
    }
    
    private boolean calculateJump( int[] nums, final List<Integer> res, int index )
    {
        if( nums[index]+index >= nums.length )
        {
            return true;
        }
        
        if( nums[index] == 0)
        {
            return false;
        }
        
        int jump = nums[index];
        
        while( jump > 0 )
        {
            res.add( nums[index] );
            if( calculateJump( nums, res, index+jump-- ))
            {
                min = Math.min( res.size(), min );
            }
            res.remove( res.size()-1 );
        }
        
        return false;
    }
    
    public static void main( String[] args )
    {
        JumpGame2 hp = new JumpGame2();
        
        int[] nums = {5,6,4,4,6,9,4,4,7,4,4,8,2,6,8,1,5,9,6,5,2,7,9,7,9,6,9,4,1,6,8,8,4,4,2,0,3,8,5};
        
        System.out.println( " Min Jump " + hp.jump( nums ) );
    }
}
