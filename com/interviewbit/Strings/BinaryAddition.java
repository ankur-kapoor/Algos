package com.interviewbit.Strings;

import java.util.StringTokenizer;

/**
 * 
 * Given two binary strings, return their sum (also a binary string).

Example:

a = "100"

b = "11"
Return a + b = “111”.
 *
 */

public class BinaryAddition
{
    public String addBinary(String a, String b) 
    {
        int n = a.length();
        int m = b.length();
        
        int T = n > m ? n :m;
        //char[] res = new char[T+1];
        
        int i =n-1; 
        int j =m-1;
        String res = "";
        int cr = 0;
        while( i >=0 && j >= 0 )
        {
            int c1 = Integer.valueOf( a.charAt( i-- )-'0');
            
            int c2 = Integer.valueOf( b.charAt( j-- )-'0');
            
            int t = c1+c2+cr;
            
            if( t == 2 )
            {
                cr = 1;
                res = 0 + res; 
            }
            else if( t == 3 )
            {
                cr = 1;
                res = 1 + res;
            }
            else 
            {
                cr = 0;
                res = t + res;
            }
        }
        
        while( i >=0 )
        {
            int c1 = Integer.valueOf( a.charAt( i-- )-'0');
            
            int t = c1 + cr;
            
            if( t == 2 )
            {
                cr = 1;
                res = 0 + res; 
            }
            else if( t == 3 )
            {
                cr = 1;
                res = 1 + res;
            }
            else 
            {
                cr = 0;
                res = t + res;
            }
            
        }
        
        while( j >= 0 )
        {
            int c1 = Integer.valueOf( b.charAt( j-- )-'0');
            
            int t = c1 + cr;
            
            if( t == 2 )
            {
                cr = 1;
                res = 0 + res; 
            }
            else if( t == 3 )
            {
                cr = 1;
                res = 1 + res;
            }
            else 
            {
                cr = 0;
                res = t + res;
            }
        }
        
        if( cr > 0 )
        {
            res = cr + res;
        }
        
        return res;
    }

    
    public static void main(String[] args )
    {
        BinaryAddition p = new BinaryAddition();
        System.out.println("Binary Addition = " + p.addBinary( "1001",  "11" ) );
    }
}
