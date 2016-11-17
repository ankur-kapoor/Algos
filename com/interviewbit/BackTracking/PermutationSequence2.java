package com.interviewbit.BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.interviewbit.LinkedList.ListNode;

/**
 The set [1,2,3,…,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order,
We get the following sequence (ie, for n = 3):

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

Note: Given n will be between 1 and 9 inclusive.
 */
public class PermutationSequence2
{
    public String getPermutation( int n, int k )
    {
        final ArrayList<Long> fact = new ArrayList<>();
        final ArrayList<Integer> numbers = new ArrayList<>();
        fact.add( Long.valueOf( 1 ) );
        long f = 1;
        for( int i = 1; i <= n; i++ )
        {
            f = (f*i)%Integer.MAX_VALUE;
            fact.add( f );
            numbers.add( i );
        }
        
        long k1 = k;
        k1--;
        StringBuilder sb = new StringBuilder();
        for( int i = 1; i <=n; i++ )
        {
            int a = (int)(k1/fact.get( n-i ));
            sb.append( numbers.get( a ) );
            numbers.remove( a );
            k1 = k1 - a*fact.get( n-i );
        }
        
        return sb.toString();
    }
    
    
    public static void main( String[] args )
    {
        
        final PermutationSequence2 r = new PermutationSequence2();
        Integer[] li = {1,2,3};
        ArrayList<Integer> ai = new ArrayList<>(Arrays.asList( li )); 
        System.out.println( "Permutation Sequence " + r.getPermutation( 100, 1554 ) );
        
    }
}
