package com.interviewbit.DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import javax.net.ssl.HandshakeCompletedEvent;

import sun.security.provider.DSAKeyFactory;

/**
 * Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.

Return all such possible sentences.

For example, given

s = "catsanddog",
dict = ["cat", "cats", "and", "sand", "dog"].
A solution is
 [ "cats and dog", "cat sand dog" ]  
 */

public class WordBreakII
{
    public ArrayList<String> wordBreak(String s, ArrayList<String> b) 
    {
        if( null == s || s.length() == 0 )
        {
            return null;
        }
        
        final Set<String> wordList = new HashSet<>(b);
        final Map<String, ArrayList<String>> map = new HashMap<>();
        
        final ArrayList<String> res = dfs( s, wordList, map );
        
        Collections.sort( res );
        
        return res;
    }
    
    final ArrayList<String> dfs( String s, Set<String> b, final Map<String, ArrayList<String>> map )
    {
        ArrayList<String> subList = map.get( s );
        
        if( null != subList )
        {
            return subList;
        }
        
        subList = new ArrayList<>();
        if( s.length() == 0 )
        {
            subList.add( "" );
            return subList;
        }
        
        for( String word : b )
        {
            if( s.startsWith( word ))
            {
                final List<String> newSubList = dfs( s.substring( word.length()), b, map );
                
                for( final String sb : newSubList )
                {
                    subList.add( word + (sb.isEmpty() ? "" : " ") + sb );
                }
            }
        }
        
        map.put( s, subList );
        return subList;
    }
    
    public static void main( String[] args )
    {
        WordBreakII hp = new WordBreakII();
        
        final ArrayList<String> wordDict = new ArrayList<>();
        
        wordDict.add( "bababbbb" );
        wordDict.add( "bbbabaa" );
        wordDict.add( "abbb" );
        wordDict.add( "a" );
        wordDict.add( "aabbaab" );
        wordDict.add( "b" );
        wordDict.add( "babaabbbb" );
        wordDict.add( "aa" );
        wordDict.add( "bb" );
        
        //wordDict.add( "code" );
        
        System.out.println( " Word Break " + hp.wordBreak( "aabbbabaaabbbabaabaab", wordDict ) );
    }
}
