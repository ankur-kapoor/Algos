package com.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/contests/w20/challenges/divisible-sum-pairs
 * @author ankurkap
 *
 */

public class DivisibleSumPair
{
    
    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int k = in.nextInt();
        
        final int[] a = new int[N];
        
        for( int i =0; i < N; i++ )
        {
            a[i] = in.nextInt();
        }
        
        int res =0;
        for( int i =0; i < N; i++ )
        {
            for( int j =i+1; j < N; j++ )
            {
                if( (a[i] + a[j])%k == 0 )
                {
                   res++; 
                }
            }
        }
        
        System.out.println( res );
        
        in.close();
    }
}
