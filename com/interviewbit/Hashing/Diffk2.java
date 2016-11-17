package com.interviewbit.Hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Given an array A of integers and another non negative integer k, find if there exists 2 indices i and j such that A[i] - A[j] = k, i != j.

Example :

Input :

A : [1 5 3]
k : 2
Output :

1
as 3 - 1 = 2

Return 0 / 1 for this problem.
 */

public class Diffk2
{
    public int diffPossible( final List<Integer> a, int k )
    {
        final Map<Integer,Integer> m = new HashMap<>();
        
        for ( int i = 0; i < a.size(); i++ )
        {
            if ( m.containsKey( a.get( i ) + k ) || m.containsKey( a.get( i ) - k ) )
            {
                return 1;
            }
            else
            {
                m.put( a.get( i ), i );
            }
        }

        return 0;
    }
    
    public static void main( String[] args )
    {
        Diffk2 t = new Diffk2();
        
        Integer[] li = { 4, 7, -4, 2, 2, 2, 3, -5, -3, 9, -4, 9, -7, 7, -1, 9, 9, 4, 1, -4, -2, 3, -3, -5, 4, -7, 7, 9, -4, 4, -8};
        
        ArrayList<Integer> ai = new ArrayList<>( Arrays.asList( li ));
        
        System.out.println( " Two Sum indicies = "+ t.diffPossible( ai, 2 ) );
    }
}
