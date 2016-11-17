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
public class PermutationSequence
{
    public String getPermutation( int n, int k )
    {
        int[] c = new int[1];
        
        c[0] = 0;
        List<Integer> res = new ArrayList<>();
        doCombine( 1, n, c, k, new ArrayList<Integer>(), res);
        
        return getKey( res );
    }
    
    private String getKey( List<Integer> a )
    {
        StringBuilder strB = new StringBuilder();
        for( int num : a )
        {
            strB.append( num );
        }
        
        return strB.toString();
    }
    private void doCombine( int start, int n, int[] c, int k, List<Integer> path, List<Integer> res )
    {
        if( !res.isEmpty())
        {
            return;
        }
        
        if( path.size() == n)
        {
            c[0]++;
            if( c[0] == k )
            {
                res.addAll( new ArrayList<>( path) );
            }
            
            return;
        }
        
        for( int i =0; i<= path.size(); i++ )
        {
            if( isValid( path, start ))
            {
                ArrayList<Integer> p2 = new ArrayList<>(path);
                p2.add( i, start );
                doCombine( start+1, n, c, k, p2, res );
                if( !res.isEmpty())
                {
                    return;
                }
            }
        }
        
    }
    
    
    private boolean isValid( List<Integer> a, int b )
    {
        for( int x : a )
        {
            if( x == b ) return false;
        }
        
        return true;
    }
    
    public static void main( String[] args )
    {
        
        final PermutationSequence r = new PermutationSequence();
        Integer[] li = {1,2,3};
        ArrayList<Integer> ai = new ArrayList<>(Arrays.asList( li )); 
        System.out.println( "Permutation Sequence " + r.getPermutation( 3, 2 ) );
        
    }
}
