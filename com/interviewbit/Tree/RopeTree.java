package com.interviewbit.Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Suppose you have a line of n people in which the k-th person is described by a pair (h,t) , where h is the height of the k-th person and t is the number of people in front of k who have a height greater or equal than h . Write an algorithm to reconstruct the line.

For example, if the line is composed by the following people:

[(7, 0),(4, 4),(7,1), (5, 0), (6,1), (5, 2)]
The original line should be:

[(5,0), (7,0), (5,2), (6,1), (4,4),(7,1)]

*/


public class RopeTree
{
    class Tnode
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
    
    class Person implements Comparable<Person>
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
        
        public String toString()
        {
            return "{ "+ this.h + ", " + this.c + " }"; 
        }
    }
    
    public ArrayList<ArrayList<Integer>> reconstructLine( ArrayList<ArrayList<Integer>> line )
    {
        List<Person> persons = new ArrayList<>(); 
        for( final ArrayList<Integer> a : line )
        {
            persons.add( new Person( a.get( 0 ), a.get( 1 )) );
        }
        
        Collections.sort( persons );
        
        Tnode root = null;
        for( final Person person : persons )
        {
            root = insert( root, person, person.c );
        }
        
        final ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        
        inorderTraversal( root, res );
        
        return res;
    }
    
    private void inorderTraversal( Tnode root, ArrayList<ArrayList<Integer>> res )
    {
        if( root == null )
        {
            return;
        }
        
        inorderTraversal( root.left, res );
        ArrayList<Integer> a = new ArrayList<>();
        a.add( root.ht );
        a.add( root.cnt );
        res.add( a );
        inorderTraversal( root.right, res );
    }
    
    private Tnode insert( Tnode root, Person person, int w )
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
        final RopeTree rt = new RopeTree();
        
        final ArrayList<ArrayList<Integer>> s = new ArrayList<>();
        
        ArrayList<Integer> a = new ArrayList<>();
        
        a.add( 5 );
        a.add( 0 );
        s.add( a );
        
        a = new ArrayList<>();
        a.add( 6 );
        a.add( 1 );
        s.add( a );
        
        a = new ArrayList<>();
        a.add( 5 );
        a.add( 2 );
        s.add( a );
        
        a = new ArrayList<>();
        a.add( 7 );
        a.add( 0 );
        s.add( a );
        
        a = new ArrayList<>();
        a.add( 4 );
        a.add( 4 );
        s.add( a );
        
        a = new ArrayList<>();
        a.add( 7 );
        a.add( 1 );
        s.add( a );
        
        System.out.println( "After reconstrunction of line = " + rt.reconstructLine( s ));
        
    }
    
}
