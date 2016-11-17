package com.hackerearth;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * https://www.hackerearth.com/june-easy-16/algorithm/benny-and-shopping/
  * @author ankurkap
 *
 */

public class BinnyShopping
{
    
    private static void solve( final String s )
    {
        final String ss = s.substring( s.indexOf( '$' )+1 );
        
        final char[] ssChar = ss.toCharArray();
        
        String res = "";
        for( int i =0; i < ssChar.length; i++ )
        {
            int t = ssChar[i]-'0';
            if( t >= 0 && t<= 9 )
            {
                if( t == 0 && res.equals( "" ))
                {
                    continue;
                }
                else
                {
                    res += t;
                }
            }
            else if( ssChar[i] != ' ')
            {
                break;
            }
        }
        
        if( res.equals( "" ))
        {
            res = "0";
        }
        
        res = "$"+res;
        System.out.println( res );
    }
    
    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        
        in.nextLine();
        final long[] a = new long[N];
        for( int k=0; k < N ; k++ )
        {
            final String s = in.nextLine();
            solve(s);
        }
        
        in.close();
    }
}
