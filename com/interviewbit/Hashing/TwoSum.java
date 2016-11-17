package com.interviewbit.Hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution.

Example:
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
 */

public class TwoSum
{
    public ArrayList<Integer> twoSum(final List<Integer> nums, int target) 
    {
        final Map<Integer, Integer> evalMap = new HashMap<>();
        final ArrayList<Integer> res = new ArrayList<>();
        for( int i =0; i < nums.size(); i++ )
        {
            if( evalMap.containsKey( target - nums.get( i ) ))
            {
                res.add( evalMap.get( target - nums.get( i ) ) );
                res.add( i + 1 );
                
                return res;
            }
            if( !evalMap.containsKey( nums.get( i ) ))
            {
                evalMap.put( nums.get( i ), i+1 );
            }
            
        }
        
        return res;
    }
    
    
    public static void main( String[] args )
    {
        TwoSum t = new TwoSum();
        
        Integer[] li = { 4, 7, -4, 2, 2, 2, 3, -5, -3, 9, -4, 9, -7, 7, -1, 9, 9, 4, 1, -4, -2, 3, -3, -5, 4, -7, 7, 9, -4, 4, -8};
        
        ArrayList<Integer> ai = new ArrayList<>( Arrays.asList( li ));
        
        System.out.println( " Two Sum indicies = "+ t.twoSum( ai, -3 ) );
    }
}
