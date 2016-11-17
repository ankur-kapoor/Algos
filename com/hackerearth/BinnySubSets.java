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

public class BinnySubSets
{
    private static long MOD = 10000007L;
    private static void solve( final long[] a, long X)
    {
        int N = a.length;
        
        long res = 0L;
        for( int i =1; i < 1<<N; i++ )
        {
            long xor = -1L;
            for( int j =0 ; j < N ; j++ )
            {
                if( (i &(1<<j)) != 0 )
                {
                    if( xor == -1L )
                    {
                        xor = a[j];
                    }
                    else
                    {
                        xor ^= a[j];
                    }
                }
            }
            
            if( xor == X )
            {
                res = (res+1L)%MOD;
            }
        }
        
        System.out.println( res );
    }
    
    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        long X = in.nextLong();
        
        final long[] a = new long[N];
        for( int k=0; k < N ; k++ )
        {
            a[k] = in.nextLong();
        }
        
        solve( a, X );
        
        in.close();
    }
}
