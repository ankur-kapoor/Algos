package com.interviewbit.Strings;

import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 
 * Write a function to find the longest common prefix string amongst an array of strings.

Longest common prefix for a pair of strings S1 and S2 is the longest string S which is the prefix of both S1 and S2.

As an example, longest common prefix of "abcdefgh" and "abcefgh" is "abc".

Given the array of strings, you need to find the longest S which is the prefix of ALL the strings in the array.

Example:

Given the array as:

[

  "abcdefgh",

  "aefghijk",

  "abcefgh"
]
The answer would be “a”.

 */

public class LCP
{
    public String longestCommonPrefix(ArrayList<String> a) 
    {
        String res = "";
        
        int minLength = Integer.MAX_VALUE;
        
        for( int i =0; i< a.size(); i++)
        {
            if( a.get( i ).length() < minLength )
            {
                minLength = a.get( i ).length();
            }
        }
        
        for( int i =0; i< minLength; i++)
        {
            boolean isSame = true;
            char ch = a.get( 0 ).charAt( i );
            for( int j =1; j< a.size(); j++)
            {
                if(a.get( j ).charAt( i ) != ch )
                {
                    isSame = false;
                    break;
                }
            }
            
            if( isSame )
            {
                res += String.valueOf( ch );
            }
            else
            {
                break;
            }
        }
        
        return res;
    }
    
    public static void main(String[] args )
    {
        LCP p = new LCP();
       // System.out.println("Version Comparisons = " + p.longestCommonPrefix( "444444444444444444444444",  "4444444444444444444444444" ) );
    }
}
