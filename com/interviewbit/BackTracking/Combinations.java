package com.interviewbit.BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.interviewbit.LinkedList.ListNode;

/**
 Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

For example,
If n = 4 and k = 2, a solution is:

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
 */
public class Combinations
{
    public ArrayList<ArrayList<Integer>> combine( int n, int a )
    {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        
        doCombine( res, new ArrayList<Integer>(), 1, a, n );
        
        return res;
    }
    
    private void doCombine( ArrayList<ArrayList<Integer>> res, ArrayList<Integer> path, int start, int a, int n )
    {
        if( a == 0)
        {
            res.add( new ArrayList<>( path) );
            return;
        }
        
        for( int i =start; i<= n; i++ )
        {
            path.add( i );
            doCombine( res, path, i+1, a-1, n );
            path.remove( path.size() -1);
        }
    }
    
    public static void main( String[] args )
    {
        
        final Combinations r = new Combinations();
        Integer[] li = {1,2,3};
        ArrayList<Integer> ai = new ArrayList<>(Arrays.asList( li )); 
        System.out.println( "Combine " + r.combine( 5, 3 ) );
        
    }
}
