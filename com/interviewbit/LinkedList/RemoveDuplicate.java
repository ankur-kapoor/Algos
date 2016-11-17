package com.interviewbit.LinkedList;
/**
 * Remove Duplicates
 * @author ankurkap
 * 
 */
public class RemoveDuplicate
{
    public ListNode deleteDuplicates( ListNode a )
    {
        if( a== null || a.next == null) return a;
        
        ListNode c = a;
        ListNode c2 = a.next;
        
        while( c2 != null )
        {
            if( c.val == c2.val)
            {
                c.next = c2.next;
                c2 = c.next;
            }
            else
            {
                c = c.next;
                c2 = c.next;
            }
        }
        
        return a;
    }
    
    
    
    public static void main( String[] args )
    {
        ListNode t = new ListNode( 2 );
        
        t.add( 2 );
        t.add( 2 );
        t.add( 2 );
        t.add( 2 );
        t.add( 2 );
        t.add( 2 );
        
        t.add( 2 );
        t.add( 2 );
        t.add( 2 );
        
        
       System.out.println( "Before Removing " + t );
        
        final RemoveDuplicate r = new RemoveDuplicate();
        System.out.println( "After removing duplicates  " + r.deleteDuplicates( t ) );
        
    }
}
