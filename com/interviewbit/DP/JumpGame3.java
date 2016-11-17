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

// Using Greedy/DP
 *
 */
public class JumpGame3
{
    public int jump(ArrayList<Integer> nums) 
    {
        if( null == nums || nums.size() < 2 )
        {
            return 0;
        }
        
        int curr = 0;
        int nextMax = 0;
        int i = 0;
        int l = 0;
        
        while( curr-i+1 > 0 )
        {
            l++;
            
            for( ; i <= curr; i++ )
            {
                nextMax = Math.max( nextMax, nums.get( i )+i );
                
                if( nextMax >= nums.size()-1 ) return l;
            }
            
            if( curr == nextMax ) return -1;
            curr = nextMax;
        }
        
        return -1;
    }
    
    public static void main( String[] args )
    {
        JumpGame3 hp = new JumpGame3();
        
        int[] nums = {5,6,4,4,6,9,4,4,7,4,4,8,2,6,8,1,5,9,6,5,2,7,9,7,9,6,9,4,1,6,8,8,4,4,2,0,3,8,5};
        
        //System.out.println( " Min Jump " + hp.jump( nums ) );
    }
}
