package com.interviewbit.TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * Given an array ‘A’ of sorted integers and another non negative integer k, find if there exists 2 indices i and j such that A[i] - A[j] = k, i != j.
 * @author ankurkap
 *
 */
public class Diffk
{
    
    public int diffPossible( final ArrayList<Integer> a, int k )
    {
        int i =1;
        int j = 0;
        
        int n = a.size();
        
        while( i < n && j < n)
        {
            int t = a.get( i )- a.get( j );
            if( t == k && i != j )
            {
                return 1;
            }
            else if( t < k )
            {
                i++;
            }
            else
            {
                j++;
            }
        }
       
        return 0;
    }

    public static void main( String[] args )
    {
        Integer[] aR = {1,3,5};
        int k = 4;
        final ArrayList<Integer> a = new ArrayList<>(Arrays.asList( aR ));
        Diffk in = new Diffk();
        
        System.out.println( " Is DIffk = " + in.diffPossible( a, 4 ));
        
    }
}
