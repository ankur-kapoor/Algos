package com.techgig;

import java.util.HashMap;
import java.util.Map;

public class CandidateCode5
{
    
    public static String collegecomparison(int input1,int[] input2,int[] input3)
    {
        if( input1 != input2.length || input1 != input3.length )
        {
            return "Invalid";
        }
        
        final Map<Integer, Integer> m1 = new HashMap<>();
        
        for( int i : input2 )
        {
            if( i < 0 )
            {
                return "Invalid";
            }
            
            if( m1.containsKey( i ))
            {
                m1.put( i, m1.get( i ) + 1 );
            }
            else
            {
                m1.put( i, 1 );
            }
        }
        
        for( int i : input3 )
        {
            if( i < 0 )
            {
                return "Invalid";
            }
            
            if( !m1.containsKey( i ))
            {
                return "Unequal";
            }
            else
            {
                int t = m1.get( i );
                t--;
                if( t == 0 )
                {
                    m1.remove( i );
                }
                else
                {
                    m1.put( i, t );
                }
            }
        }
        
        if( m1.isEmpty())
        {
            return "Equal";
        }
        else
        {
            return "Unequal";
        }
    }
}
