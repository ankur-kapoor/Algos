package com.interviewbit.TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * Intersection of 2 arrays 
 * @author ankurkap
 *
 */
public class Intersectarr
{
    
    public ArrayList<Integer> intersect(final List<Integer> a, final List<Integer> b) 
    {
        final ArrayList<Integer> res = new ArrayList<>();
        
        int n = a.size();
        int m = b.size();
        
        if( n == 0 || m == 0 )
        {
            return res;
        }
        
        int i = 0;
        int j = 0;
        
        while(i < n  && j < m)
        {
            if( a.get( i ).equals( b.get( j ) ))
            {
                res.add( a.get( i ) );
                i++;
                j++;
            }
            else if( a.get( i ).intValue() > b.get( j ).intValue())
            {
                j++;
            }
            else
            {
                i++;
            }
        }
        
        return res;
    }

    public static void main( String[] args )
    {
        Integer[] aR = {10000000};
        Integer[] bR = {10000000};
        
        final List<Integer> aList = Arrays.asList( aR );
        final List<Integer> bList = Arrays.asList( bR );
        
        Intersectarr in = new Intersectarr();
        
        System.out.println( " Intersect Arr = " + in.intersect( aList, bList ));
        
    }
}
