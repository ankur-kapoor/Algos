package com.hackerrank;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *https://www.hackerrank.com/contests/hourrank-9/challenges/mandragora
 * @author ankurkap
 *
 */

public class Mandragora
{
    
    private static long solve( final long[] a) 
    {
        int N = a.length;
        final Map<Long,Long> map = new HashMap<>();
        
        long sum = 0;
        for( int i= N-1; i >=0; i--)
        {
            sum += a[i];
            map.put( 1L*i, sum );
        }
        
        long S = 1L;
        int i = 0;
        int j = N-1;
        
        long maxVal = Long.MIN_VALUE;
        while( i <= j )
        {
            int mid = (i+j)/2;
            
            long lMid = 1L*(mid);
            long SS = S + lMid;
            
            long sLeft = (SS -1L) * (mid > 0 ? map.get( lMid-1L ) : 1);
            long sCenter = SS * map.get( lMid );
            long sRight = (SS +1L) * (mid < N-1 ? map.get( lMid+1L ) : 1);
            
            if( sCenter >= sLeft && sCenter >= sRight )
            {
                return sCenter;
            }
            else if( sLeft > sCenter )
            {
                j = mid-1;
            }
            else 
            {
                i = mid+1;
            }
            
            maxVal = Math.max( sLeft, Math.max( sCenter, sRight ) );
        }
        
        return maxVal;
    }
    
    
    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        
        for( int i =0; i < T; i++)
        {
            int N = in.nextInt();
            final long[] a = new long[N];
            for( int j =0; j < N; j++ )
            {
                a[j] = in.nextLong();
            }
            
            Arrays.sort( a );
            System.out.println(solve(a));
        }
        
        in.close();
        //System.out.println(m) ;
    }
}
