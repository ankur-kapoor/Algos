package com.interviewbit.Graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 *Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time
Each intermediate word must exist in the word list
For example,

Given:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]
As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

Note:
Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.

 @author ankurkap
 *
 */

public class WordLadder
{
    
    public int ladderLength(String beginWord, String endWord, ArrayList<String> dictV)
    {
        if( dictV == null  || dictV.size() == 0 ) return 0;
        
        if( null == beginWord || null == endWord ) return 0;
        
        if( beginWord.equals( endWord )) return 0;
        
        final Set<String> wordList = new HashSet<>();
        
        wordList.addAll( dictV );
        
        return bfs( beginWord, endWord, wordList );
    }
    
    private int bfs( String beginWord, String endWord, Set<String> wordList )
    {
        int cnt = 1;
        
        Queue<String> q = new LinkedList<>();
        q.add( beginWord );
        
        Queue<String> tempQ = new LinkedList<>();
        while( !q.isEmpty() )
        {
            String word = q.poll();
            char[] wordArr = word.toCharArray();
            for( int i = 0; i < word.length(); i++ )
            {
                char temp = wordArr[i];
                for( char c = 'a'; c <= 'z'; c++ )
                {
                    wordArr[i] =  c;
                    String tempWord = String.valueOf( wordArr );
                    
                    if( endWord.equals( tempWord ))
                    {
                        return cnt+1;
                    }
                    
                    if( wordList.contains( tempWord ))
                    {
                        tempQ.add( tempWord );
                        wordList.remove( tempWord );
                    }
                    
                    wordArr[i] = temp;
                }
            }
            
            if( q.isEmpty() )
            {
                q = tempQ;
                cnt++;
                tempQ = new LinkedList<>();
            }
        }
        
        return 0;
    }
    
    public static void main( String[] args )
    {
        final WordLadder bs = new WordLadder();
        
        final String beginWord = "hit";
        final String endWord = "cog";
        
        String[] strArr = {"hot","dot","dog","lot","log"};
        final Set<String> wordList = new HashSet<>();
        
        for( String s : strArr )
        {
            wordList.add( s );
        }
        
        //System.out.println( "Conversion Steps = "+  bs.ladderLength( beginWord, endWord, wordList ) );
    }
    
}
