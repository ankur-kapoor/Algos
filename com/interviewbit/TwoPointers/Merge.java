package com.interviewbit.TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * Intersection of 2 arrays 
 * @author ankurkap
 *
 */
public class Merge
{
    
    public void merge( ArrayList<Integer> a, ArrayList<Integer> b) 
    {
        
        int n = a.size();
        int m = b.size();
        
        if( n == 0 && m == 0 )
        {
            return;
        }
        else if( n == 0)
        {
            return;
        }
        else if( m == 0)
        {
            return;
        }
            
        int ai = 0;
        int bi = 0;
        
        while( ai < n && bi < m )
        {
            if( a.get( ai ).intValue() <= b.get( bi ).intValue())
            {
                ai++;
            }
            else 
            {
                a.add( ai++, b.get(bi++) );
                n++;
            }
        }
        
        if( bi < m )
        {
            for( int i = bi; i < m; i++)
            {
                a.add( b.get( i ) );
            }
        }
    }

    public static void main( String[] args )
    {
        Integer[] aR = {1,5,8};
        Integer[] bR = {6,9};
        
        final List<Integer> aList = Arrays.asList( aR );
        final List<Integer> bList = Arrays.asList( bR );
        
        final ArrayList<Integer> aL = new ArrayList<>(aList);
        final ArrayList<Integer> bL = new ArrayList<>(bList);
        
        
        Merge in = new Merge();
        
        in.merge( aL, bL );
        
        System.out.println( " Merged Arr = " + aL);
        
    }
}
