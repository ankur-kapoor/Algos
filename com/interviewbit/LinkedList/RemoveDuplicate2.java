package com.interviewbit.LinkedList;
/**
 * Remove Duplicates
 * @author ankurkap
 * 
 */
public class RemoveDuplicate2
{
    public ListNode deleteDuplicates( ListNode a )
    {
        ListNode t = new ListNode(0);
        t.next = a;
     
        ListNode p = t;
        while(p.next!=null&&p.next.next!=null){
            if(p.next.val == p.next.next.val){
                int dup = p.next.val;
                while(p.next!=null&&p.next.val==dup){
                    p.next = p.next.next;
                }
            }else{
                p=p.next;
            }
     
        }
     
        return t.next;
    }
    
    
    
    public static void main( String[] args )
    {
        ListNode t = new ListNode( 1 );
        
        t.add( 2 );
        t.add( 2 );
        t.add( 2 );
        t.add( 2 );
        t.add( 2 );
        t.add( 2 );
        
        t.add( 2 );
        t.add( 2 );
        t.add( 3 );
        t.add( 4 );
        
       System.out.println( "Before Removing " + t );
        
        final RemoveDuplicate2 r = new RemoveDuplicate2();
        System.out.println( "After removing duplicates  " + r.deleteDuplicates( t ) );
        
    }
}
