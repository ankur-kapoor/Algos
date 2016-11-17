package com.interviewbit.LinkedList;
/**
 * Reverse a Linked List
 * @author ankurkap
 *
 */
public class ListPalindrome
{
    public int lPalin( ListNode A )
    {
        ListNode c = A;
        ListNode t = A;
        ListNode t2 = A;
        ListNode p = null;
        
        while( null != t2 && t2.next != null )
        {
            t2 = t2.next.next;
            t = c.next;
            c.next = p;
            p = c;
            c = t;
        }
        
        if( t2 != null && null != c)
        {
            c = c.next;
        }
        
        while( null != p && null != c )
        {
            if( p.val != c.val)
            {
                return 0;
            }
            
            p = p.next;
            c = c.next;
        }
        
        return 1;
    }
    
    public static void main( String[] args )
    {
        ListNode t = new ListNode( 1 );
        
        t.add( 2 );
        t.add( 3 );
        t.add( 3 );
        
        t.add( 2 );
        
        t.add( 1 );
        
        
        //System.out.println( "Before Reverse " + t );
        
        final ListPalindrome r = new ListPalindrome();
        System.out.println( "Is Palindrome " + r.lPalin( t ) );
        
    }
}
