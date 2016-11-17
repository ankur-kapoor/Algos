package com.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/contests/hourrank-8/challenges/whats-next
 * @author ankurkap
 *
 */

public class WhatNext
{
    
    private static void solve( long[] a )
    {
        int N = a.length;
        
        long rem = -1;
        long lastBit;
        long lastBit2 = -1;
        int lastIndex=0;
        
        if( N%2 != 0 )
        {
            lastBit = a[N-1];
            lastIndex = N-1;
            if( N-2 >= 0 )
            {
                lastBit2 = a[N-2];
                lastIndex = N-2;
            }
            rem = -1;
        }
        else
        {
            if( N-2 >=0 )
            {
                lastBit = a[N-2];
                lastIndex = N-1;
            }
            else
            {
                System.out.println( 0 );
                return;
            }
            
            if( N-3 >=0 )
            {
                lastBit2 = a[N-3];
                lastIndex = N-3;
            }
            
            rem = a[N-1];
        }
        
        lastBit--;
        if( lastBit2 > -1 )
        {
            lastBit2--;
        }
        
        lastBit = lastBit > 0 ? lastBit : -1;
        lastBit2 = lastBit2 > 0 ? lastBit2 : -1;
        
        long lastBit3 = 1;
        long lastBit4 = 1;
        
        
       final List<Long> b = new ArrayList<>();
       
       for( int i=0; i < lastIndex; i++ )
       {
           b.add( a[i] );
       }
       
       if( lastBit2 != -1 )
       {
           b.add( lastBit2 );
       }
       
       b.add( lastBit3 );
       b.add( lastBit4 );
       
       if( lastBit != -1 )
       {
           b.add( lastBit );
       }
       
       if( rem != -1 )
       {
           b.add( rem );
       }
       
       System.out.println(b.size());
       
       for( long l : b )
       {
           System.out.print( l + " ");
       }
       
       System.out.println("");
    }
    
    
    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for( int i =0; i <T; i++ )
        {
            int n = in.nextInt();
            long[] a = new long[n];
            for( int j=0; j < n; j++ )
            {
                a[j] = in.nextLong();
            }
            
            solve( a );
        }
        
        in.close();
    }
}
