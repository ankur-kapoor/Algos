package com.interviewbit.BackTracking;

import com.interviewbit.LinkedList.ListNode;

/**
 * Reverse a Linked List
 * @author ankurkap
 *
 */
public class RevList
{
    public ListNode reverseList(ListNode a) 
    {
        ListNode p = a;
        
        return reverse( a, p );
    }
    
    private ListNode reverse( ListNode a , ListNode p )
    {
        if( p.next == null )
        {
            a = p;
            return p;
        }
        
        ListNode q = reverse( a, p.next );
        q.next = p;
        p.next = null;
        
        return a;
    }
    
    public static void main( String[] args )
    {
        ListNode t = new ListNode( 1 );
        
        t.add( 2 );
        t.add( 3 );
        t.add( 4 );
        t.add( 5 );
        
        System.out.println( "Before Reverse " + t );
        
        final RevList r = new RevList();
        System.out.println( "After Reverse " + r.reverseList( t ) );
        
    }
}
