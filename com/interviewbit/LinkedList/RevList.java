package com.interviewbit.LinkedList;
/**
 * Reverse a Linked List
 * @author ankurkap
 *
 */
public class RevList
{
    public ListNode reverseList(ListNode a) 
    {
        if( a== null ) return null;
        
        ListNode t = a;
        ListNode prev = null;
        ListNode next = null;
        while( t != null )
        {
            next = t.next;
            t.next = prev;
            prev = t;
            t = next;
        }
        
        return prev;
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
