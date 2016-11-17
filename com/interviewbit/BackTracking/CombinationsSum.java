package com.interviewbit.BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.interviewbit.LinkedList.ListNode;

/**
 Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 2,3,6,7 and target 7, 
A solution set is: 
[7] 
[2, 2, 3] 
 */
public class CombinationsSum
{
    public ArrayList<ArrayList<Integer>> combinationSum( ArrayList<Integer> a, int t )
    {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>( );
        Collections.sort( a );
        int sum = 0;
        Set<Integer> s = new HashSet<>();
        doCombine( res, a, new ArrayList<Integer>(), a.size(), t, sum, s,"" , 0);
        
        
        
        return res;
    }
    
    private void doCombine( ArrayList<ArrayList<Integer>> res, ArrayList<Integer> a, ArrayList<Integer> path, int n, int t, int sum, Set<Integer> s, String key, int start )
    {
        if( sum > t )
        {
            return;
        }
        
        if( sum == t)
        {
            res.add( new ArrayList<>( path ));
        }
        
        for( int i = start; i< n; i++ )
        {
            if( path.isEmpty() || path.get( path.size()-1 ) <= a.get( i ))
            {
                path.add( a.get( i ) );
                sum += a.get( i );
                doCombine( res, a, path, n, t, sum, s, key, i );
                sum -= a.get( i );
                path.remove( path.size() - 1 );
            }
        }
    }
    
    public static void main( String[] args )
    {
        
        final CombinationsSum r = new CombinationsSum();
        Integer[] li = { 8, 10, 6, 11, 1, 16, 8};
        ArrayList<Integer> ai = new ArrayList<>(Arrays.asList( li )); 
        System.out.println( "Combine " + r.combinationSum( ai, 28 ) );
        
    }
}
