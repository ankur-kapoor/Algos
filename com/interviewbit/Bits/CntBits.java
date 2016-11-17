package com.interviewbit.Bits;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 *We define f(X, Y) as number of different corresponding bits in binary representation of X and Y. For example, f(2, 7) = 2, since binary representation of 2 and 7 are 010 and 111, respectively. The first and the third bit differ, so f(2, 7) = 2.

You are given an array of N positive integers, A1, A2 ,…, AN. Find sum of f(Ai, Aj) for all pairs (i, j) such that 1 ≤ i, j ≤ N. Return the answer modulo 109+7.

For example,

A=[1, 3, 5]

We return

f(1, 1) + f(1, 3) + f(1, 5) + 
f(3, 1) + f(3, 3) + f(3, 5) +
f(5, 1) + f(5, 3) + f(5, 5) =

0 + 1 + 1 +
1 + 0 + 2 +
1 + 2 + 0 = 8
 *
 */
public class CntBits
{
    public int cntBits(ArrayList<Integer> A) 
    {
        int n = A.size();
        
        long res = 0;
        for( int i =0; i < n ;i++)
        {
            for( int j =0; j < n ;j++)
            {
                int x = A.get( i ) ^ A.get( j );
                
                res += (long)Integer.bitCount( x );
            }
        }
        
        return (int)(res%1000000007);
    }
    
    public static void main( String[] args )
    {
        CntBits nb = new CntBits();
        
        Integer[] nums = {1, 2, 4, 4,3, 3, 2, 2, 3, 1, 1};
        
        final List<Integer> numList = Arrays.asList( nums );
        
        final ArrayList<Integer> aList = new ArrayList<>(numList);
        
        System.out.println( "Reverse= " + nb.cntBits( aList ) );
    }
}
