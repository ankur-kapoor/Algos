package com.hackerearth;

import java.util.Scanner;

/**
 * Ref - https://www.hackerearth.com/may-clash-16/algorithm/least-common-multiple/
 * @author ankurkap
 *
 */
public class LCM
{
    private static long solveLcm( long n )
    {
        if( n == 1) return 1;
        if( n == 2) return 2;
               
        long lcm = lcm(n,n-1);
        long maxLcm = n-1;
        
        long thislcm = lcm;
        for( long i = n-2; i > 0; i-- )
        {
             thislcm = lcm( thislcm, i );
            
            if( thislcm > lcm )
            {
                lcm = thislcm;
                maxLcm = i;
            }
            
        }
        
        return maxLcm;
    }
    
    private static long lcm( long a, long b )
    {
        return a * (b/binaryGcd( a, b ));
    }
    
    private static long binaryGcd(long u, long v) 
    {
        long shift;
        if (u == 0) return v;
        if (v == 0) return u;
       
        for (shift = 0; ((u | v) & 1) == 0; ++shift) {
               u >>= 1;
               v >>= 1;
        }
       
        while ((u & 1) == 0)
          u >>= 1;
       
        do {
             while ((v & 1) == 0)  
                 v >>= 1;

             if (u > v) 
             {
               long t = v; 
               v = u; 
               u = t;
             } 
             
             v = v - u;                       
           } while (v != 0);

        return u << shift;
    }
    
    public static void main( String[] args )
    {
        Scanner in = new Scanner(System.in);
        long N = in.nextLong();
        
        System.out.println( solveLcm( N ));
    }
    
}
