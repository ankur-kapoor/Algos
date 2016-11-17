package com.interviewbit.LinkedList;
/**
 * Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
 */
public class SwapList
{
    public ListNode swapPairs(ListNode head) 
    {
        ListNode node = head;
        ListNode cur = node;
        
        ListNode prev = new ListNode( 0 );
        ListNode next = null;
        
        while( cur != null )
        {
            next = cur.next;
            if( next != null )
            {
                cur.next = next.next;
                next.next = cur;
                prev.next = next;
            }
            
            cur = cur.next;
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
        
        System.out.println( "Before Swap " + t );
        
        final SwapList r = new SwapList();
        System.out.println( "After Swap " + r.swapPairs( t ) );
        
    }
}
