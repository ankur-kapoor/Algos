package com.topcoder;

import java.util.HashSet;
import java.util.Set;

public class NonDeterministicSubstring
{
    public long ways( String A, String B )
    {
        int n = A.length();
        int m = B.length();
        
        Set<String> matches = new HashSet<>();
        
        for( int i =0; i <= n-m; i++ )
        {
            String C = A.substring( i, i+m );
            
            if( isMatch( C, B ))
            {
                matches.add( C );
            }
        }
        
        return matches.size();
    }
    
    private boolean isMatch( String C, String B)
    {
        char[] charB = B.toCharArray();
        char[] charC = C.toCharArray();
        
        for( int i =0; i < charB.length; i++ )
        {
            if( charB[i] != '?' && charB[i] != charC[i])
            {
                return false;
            }
        }
        
        return true;
    }
    
    /*public static void main( String[] args )
    {
        NonDeterministicSubstring nds = new NonDeterministicSubstring();
        
        System.out.println( nds.ways( "001010101100010111010", "???" ));
    }*/
}
