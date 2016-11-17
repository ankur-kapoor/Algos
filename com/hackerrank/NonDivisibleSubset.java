package com.hackerrank;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/contests/w20/challenges/divisible-sum-pairs
 * @author ankurkap
 *
 */

public class NonDivisibleSubset
{
    
    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        long k = in.nextLong();
        
        final long[] a = new long[N];
       
        for( int i =0; i < N; i++ )
        {
            a[i] = in.nextLong();
        }
        
       
        int maxRes = Integer.MIN_VALUE;
        int res = N;
        while( maxRes != 0 )
        {
            maxRes =0 ;
            int maxI = Integer.MIN_VALUE;
            
            for( int i =0; i < N ; i++ )
            {
                if( a[i] != -1 )
                {
                    int c = 0;
                    for( int j =0; j < N ; j++ )
                    {
                        if( i != j && a[j] != -1 )
                        {
                            if( (a[i] + a[j])%k == 0 )
                            {
                                c++;
                            }
                        }
                    }
                    
                    if( c > maxRes )
                    {
                        maxRes = c;
                        maxI = i;
                    }
                }
            }
            
            if( maxRes > 0 && maxI != Integer.MIN_VALUE )
            {
                a[maxI] = -1;
                res--;
            }
        }
        
        System.out.println( res );
        
        in.close();
    }
}
