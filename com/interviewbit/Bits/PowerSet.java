package com.interviewbit.Bits;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * All possible combination of a given array 
 * @author ankurkap
 *
 */

public class PowerSet
{
    
    final List<List<Integer>> getCombinations( final List<Integer> a )
    {
        int n = a.size();
        final List<List<Integer>> res = new ArrayList<>();
        
        for( int i =0; i < (1<<n); i++ )
        {
            final List<Integer> li = new ArrayList<>();
            for( int j =0; j < n; j++ )
            {
                if( (i & (1<<j)) != 0 )
                {
                    li.add( a.get( j ) );
                }
            }
            
            res.add( li );
        }
        
        return res;
    }
    
    public static void main( String[] args )
    {
        final Integer[] ab = {1,2,3,4,5,7,8,9};
        
        final List<Integer> a = Arrays.asList( ab );
        
        final PowerSet p = new PowerSet();
        System.out.println( p.getCombinations( a ));
        
    }
}
