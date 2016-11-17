package com.interviewbit.DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code".

Using BackTracking
 */
public class WordBreak
{
    public boolean wordBreak(String s, Set<String> wordDict) 
    {
        if( null == s || s.length() == 0 )
        {
            return false;
        }
        if( wordDict.contains( s )) return true;
        
        return wordPerm( s, 0, new ArrayList<String>(), wordDict );
    }
    
    
    private boolean wordPerm( String s, int index, List<String> path, Set<String> wordDict )
    {
        //System.out.println( "Path = " + path  );
        String sub = "";
        for( String p : path )
        {
            if( !wordDict.contains( p ))
            {
                return false;
            }
            sub += p;
        }
        
        if( sub.length() == s.length() ) return true;
        
        for( int i = index+1; i <= s.length(); i++ )
        {
            String st = s.substring( index, i );
            path.add( st );
            if( wordPerm( s, i, path, wordDict ))
            {
                return true;
            }
            path.remove( path.size()-1 );
        }
        
        return false;
    }
    
    
    public static void main( String[] args )
    {
        WordBreak hp = new WordBreak();
        
        final Set<String> wordDict = new HashSet<>();
        
        wordDict.add( "a" );
        wordDict.add( "abc" );
        wordDict.add( "b" );
        wordDict.add( "cd" );
        
        
        //wordDict.add( "code" );
        
        System.out.println( " Word Break " + hp.wordBreak( "abcd", wordDict ) );
    }
}
