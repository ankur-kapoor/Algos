package com.interviewbit.DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.net.ssl.HandshakeCompletedEvent;

/**
 * Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code".

Using BackTracking
 */
public class WordBreak2
{
    public int wordBreak(String s, ArrayList<String> b) 
    {
        if( null == s || s.length() == 0 )
        {
            return 0;
        }
        final Set<String> wordDict = new HashSet<>(b);
        
        final boolean[] flags = new boolean[s.length()+1];
        flags[0] = true;
        
        for( int i = 1; i<= s.length(); i++ )
        {
            for( int j = 0; j < i; j++ )
            {
                if( flags[j] && wordDict.contains( s.substring( j, i ) ))
                {
                    flags[i] = true;
                    break;
                }
            }
        }
        
        return flags[s.length()] ? 1 : 0;
    }
    
    public static void main( String[] args )
    {
        WordBreak2 hp = new WordBreak2();
        
        final Set<String> wordDict = new HashSet<>();
        
        wordDict.add( "a" );
        wordDict.add( "abc" );
        wordDict.add( "b" );
        wordDict.add( "cd" );
        
        
        //wordDict.add( "code" );
        
        //System.out.println( " Word Break " + hp.wordBreak( "abcd", wordDict ) );
    }
}
