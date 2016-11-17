package com.interviewbit.StacksAndQueue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/**
 * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

For example,
Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.

Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
Therefore, return the max sliding window as [3,3,5,5,6,7].

Note: 
You may assume k is always valid, ie: 1 ≤ k ≤ input array's size for non-empty array.

 * @author ankurkap
 *
 */

public class SlidingMax2
{
        
    public ArrayList<Integer> slidingMaximum( List<Integer> a, int k )
    {
        int n = a.size();
        ArrayList<Integer> res = new ArrayList<>();
        
        final Deque<Integer> q = new ArrayDeque<>();
        
        for( int i =0; i < n ; i++ )
        {
            while( !q.isEmpty() && q.peek() < (i - k +1))
            {
                q.poll();
            }
            
            while( !q.isEmpty() && a.get( q.peekLast() ) < a.get( i ) )
            {
                q.pollLast();
            }
            
            q.offer( i );
            
            if( i >= k-1 )
            {
                res.add( a.get( q.peek() ) );
            }
        }
        
        return res;
    }
    
    public static void main( String[] args )
    {
        final SlidingMax2 evalExpr = new SlidingMax2();
        
        Integer[] ar = {1,3,-1,-3,5,3,6,7};
        List<Integer> li = Arrays.asList( ar );
        
        ArrayList<Integer> ai = new ArrayList<>(li);
        System.out.println( " Sliding Max  = " + evalExpr.slidingMaximum( ai, 3 ) );
    }
}
