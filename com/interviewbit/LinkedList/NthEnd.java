package com.interviewbit.LinkedList;
/**
 * Given n , remove the element from nth node from end.
 * @author ankurkap
 * 
 */
public class NthEnd
{
    public ListNode nthEnd( ListNode a, int n )
    {
        if( a== null ) return a;
        
        int m = getNodeLength( a );
        
        if( n >= m )
        {
            a = a.next;
            return a;
        }
        
        int diff = m - n;
        int i =0;
        ListNode prev = null;
        ListNode c = a;
        while( i<= diff && c!= null )
        {
            if( i == diff )
            {
                if( prev == null )
                {
                    a = a.next;
                    return a;
                }
                else
                {
                    prev.next = c.next;
                    break;
                }
            }
            else
            {
                prev = c;
                c = c.next;
            }
            i++;
        }
        return a;
    }
    
    private int getNodeLength( final ListNode a )
    {
        int len = a == null ? 0 : 1;
        
        if( len == 0) return 0;
        
        ListNode t = a;
        
        while( t.next != null )
        {
            t = t.next;
            len++;
        }
        
        return len;
    }
    
    
    public static void main( String[] args )
    {
        ListNode t = new ListNode( 1 );
        
        /*t.add( 2 );
        t.add( 3 );
        t.add( 4 );
        t.add( 5 );
        t.add( 6 );
        t.add( 7 );*/
        
        
       System.out.println( "Before Removing " + t );
        
        final NthEnd r = new NthEnd();
        System.out.println( "After removing duplicates  " + r.nthEnd( t , 1) );
        
    }
}
