package com.interviewbit.DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import javax.net.ssl.HandshakeCompletedEvent;

/**
 * Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code".

Using BFS
 */
public class WordBreak3
{
    public int wordBreak(String s, ArrayList<String> b) 
    {
        if( null == s || s.length() == 0 )
        {
            return 0;
        }
        final Set<String> wordDict = new HashSet<>(b);
        List<Integer> starts = new LinkedList<Integer>();
        starts.add(0);
        
        for (int end=1;end<=s.length();end++){
            boolean found=false;
            for (Integer start:starts)
                if (wordDict.contains(s.substring(start,end))){
                    found=true;
                    break;
                }
            if(found)  starts.add(0,end);
        }

        return starts.get(0)==s.length() ? 1 : 0;
        
    }
    
    public static void main( String[] args )
    {
        WordBreak3 hp = new WordBreak3();
        
        final Set<String> wordDict = new HashSet<>();
        
        wordDict.add( "a" );
        wordDict.add( "abc" );
        wordDict.add( "b" );
        wordDict.add( "cd" );
        
        
        //wordDict.add( "code" );
        
        //System.out.println( " Word Break " + hp.wordBreak( "abcd", wordDict ) );
    }
}
