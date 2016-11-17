package com.interviewbit.DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
Given a string, find the length of the longest substring without repeating characters. For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
 */
public class LongestIncreasingStringWithoutRepeat
{
    public int lengthOfLongestSubstring(String s) 
    {
        int res = 0; 
        
        int[] T = new int[126];
        
        char[] word = s.toCharArray();
        for( int j =0,i =0; j < word.length; j++ )
        {
            i = Math.max( T[word[j]], i );
            
            res = Math.max( res, j-i +1 );
            
            T[word[j]] = j+1;
        }
        
        return res;
    }
    
    
    public static void main( String[] args )
    {
        LongestIncreasingStringWithoutRepeat hp = new LongestIncreasingStringWithoutRepeat();
        
        //Integer[] nums ={10, 9, 2, 5, 3, 7, 101, 18};
        
        System.out.println( " Longest Increasing sub sequence = " + hp.lengthOfLongestSubstring( "abcabcbb" ) );
    }
}
