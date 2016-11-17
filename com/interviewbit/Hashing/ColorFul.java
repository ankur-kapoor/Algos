package com.interviewbit.Hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 *For Given Number N find if its COLORFUL number or not

Return 0/1

COLORFUL number:

A number can be broken into different sub-sequence parts. 
Suppose, a number 3245 can be broken into parts like 3 2 4 5 32 24 45 324 245. 
And this number is a COLORFUL number, since product of every digit of a sub-sequence are different
Example:

N = 23
2 3 23
2 -> 2
3 -> 3
23 -> 6
this number is a COLORFUL number since product of every digit of a sub-sequence are different. 

Output : 1
 */

public class ColorFul
{
    public int colorful(int a) 
    {
        ArrayList<Integer> nums = new ArrayList<>();
        Map<Integer, Integer> valMap = new HashMap<>();
        while( a != 0)
        {
            int t = a%10;
            nums.add(0, t );
            
            if( valMap.containsKey( t )) return 0;
            
            valMap.put( t, t );
            a = a/10;
        }
        
        int k =1;
        
        while( k < nums.size() )
        {
            for( int i = 0; i < nums.size()-1; i++ )
            {
                int t = Integer.MIN_VALUE;
                for( int j = i; j <= i+k && i+k <nums.size(); j++ )
                {
                    if( t == Integer.MIN_VALUE )t =1;
                    
                    t *= nums.get( j );
                }
                if( t != Integer.MIN_VALUE && valMap.containsKey( t )) return 0;
                
                valMap.put( t, t );
            }
            
            k++;
        }
        
        return 1;
    }
    
    
    public static void main( String[] args )
    {
        ColorFul t = new ColorFul();
        
        Integer[] li = { 4, 7, -4, 2, 2, 2, 3, -5, -3, 9, -4, 9, -7, 7, -1, 9, 9, 4, 1, -4, -2, 3, -3, -5, 4, -7, 7, 9, -4, 4, -8};
        
        ArrayList<Integer> ai = new ArrayList<>( Arrays.asList( li ));
        
        System.out.println( " ColorFul = "+ t.colorful( 230 ) );
    }
}
