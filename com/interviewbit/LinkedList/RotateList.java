package com.interviewbit.LinkedList;
/**
 * Given a list, rotate the list to the right by k places, where k is non-negative.

For example:
Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.
 */
public class RotateList
{
    public ListNode rotateRight(ListNode head, int k) 
    {
        int n = 0;
        
        ListNode t = head;
        
        while( t != null )
        {
            n++;
            t = t.next;
        }
        
        if( k > n )
        {
            k = k%n;
        }
        
        t = head;
        
        ListNode t2 = null;
        for( int i =1; i < n-k; i++ )
        {
            t = t.next;
        }
        
        t2 =  t.next;
        t.next = null;
        
        ListNode t3 = t2;
        
        while( t3 != null )
        {
            t3 = t3.next;
        }
        
        t3.next = head;
        
        return t2;
    }
    
    public static void main( String[] args )
    {
        ListNode t = new ListNode( 1 );
        
        t.add( 2 );
        t.add( 3 );
        t.add( 4 );
        t.add( 5 );
        
        System.out.println( "Before Reverse " + t );
        
        final RotateList r = new RotateList();
        //System.out.println( "After Reverse " + r.reverseList( t ) );
        
    }
}
