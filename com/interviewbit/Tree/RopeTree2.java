package com.interviewbit.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * ou are given the following :

A positive number N
Heights : A list of heights of N persons standing in a queue
Infronts : A list of numbers corresponding to each person (P) that gives the number of persons who are taller than P and standing in front of P
You need to return list of actual order of persons’s height

Consider that heights will be unique

Example

Input : 
Heights: 5 3 2 6 1 4
InFronts: 0 1 2 0 3 2
Output : 
actual order is: 5 3 2 1 6 4 
So, you can see that for the person with height 5, there is no one taller than him who is in front of him, and hence Infronts has 0 for him.

For person with height 3, there is 1 person ( Height : 5 ) in front of him who is taller than him.

You can do similar inference for other people in the list.
*/


public class RopeTree2
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
    }
    
    public ArrayList<Integer> order(ArrayList<Integer> heights, ArrayList<Integer> infronts) 
    {
        List<Person> persons = new ArrayList<>();
        
        int i =0;
        for( final int height : heights )
        {
            persons.add( new Person( height, infronts.get( i++ )) );
        }
        
        Collections.sort( persons );
        
        Tnode root = null;
        for( final Person person : persons )
        {
            root = insert( root, person, person.c );
        }
        
        final ArrayList<Integer> res = new ArrayList<>();
        
        inorderTraversal( root, res );
        
        return res;
        
    }
    
    private void inorderTraversal( Tnode root, ArrayList<Integer> res )
    {
        if( root == null )
        {
            return;
        }
        
        inorderTraversal( root.left, res );
        res.add( root.ht );
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
        final RopeTree2 rt = new RopeTree2();
        
        Integer[] hts = {5,3,2,6,1,4};
        Integer[] infs = {0,1,2,0,3,2};
        
        ArrayList<Integer> heights = new ArrayList<>( Arrays.asList( hts ));
        ArrayList<Integer> infronts = new ArrayList<>( Arrays.asList( infs ));
        
        System.out.println( "After reconstrunction of line = " + rt.order( heights, infronts ));
        
    }
    
}
