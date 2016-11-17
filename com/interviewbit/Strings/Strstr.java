package com.interviewbit.Strings;

import java.util.StringTokenizer;

/**
 * 
 * strstr - locate a substring ( needle ) in a string ( haystack ). *
 */

public class Strstr
{
    public int strStr(final String haystack, final String needle) 
    {
        if( null == needle || needle.equals( "" )  ) return -1;
        
        if( null == haystack || haystack.equals( "" )  ) return -1;
        
        return  haystack.indexOf( needle );
        
    }
    

    public static void main(String[] args )
    {
        Strstr p = new Strstr();
        System.out.println("Palindrome = " + p.strStr( "This is what",  "what" ) );
    }
}
