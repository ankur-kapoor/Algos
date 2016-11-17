package com.interviewbit.Hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 *Given a string, 
find the length of the longest substring without repeating characters.

Example:

The longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3.

For "bbbbb" the longest substring is "b", with the length of 1.
 */

public class RepeatStr
{
    public int lengthOfLongestSubstring(String a) 
    {
        boolean[] flags = new boolean[256];
        
        int start = 0;
        int max = Integer.MIN_VALUE;
        for( int i=0; i< a.length(); i++ )
        {
            char c = a.charAt( i );
            
            if( flags[c] )
            {
                for( int j = start; j < i; j++ )
                {
                    max = Math.max( max, i-start );
                    if( a.charAt( j ) == c )
                    {
                        start = j+1;
                        break;
                    }
                    
                    flags[ a.charAt( j ) ] = false;
                }
            }
            else
            {
                flags[c] = true;
            }
        }
        
        max = Math.max( max, a.length()-start );
        
        return max;
        
    }
    
    public static void main( String[] args )
    {
        RepeatStr t = new RepeatStr();
        
        String[] strArr = {"cat","dog","god","tca"};
        ArrayList<String> ai = new ArrayList<>( Arrays.asList( strArr ));
        
        System.out.println( " Longest SubString = "+ t.lengthOfLongestSubstring( "bbbb" ) );
    }
}
