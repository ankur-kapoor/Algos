package com.interviewbit.BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import com.interviewbit.LinkedList.ListNode;

/**
 Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

"((()))", "(()())", "(())()", "()(())", "()()()"
 */
public class Paranthesis
{
    public ArrayList<String> generateParenthesis(int n) 
    {
        ArrayList<Character> paranList = new ArrayList<>();
        
        for( int i =0; i < n; i++)
        {
            paranList.add( '(' );
            paranList.add( ')' );
        }
        
        final ArrayList<String> res = new ArrayList<>();
        combine( res, paranList, "", 0, 2*n );
        
        Collections.sort( res );

        return res;
    }
    
    private void combine( final ArrayList<String> res, ArrayList<Character> paranList, String path, int start, int n )
    {
        if( path.length() == n )
        {
            if( isValidParanthesis( path ))
            {
                res.add( path );
            }
            return;
        }
        int sSize = path.length();
        for( int i =0; i<= sSize; i++)
        {
            String p2 = new String( path );
            p2 += String.valueOf( paranList.get( start ) );
            /*if( i > 0 )
            {
                p2 = p2.substring( 0, i-1 ).concat( String.valueOf( paranList.get( start ) ) ).concat( p2.substring( i+1 ) );
            }
            else
            {
                p2 += String.valueOf( paranList.get( start ));
            }*/
            combine( res, paranList, p2, start+1, n );
            
            p2 = p2.substring( 0, p2.length()-1 );
        }
    }
    
    private boolean isValidParanthesis( final String path )
    {
        final Stack<Character> st = new Stack<>(); 
        
        for( char ch : path.toCharArray() )
        {
            if( ch == '(') st.push( ch );
            else
            {
                if( st.isEmpty() )
                {
                    return false;
                }
                else
                {
                    st.pop();
                }
            }
        }
        
        return st.isEmpty();
    }
    
    public static void main( String[] args )
    {
        
        final Paranthesis r = new Paranthesis();
        Integer[] li = {1,2,3};
        ArrayList<Integer> ai = new ArrayList<>(Arrays.asList( li )); 
        System.out.println( "Paranthesis Sequence " + r.generateParenthesis( 6 ) );
        
    }
}
