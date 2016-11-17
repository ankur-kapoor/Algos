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
Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
A solution set is: 
[1, 7] 
[1, 2, 5] 
[2, 6] 
[1, 1, 6]  
 */
public class CombinationsSum2
{
    public ArrayList<ArrayList<Integer>> combinationSum( ArrayList<Integer> a, int t )
    {
        final Map<String, ArrayList<Integer>> resMap = new LinkedHashMap<>();
        
        Collections.sort( a );
        int sum = 0;
        Set<Integer> s = new HashSet<>();
        doCombine( resMap, a, new ArrayList<Integer>(), a.size(), t, sum, s, 0);
        
        ArrayList<ArrayList<Integer>> res = new ArrayList<>(  resMap.values());
        
        return res;
    }
    
    private void doCombine( final Map<String, ArrayList<Integer>> resMap, ArrayList<Integer> a, ArrayList<Integer> path, int n, int t, int sum, Set<Integer> s, int start )
    {
        if( sum > t )
        {
            return;
        }
        
        if( sum == t)
        {
            resMap.put( getKey( path ), new ArrayList<>( path ));
            return;
        }
        
        for( int i = start; i< n; i++ )
        {
            if( path.isEmpty() || path.get( path.size()-1 ) <= a.get( i ))
            {
                path.add( a.get( i ) );
                sum += a.get( i );
                doCombine( resMap, a, path, n, t, sum, s, i+1 );
                sum -= a.get( i );
                path.remove( path.size() - 1 );
            }
        }
    }
    
    private String getKey( ArrayList<Integer> a )
    {
        final StringBuilder st = new StringBuilder();
        for( int num : a )
        {
            st.append( num ).append( "-" );
        }
        
        return st.toString();
    }
    
    public static void main( String[] args )
    {
        
        final CombinationsSum2 r = new CombinationsSum2();
        Integer[] li = { 10,1,2,7,6,1,5};
        ArrayList<Integer> ai = new ArrayList<>(Arrays.asList( li )); 
        System.out.println( "Combine " + r.combinationSum( ai, 8 ) );
        
    }
}
