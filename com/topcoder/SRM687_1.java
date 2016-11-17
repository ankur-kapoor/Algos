package com.topcoder;

import java.util.Arrays;

/**
 * 
 * @author ankurkap
 *
 */
public class SRM687_1
{
    int count(int[] arr, int k)
    {
        if( null == arr )
        {
            return 0;
        }
        
        Arrays.sort( arr );
        
        int res = 0;
        
        for( int i =0; i < k && i < arr.length; i++ )
        {
            res += arr[i];
        }
        
        return res;
    }
    public static void main( String[] args )
    {
        final SRM687_1 c = new SRM687_1();
        
        System.out.println( "Result "  );
    }
}
