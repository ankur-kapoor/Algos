package com.interviewbit.DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a number N, return number of ways you can draw N chords in a circle with 2*N points such that no 2 chords intersect.
Two ways are different if there exists a chord which is present in one way and not in other.

For example,

N=2
If points are numbered 1 to 4 in clockwise direction, then different ways to draw chords are:
{(1-2), (3-4)} and {(1-4), (2-3)}

So, we return 2. 
 */

public class Chords
{
    /**
     * This number generation pattern is also called as CATALAN numbers 
     * 
     * Presumptions - 
     * 
     * T[0] - 1
     * T[1] - 1  i.e. when n =1 , then only 1 BST is possible.
     *    
     */
    
    public int chordCnt(int n) 
    {
        if( n < 1 ) return 1;
        
        long[] T = new long[n+1];
        
        T[0] =1;
        T[1] =1;
        
        for( int i = 2; i <= n; i++ )
        {
            for( int j = 0; j < i; j++ )
            {
                T[i] = (T[i] + (T[j] * T[i-j-1])%1000000007)%1000000007;
            }
        }
        
        return (int)T[n];
    }
    
    public static void main( String[] args )
    {
        Chords hp = new Chords();
        
        System.out.println( " No. of BSTs possible = " + hp.chordCnt( 22 ) );
    }
}
