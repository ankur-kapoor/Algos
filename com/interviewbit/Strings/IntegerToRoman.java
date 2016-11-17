package com.interviewbit.Strings;

import java.util.StringTokenizer;

/**
 * 
 * Compare two version numbers version1 and version2.

If version1 > version2 return 1,
If version1 < version2 return -1,
otherwise return 0.
You may assume that the version strings are non-empty and contain only digits and the . character.
The . character does not represent a decimal point and is used to separate number sequences.
For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.

Here is an example of version numbers ordering:

0.1 < 1.1 < 1.2 < 1.13 < 1.13.4
 *
 */

public class IntegerToRoman
{
    public String intToRoman( int num )
    {

        int[] values = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        String[] strs = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };

        StringBuilder sb = new StringBuilder();

        for ( int i = 0; i < values.length; i++ )
        {
            while ( num >= values[i] )
            {
                num -= values[i];
                sb.append( strs[i] );
            }
        }
        return sb.toString();
    }
    
    public static void main(String[] args )
    {
        IntegerToRoman p = new IntegerToRoman();
        //System.out.println("Version Comparisons = " + p.compareVersion( "444444444444444444444444",  "4444444444444444444444444" ) );
    }
}
