package com.interviewbit.LinkedList;


public class ListNode
{
    public int val;
    public ListNode next;

    public ListNode( int x )
    {
        val = x;
        next = null;
    }
    
    public void add( int x )
    {
        final ListNode n = new ListNode( x );
        ListNode temp = this;
        
        while( temp.next != null )
        {
            temp = temp.next;
        }
        temp.next = n;
    }
    
    void add( int x, ListNode n )
    {
        ListNode temp = this;
        
        while( temp.next != null )
        {
            temp = temp.next;
        }
        temp.next = n;
    }
    
    public String toString()
    {
        StringBuilder strBuild = new StringBuilder();
        
        ListNode temp = this;
        while( temp.next != null )
        {
            strBuild.append( temp.val  ).append( "->" );
            temp = temp.next;
        }
        
        strBuild.append( temp.val  );
        
        return strBuild.toString();
    }
}
