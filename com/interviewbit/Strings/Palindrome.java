package com.interviewbit.Strings;

import java.util.StringTokenizer;

public class Palindrome
{
    public int isPalindrome(String a) 
    {
        String strA = a;
        if(a.length() == 1) return 1;
        
        strA = strA.toLowerCase();
        strA = strA.replaceAll( "[^A-Za-z0-9 ]", "" );
        strA = removeSpaces( strA );
        
        
        char[] charArr = strA.toCharArray();
        
        int l =0;
        int r = strA.length()-1;
        
        int len = strA.length()/2;
        
        while( l <= len && r >= len )
        {
            if(charArr[l++] != charArr[r--])return 0;
        }
        
        return 1;
    }
    
    private String removeSpaces( final String s )
    {
        final StringTokenizer st = new StringTokenizer( s, " ", false );
        String t = "";
        while ( st.hasMoreElements() )
        {
            t += st.nextElement();
        }
        return t;
    }

    public static void main(String[] args )
    {
        Palindrome p = new Palindrome();
        System.out.println("Palindrome = " + p.isPalindrome( "1a2" ) );
    }
}
