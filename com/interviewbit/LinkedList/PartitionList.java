package com.interviewbit.LinkedList;
/**
 * Partition a given list based on x, such that value less than x lies on left else right
 * @author ankurkap
 * 
 */
public class PartitionList
{
    
    public ListNode partitionList( ListNode a, int x )
    {
        ListNode d1 = new ListNode( 0 );
        ListNode d2 = new ListNode( 0 );
        
        ListNode c1 = d1;
        ListNode c2 = d2;
        
        while( a != null )
        {
            if( a.val < x )
            {
                c1.next = a;
                c1 = c1.next;
            }
            else
            {
                c2.next = a;
                c2 = c2.next;
            }
            a = a.next;
        }
        
        c2.next = null;
        c1.next = d2.next;
        
        return d1.next;
    }
    
    public static void main( String[] args )
    {
        ListNode t = new ListNode( 1 );
        
        t.add( 2 );
        
        t.add( 3 );
        t.add( 4 );
        t.add( 5 );
        
        t.add( 2 );
        t.add( 3 );
        t.add( 6 );
        t.add( 1 );
        
        
       // System.out.println( "Before Reverse " + t );
        
        final PartitionList r = new PartitionList();
        System.out.println( "After Reverse " + r.partitionList( t, 3 ) );
        
    }
}
