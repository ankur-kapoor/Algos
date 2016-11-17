package com.interviewbit.BackTracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.interviewbit.LinkedList.ListNode;

/**
 * Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.



Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note:
Although the above answer is in lexicographical order, your answer could be in any order you want.
 *
 */
public class LetterPhone
{
    public List<String> letterCombinations( String digits )
    {
        String digitletter[] = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        List<String> result = new ArrayList<String>();

        if ( digits.length() == 0 )
            return result;

        result.add( "" );
        for ( int i = 0; i < digits.length(); i++ )
            result = combine( digitletter[digits.charAt( i ) - '0'], result );

        Collections.sort( result );
        return result;
    }

    private List<String> combine(String digit, List<String> l) {
        List<String> result = new ArrayList<String>();

        for (int i=0; i<digit.length(); i++) 
            for (String x : l) 
                result.add(x+digit.charAt(i));

        return result;
    }
    
    
    public static void main( String[] args )
    {
        
        final LetterPhone r = new LetterPhone();
        System.out.println( "Letter combinations = " + r.letterCombinations( "234" ) );
        
    }
}
