package com.interviewbit.Bits;

import java.util.Arrays;
import java.util.List;

/**
 * 
 *Given an array of integers, every element appears thrice except for one which occurs once.

Find that element which does not appear thrice.

Note: Your algorithm should have a linear runtime complexity.

Could you implement it without using extra memory?

Example :

Input : [1, 2, 4, 3, 3, 2, 2, 3, 1, 1]
Output : 4
 *
 */
public class Single2
{
    public int singleNumber(final List<Integer> a) 
    {
        if (a == null) return 0;
        int x0 = ~0, x1 = 0, x2 = 0, t;
        for (int i = 0; i < a.size(); i++) {
            t = x2;
            x2 = (x1 & a.get( i )) | (x2 & ~a.get( i ));
            x1 = (x0 & a.get( i )) | (x1 & ~a.get( i ));
            x0 = (t & a.get( i )) | (x0 & ~a.get( i ));
        }
        
        if( x1 > 0 )
            return x1;
        
        return x2;
    }
    
    public static void main( String[] args )
    {
        Single2 nb = new Single2();
        
        Integer[] nums = {1, 2, 4, 4,3, 3, 2, 2, 3, 1, 1};
        
        final List<Integer> numList = Arrays.asList( nums );
        
        System.out.println( "Duplicate Missing= " + nb.singleNumber( numList ) );
    }
}
