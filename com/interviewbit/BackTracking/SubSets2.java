package com.interviewbit.BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.interviewbit.LinkedList.ListNode;

/**
 Given a collection of integers that might contain duplicates, nums, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If nums = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
]
 */
public class SubSets2
{
    public ArrayList<ArrayList<Integer>> subsetsWithDup( ArrayList<Integer> a )
    {
        final Map<String,ArrayList<Integer>> resMap = new LinkedHashMap<>();

        Collections.sort( a );
        
        usingDfs( a, 0, new ArrayList<Integer>(), resMap, "" );
        
        final ArrayList<ArrayList<Integer>> res = new ArrayList<>( resMap.values());

        return res;
    }
    
    private void usingDfs( final ArrayList<Integer> a, int in, final ArrayList<Integer> paths, final Map<String,ArrayList<Integer>> res, String key )
    {
        if( !res.containsKey( key ))
        {
            res.put( key, new ArrayList<Integer>(paths));
        }
        
        for( int i = in; i < a.size(); i++ )
        {
            paths.add( a.get( i ) );
            key = getKey( paths );
            usingDfs( a, i+1, paths, res, key );
            paths.remove( paths.size()-1 );
        }
    }
    
    private String getKey( ArrayList<Integer> a )
    {
        StringBuilder st = new StringBuilder();
        
        for( int num : a )
        {
            st.append( num );
        }
        
        return st.toString();
    }
    
    public static void main( String[] args )
    {
        
        final SubSets2 r = new SubSets2();
        Integer[] li = {1,2,2};
        ArrayList<Integer> ai = new ArrayList<>(Arrays.asList( li )); 
        System.out.println( "Sub set" + r.subsetsWithDup( ai ) );
        
    }
}
