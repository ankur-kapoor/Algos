package com.interviewbit.DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message containing digits, determine the total number of ways to decode it.

For example,
Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

The number of ways decoding "12" is 2.
 */
public class WaysToDecode
{
    public int numDecodings(String s) 
    {
        if( null == s || s.length() == 0 )
        {
            return 0;
        }
        
        int n = s.length();
        int[] d = new int[n+1];
        
        d[0] = 1;
        d[1] = s.charAt( 0 ) != '0' ? 1:0;
        
        for( int i = 2; i <= n ; i++ )
        {
            int f1 = Integer.valueOf(s.substring(i-1, i));  
            int f2 = Integer.valueOf(s.substring(i-2, i));
            
            if( f1>= 1 && f1 <= 9)
            {
                d[i] += d[i-1];
            }
            if( f2>= 10 && f2 <= 26)
            {
                d[i] += d[i-2];
            }
        }
        
        return d[n];
    }
    
    public static void main( String[] args )
    {
        WaysToDecode hp = new WaysToDecode();
        
        int[] nums ={0, -1, 3, 100, 70, 50};
        
        //System.out.println( " Highest Product = " + hp.maxProduct( nums ) );
    }
}
