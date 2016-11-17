package com.interviewbit.BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.interviewbit.LinkedList.ListNode;

/**
 Given a set of distinct integers, nums, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If nums = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
 */
public class SubSets
{
    public ArrayList<ArrayList<Integer>> subsets( ArrayList<Integer> a )
    {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        Collections.sort( a );
        
        usingDfs( a, 0, new ArrayList<Integer>(), res );
        
        return res;
    }
    
    private void usingDfs( final ArrayList<Integer> a, int in, final ArrayList<Integer> paths, final ArrayList<ArrayList<Integer>> res )
    {
        res.add( new ArrayList<Integer>(paths) );
        
        for( int i = in; i < a.size(); i++ )
        {
            paths.add( a.get( i ) );
            usingDfs( a, i+1, paths, res );
            paths.remove( paths.size()-1 );
        }
    }
    
    public static void main( String[] args )
    {
        
        final SubSets r = new SubSets();
        Integer[] li = {1,2,3};
        ArrayList<Integer> ai = new ArrayList<>(Arrays.asList( li )); 
        System.out.println( "Sub set" + r.subsets( ai ) );
        
    }
}
