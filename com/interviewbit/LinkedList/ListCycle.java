package com.interviewbit.LinkedList;
/**
 * Determine if a Linked List have cycle or not and send the corresponding node
 * @author ankurkap
 * 
 */
public class ListCycle
{
    public boolean isCyclic( ListNode a )
    {
        ListNode slow = a;
        ListNode fast = a;
        
        while( null != fast && null != fast.next )
        {
            slow = slow.next;
            fast = fast.next.next;
            
            if( slow.equals( fast )) return true;
        }
        
        return false;
    }
    
    public static void main( String[] args )
    {
        ListNode t = new ListNode( 1 );
        
        t.add( 2 );
        
        ListNode three = new ListNode( 3 );
        t.add( 3, three );
        t.add( 4 );
        t.add( 5 );
        
        t.add( 5, three );
        
        
       // System.out.println( "Before Reverse " + t );
        
        final ListCycle r = new ListCycle();
        System.out.println( "After Reverse " + r.isCyclic( t ) );
        
    }
}
