package com.interviewbit.DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
Given two words A and B, find the minimum number of steps required to convert A to B. (each operation is counted as 1 step.)

You have the following 3 operations permitted on a word:

Insert a character
Delete a character
Replace a character
Example : 
edit distance between
"Anshuman" and "Antihuman" is 2.

Operation 1: Replace s with t.
Operation 2: Insert i.
 */
public class LongestIncSub
{
    public int lis(final List<Integer> nums) 
    {
        if( nums == null || nums.size() == 0 )
        {
            return 0;
        }
        int n = nums.size();
        
        if( n == 1 ) return 1;
        
        int[] T = new int[n];
        
        for( int i =0;i < n; i++ )
        {
            T[i] = 1;
        }
        
        int i = 1;
        int j = 0;
        int max = 1;
        while( i < n )
        {
            while( j < i )
            {
                if( nums.get( j ) < nums.get( i ))
                {
                    T[i] = Math.max( T[i], T[j]+1 );
                    max = Math.max( max, T[i]);
                }
                j++;
            }
            j =0;
            i++;
        }
        
        return max;
    }
    
    
    public static void main( String[] args )
    {
        LongestIncSub hp = new LongestIncSub();
        
        Integer[] nums ={10, 9, 2, 5, 3, 7, 101, 18};
        
        System.out.println( " Longest Increasing sub sequence = " + hp.lis( Arrays.asList( nums ) ) );
    }
}
