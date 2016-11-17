package com.interviewbit.Strings;

import java.util.StringTokenizer;

/**
 * 
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

Example:

Given s = "Hello World",

return 5 as length("World") = 5.

Please make sure you try to solve this problem without using library functions. Make sure you only traverse the string once.
 *
 */

public class LengthLast
{
    public int lengthOfLastWord(final String a) 
    {
        if( a == null || a.trim() == "") return 0;
        
        int len = a.length();
        
        char[] charArr = a.toCharArray();
        
        int count = 0;
        for( int i = len-1; i >=0; i--)
        {
            if( charArr[i] == ' ' && count == 0)
            {
                continue;
            }
            else if( count !=0 && charArr[i] == ' ')
            {
                return count;
            }
            else
            {
                count++;
            }
        }
        
        return count;
    }
    
    

    public static void main(String[] args )
    {
        LengthLast p = new LengthLast();
        System.out.println("Palindrome = " + p.lengthOfLastWord( "    " ) );
    }
}
