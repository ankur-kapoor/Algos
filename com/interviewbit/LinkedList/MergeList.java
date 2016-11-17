package com.interviewbit.LinkedList;
/**
 * Merge 2 sorted a linked list
 * @author ankurkap
 * 
 */
public class MergeList
{
    public ListNode merge( ListNode l1, ListNode l2 )
    {
        ListNode d = new ListNode( 0 );
        ListNode p = d;
        
        while( l1!= null && l2 != null )
        {
            if( l1.val < l2.val )
            {
                p.next = l1;
                l1 = l1.next;
            }
            else
            {
                p.next =  l2;
                l2 = l2.next;
            }
            
            p = p.next;
        }
        
        if( l1 != null )
        {
            p.next = l1;
        }
        
        if( l2 != null )
        {
            p.next = l2;
        }
        return d.next;
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
        
        final MergeList r = new MergeList();
        //System.out.println( "After Reverse " + r.sortList( t ) );
        
    }
}
