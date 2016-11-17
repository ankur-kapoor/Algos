package com.interviewbit.Heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

import com.interviewbit.LinkedList.ListNode;

/**
 * 
 * You are given an array of N integers, A1, A2 ,…, AN and an integer K. Return the of count of distinct numbers in all windows of size K.

Formally, return an array of size N-K+1 where i’th element in this array contains number of distinct elements in sequence Ai, Ai+1 ,…, Ai+k-1.

Note:
- If K > N, return empty array.

For example,

A=[1, 2, 1, 3, 4, 3] and K = 3

All windows of size K are

[1, 2, 1]
[2, 1, 3]
[1, 3, 4]
[3, 4, 3]

So, we return an array [2, 3, 3, 2].
 */
public class MergeKList
{

    public ListNode mergeKLists(ArrayList<ListNode> lists)
    {
        final ListNode d = new ListNode( 0 );
        ListNode t = d;
        
        final PriorityQueue<ListNode> pq = new PriorityQueue<>( lists.size(), new Comparator<ListNode>()
        {
            @Override
            public int compare( ListNode o1, ListNode o2 )
            {
                return Integer.compare( o1.val, o2.val );
            }
        });
        
        for( ListNode l : lists )
        {
            if( null != l )
            {
                pq.add( l );
            }
        }
        
        while( !pq.isEmpty())
        {
            t.next = pq.poll();
            
            t = t.next;
            
            if( null != t.next )
            {
                pq.add( t.next );
            }
        }
        
        return d.next;
    }
    
    public static void main( String[] args )
    {
        MergeKList d = new MergeKList();
        
        Integer[] li = {1, 2, 1, 3, 4, 3};
        ArrayList<Integer> nums = new ArrayList<>(Arrays.asList( li ));
        
        //System.out.println( d.dNums( nums, 3 ));
    }
}
