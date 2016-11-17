package com.interviewbit.BackTracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.interviewbit.LinkedList.ListNode;

/**
 *Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return

  [
    ["aa","b"],
    ["a","a","b"]
  ]
 */
public class PalinPart
{
    public ArrayList<ArrayList<String>> partition(String s) 
    {
        final ArrayList<ArrayList<String>> r = new ArrayList<>();
        
        final ArrayList<String> p = new ArrayList<>();
        
        partitionString( 0, s, p, r );
        return r;
    }
    
    private void partitionString( int index , String s, final ArrayList<String> p, final ArrayList<ArrayList<String>> r )
    {
        if( index == s.length())
        {
            ArrayList<String> t = new ArrayList<>(p);
            r.add( t );
        }
        
        for( int i = index +1; i <= s.length(); i++ )
        {
            String sub = s.substring( index, i );
            
            if(isPalindrome( sub ))
            {
                p.add( sub );
                partitionString( i, s, p, r );
                p.remove( p.size()-1 );
            }
        }
    }
    
    private boolean isPalindrome( String a )
    {
        int l = 0;
        int r = a.length()-1;
        
        if( r == 0 ) return true;
        
        while( l < r )
        {
            if( a.charAt( l++ ) != a.charAt( r-- ))
            {
                return false;
            }
        }
        
        return true;
    }
    
    public static void main( String[] args )
    {
        
        final PalinPart r = new PalinPart();
        System.out.println( "Partition list " + r.partition( "aab" ) );
        
    }
}
