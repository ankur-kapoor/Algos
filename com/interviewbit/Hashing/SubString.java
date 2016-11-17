package com.interviewbit.Hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 *Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

If the fractional part is repeating, enclose the repeating part in parentheses.

For example,

Given numerator = 1, denominator = 2, return "0.5".
Given numerator = 2, denominator = 1, return "2".
Given numerator = 2, denominator = 3, return "0.(6)".
 */

public class SubString
{
    
    public static ArrayList<Integer> findSubstring( String S, List<String> L )
    {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if ( S == null || L == null || L.size() == 0 )
            return res;
        int len = L.get( 0 ).length(); // length of each word

        Map<String, Integer> map = new HashMap<String, Integer>(); // map for L
        for ( String w : L )
            map.put( w, map.containsKey( w ) ? map.get( w ) + 1 : 1 );

        for ( int i = 0; i <= S.length() - len * L.size(); i++ )
        {
            Map<String, Integer> copy = new HashMap<String, Integer>( map );
            for ( int j = 0; j < L.size(); j++ )
            { // checkc if match
                String str = S.substring( i + j * len, i + j * len + len ); // next word
                if ( copy.containsKey( str ) )
                { // is in remaining words
                    int count = copy.get( str );
                    if ( count == 1 )
                        copy.remove( str );
                    else
                        copy.put( str, count - 1 );
                    if ( copy.isEmpty() )
                    { // matches
                        res.add( i );
                        break;
                    }
                }
                else
                    break; // not in L
            }
        }
        return res;
    }
    
    public static void main( String[] args )
    {
        SubString t = new SubString();
        
        Integer[] li = { 4, 7, -4, 2, 2, 2, 3, -5, -3, 9, -4, 9, -7, 7, -1, 9, 9, 4, 1, -4, -2, 3, -3, -5, 4, -7, 7, 9, -4, 4, -8};
        
        ArrayList<Integer> ai = new ArrayList<>( Arrays.asList( li ));
        
        //System.out.println( " fraction = "+ t.fractionToDecimal( 1, 66 ) );
    }
}
