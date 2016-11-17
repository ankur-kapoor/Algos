package com.interviewbit.LinkedList;

/**
 * Write a program to find the node at which the intersection of two singly linked lists begins.

For example, the following two linked lists:


A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗
B:     b1 → b2 → b3

begin to intersect at node c1.
 * @author ankurkap
 *
 */

public class IntersectList
{
    public ListNode getIntersectionNode(ListNode a, ListNode b) 
    {
        int n = getNodeLength( a );
        int m = getNodeLength( b );
        
        if( n == 0 || m == 0)return null;
        
        ListNode ta = a;
        ListNode tb = b;
        
        if( n > m )
        {
            while( n!= m )
            {
                ta = ta.next;
                n--;
            }
        }
        else if( m > n )
        {
            while( n!= m )
            {
                tb = tb.next;
                m--;
            }
        }
        
        if( ta.equals( tb )) return ta;
        
        while( ta.next != null && tb.next != null )
        {
            ta = ta.next;
            tb = tb.next;
            
            if( ta.equals( tb )) return ta;
        }
        
        return null;
    }
    
    private int getNodeLength( final ListNode a )
    {
        int len = a == null ? 0 : 1;
        
        if( len == 0) return 0;
        
        ListNode t = a;
        
        while( t.next != null )
        {
            t = t.next;
            len++;
        }
        
        return len;
    }

    public static void main( String[] args )
    {
        
    }
}
