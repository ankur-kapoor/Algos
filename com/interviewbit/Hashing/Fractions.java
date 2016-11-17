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

public class Fractions
{
    
    public String fractionToDecimal(int num, int denum) 
    {
        StringBuilder s = new StringBuilder();
        
        long n = Math.abs( (long)num );
        long d = Math.abs( (long)denum );
        
        if( n == 0 )return "0";
        
        s.append( num < 0 ^ denum < 0 ? "-" : "");
        
        s.append( n/d );
        
        n = n%d;
        if( n == 0 )
        {
            return s.toString();
        }
        
        s.append( "." );
        final Map<Long, Integer> map = new HashMap<Long, Integer>();
        map.put(n, s.length());
        while( n!= 0)
        {
            n = n*10;
            s.append( n/d );
            n = n%d;
            if (map.containsKey(n)) 
            {
                int index = map.get( n );
                s.insert(index, "(");
                s.append(")");
                break;
            }
            else 
            {
                map.put(n, s.length());
            }
        }
        
        return s.toString();
    }
    
    public static void main( String[] args )
    {
        Fractions t = new Fractions();
        
        Integer[] li = { 4, 7, -4, 2, 2, 2, 3, -5, -3, 9, -4, 9, -7, 7, -1, 9, 9, 4, 1, -4, -2, 3, -3, -5, 4, -7, 7, 9, -4, 4, -8};
        
        ArrayList<Integer> ai = new ArrayList<>( Arrays.asList( li ));
        
        System.out.println( " fraction = "+ t.fractionToDecimal( 1, 66 ) );
    }
}
