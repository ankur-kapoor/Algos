package com.interviewbit.DP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.interviewbit.Tree.TreeNode;
/**
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

For "(()", the longest valid parentheses substring is "()", which has length = 2.

Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.

 * @author ankurkap
 *
 */

public class LongestValidParanthesis
{
    public int longestValidParentheses( String s )
    {
        char[] S = s.toCharArray();
        int[] V = new int[ S.length ];
        int open = 0;
        int max = 0;
        for ( int i = 0; i < S.length; i++ )
        {
            if ( S[i] == '(' )
                open++;
            if ( S[i] == ')' && open > 0 )
            {
                // matches found
                V[i] = 2 + V[i - 1];
                // add matches from previous
                if ( i - V[i] > 0 )
                    V[i] += V[i - V[i]];
                open--;
            }
            if ( V[i] > max )
                max = V[i];
        }
        return max;
    }
    
    public static void main( String[] args )
    {
        
        final LongestValidParanthesis ms = new LongestValidParanthesis();
        
        System.out.println( "Longest Valid Paran = "+ ms.longestValidParentheses( ")()())" ) );
    }
}
