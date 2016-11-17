package com.techgig;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;



public class CandidateCode3
{
    public static int[] uniqueValue(int input1,int[] input2)
    {
        final List<Person> emps = new ArrayList<Person>();
        
        for( int i = 0; i < input1; i++ )
        {
            emps.add( new Person( i+1, input2[i]) );
        }
        
        Collections.sort( emps );
        
        Tnode root = null;
        for( final Person person : emps )
        {
            root = insert( root, person, person.c );
        }
        
        final int[] res = new int[input1];
        
        inorderTraversal( root, res );
        
        return res;
    }
    
    private static void inorderTraversal( Tnode root, int[] res )
    {
        if( root == null )
        {
            return;
        }
        
        final Stack<Tnode> st = new Stack<>();
        
        int i = 0;
        while( root != null || !st.isEmpty())
        {
            while( root != null )
            {
                st.push( root );
                root = root.left;
            }
            root = st.pop();
            res[i++] = root.ht;
            
            root = root.right;
        }
        
    }
    
    private static Tnode insert( Tnode root, Person person, int w )
    {
        if( root == null )
        {
            return new Tnode( person.h, person.c );
        }
        
        if( w < root.wgt )
        {
            root.wgt++;
            root.left = insert( root.left, person, w );
        }
        else
        {
            root.right = insert( root.right, person, w - root.wgt );
        }
        
        return root;
    }
    
    
    public static void main( String[] args )
    {
       int n = 4;
       int[] nums =  {2,1,1,0};
       
       int[] res = uniqueValue( n, nums );
       
       for( int i =0; i < res.length; i++ )
       {
           System.out.println( res[i] + ", ");
       }
       //System.out.println( " After in order " + uniqueValue( n, nums ) );
    }


static class Tnode
{
    int ht;
    int cnt;
    int wgt;
    
    Tnode left;
    Tnode right;
    
    Tnode( int h, int c )
    {
        ht = h;
        cnt = c;
        wgt = 1;
    }
}

static class Person implements Comparable<Person>
{
    Integer h;
    Integer c;
    
    Person( int ht, int cnt )
    {
        h = ht;
        c = cnt;
    }

    @Override
    public int compareTo( Person o )
    {
        if( this.h.compareTo( o.h ) == 0 )
        {
            return this.c.compareTo( o.c );
        }
        else
        {
            return this.h.compareTo( o.h )*-1;
        }
    }
}

}