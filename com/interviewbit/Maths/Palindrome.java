package com.interviewbit.Maths;

public class Palindrome
{
    public boolean isPalindrome(int a) 
    {
        String strA = String.valueOf( a );
        
        if(strA.length() == 1) return true;
        
        char[] charArr = strA.toCharArray();
        
        int l =0;
        int r = strA.length()-1;
        
        int len = strA.length()/2;
        
        while( l <= len && r >= len )
        {
            if(charArr[l++] != charArr[r--])return false;
        }
        
        return true;
    }

    public static void main(String[] args )
    {
        Palindrome p = new Palindrome();
        System.out.println("Palindrome = " + p.isPalindrome( 123221 ) );
    }
}
