package com.interviewbit.LinkedList;
/**
 * Reverse a Linked List
 * @author ankurkap
 *
 */
public class RevList2
{
    public ListNode reverseBetween(ListNode a, int m , int n ) 
    {
        if( a== null ) return null;
        
        if( m == n ) return a;
        
        ListNode start = m > 1 ? a : null;
        
        int i = 1;
        ListNode c = start;
        while( i < m-1 && c != null)
        {
            c = c.next;
            i++;
        }
        
        ListNode temp = null != c && m > 1? c.next : a;
        
        if( null != c )
        {
            c.next = null;
        }
        else
        {
            i--;
        }
        
        ListNode prev = null;
        ListNode next = null;
        while( i < n && temp != null )
        {
            next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
            i++;
        }
        
        if( m > 1)
        {
            c.next = prev;
        }
        else
        {
            start = prev;
        }
        
        ListNode t1 = start;
        while( t1.next != null)
        {
            t1 =t1.next;
        }
        
        t1.next = temp;
        
        return start;
    }
    
    public static void main( String[] args )
    {
        ListNode t = new ListNode( 1 );
        
        t.add( 2 );
        t.add( 3 );
        t.add( 4 );
        t.add( 5 );
        
        System.out.println( "Before Reverse " + t );
        
        final RevList2 r = new RevList2();
        System.out.println( "After Reverse " + r.reverseBetween( t, 2, 5 ) );
        
    }
}
