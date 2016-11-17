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
 *
 */
public class JumpGame
{
    public boolean canJump(ArrayList<Integer> nums) 
    {
        if( null == nums || nums.size() == 0 )
        {
            return false;
        }
        int n = nums.size();
        
        int max = 0;
        for( int i =0; i < n; i++ )
        {
            if( i > max ) return false;
            
            max = Math.max( max, nums.get( i )+i );
        }
        return true;
    }
    
    public static void main( String[] args )
    {
        JumpGame hp = new JumpGame();
        
        int[] nums = {3,2,1,0,4};
        
        //System.out.println( " Can Jump " + hp.canJump( nums ) );
    }
}
