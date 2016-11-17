package com.interviewbit.StacksAndQueue;

import java.util.ArrayList;
import java.util.Arrays;
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

public class SlidingMax
{
    class Node
    {
        int value;
        int max;
        Node next;

        Node( int x, int max )
        {
            this.value = x;
            this.max = max;
            next = null;
        }
    }

    Node head;
    
    public void clear( )
    {
        head = null;
    }
    
    public void push( int x )
    {
        if ( null == head )
        {
            head = new Node( x, x );
        }
        else
        {
            Node n = new Node( x, Math.max( x, head.max ) );
            n.next = head;
            head = n;
        }
    }

    public int getMax()
    {
        if ( null != head )
            return head.max;
        return -1;
    }
    
    public ArrayList<Integer> slidingMaximum( List<Integer> a, int k )
    {
        int n = a.size();
        int i = 0; 
        ArrayList<Integer> res = new ArrayList<>();
        
        while( i + k <= n )
        {
           int j = i;
                           
           while( j < k + i )
           {
               push( a.get( j++ ) );
           }
           res.add( getMax() );
           clear();
           i++;
        }
        
        return res;
    }    
    public static void main( String[] args )
    {
        final SlidingMax evalExpr = new SlidingMax();
        
        Integer[] ar = {1,3,-1,-3,5,3,6,7};
        List<Integer> li = Arrays.asList( ar );
        
        ArrayList<Integer> ai = new ArrayList<>(li);
        System.out.println( " Sliding Max  = " + evalExpr.slidingMaximum( ai, 3 ) );
    }
}
