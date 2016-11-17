package com.interviewbit.Strings;

import java.util.StringTokenizer;
import java.math.BigInteger;
import java.util.Formatter.BigDecimalLayoutForm;

/**
 * 
 * Find if Given number is power of 2 or not. 
More specifically, find if given number can be expressed as 2^k where k >= 1.

Input:

number length can be more than 64, which mean number can be greater than 2 ^ 64 (out of long long range)
Output:

return 1 if the number if a power of 2 else return 0

Example:

Input : 128
Output : 1
 *
 */

public class Power
{
    public int power(String a)
    {
        BigInteger bi = new BigInteger( a );
        
        if(bi.equals( BigInteger.ONE )) return 0;
        int n = bi.bitCount();
        
        if( n ==1 ) return 1;
        
        return 0;
    }
    
    private boolean isValid(char c) 
    {
        return c == '.' || c == '+' || c == '-' || c == 'e' || c == 'E' || c >= '0' && c <= '9';
    }
    
    public int isNumber(final String a) 
    {
        if (a == null) return 0;

        String s = a.trim();
        int n = s.length();

        if (n == 0) return 0;

        // flags
        int signCount = 0;
        int hasE = 0;
        int hasNum = 0;
        int hasPoint = 0;

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            // invalid character
            if (!isValid(c)) return 0;

            // digit is always fine
            if (c >= '0' && c <= '9') hasNum = 1;

            // e or E
            if (c == 'e' || c == 'E') {
                // e cannot appear twice and digits must be in front of it
                if (hasE == 1 || hasNum != 1) return 0;
                // e cannot be the last one
                if (i == n - 1) return 0;

                hasE = 1;
            }

            // decimal place
            if (c == '.') {
                // . cannot appear twice and it cannot appear after e
                if (hasPoint == 1 || hasE == 1) return 0;
                // if . is the last one, digits must be in front of it, e.g. "7."
                if (i == n - 1 && hasNum != 1) return 0;

                hasPoint = 1;
            }

            // signs
            if (c == '+' || c == '-') {
                // no more than 2 signs
                if (signCount == 2) return 0;
                // sign cannot be the last one
                if (i == n - 1) return 0;
                // sign can appear in the middle only when e appears in front
                if (i > 0 && hasE != 1) return 0;

                signCount++;
            }
        }

        return 1;
    }
    
    public static void main(String[] args )
    {
        Power p = new Power();
        System.out.println("Is Binary Addition = " + p.power( "147573952589676412928" ) );
    }
}
