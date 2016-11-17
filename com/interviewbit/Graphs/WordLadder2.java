package com.interviewbit.Graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import com.sun.xml.internal.ws.wsdl.writer.document.StartWithExtensionsType;

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
Return
  [
    ["hit","hot","dot","dog","cog"],
    ["hit","hot","lot","log","cog"]
  ]
Note:
Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.

 @author ankurkap
 *
 */

public class WordLadder2
{
    
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList)
    {
        final List<List<String>> res = new ArrayList<>();
        
        if( wordList == null  || wordList.size() == 0 ) return res;
        
        if( null == beginWord || null == endWord ) return res;
        
        if( beginWord.equals( endWord ))
        {
            return res;
        }
        
        bfs( beginWord, endWord, wordList, res );
        
        return res;
    }
    
    private void bfs( String beginWord, String endWord, Set<String> wordList, final List<List<String>> res )
    {
        int cnt = 1;
        Queue<String> q = new LinkedList<>();
        q.add( beginWord );
        
        final Map<String, List<String>> parentMap = new HashMap<>();
        Queue<String> tempQ = new LinkedList<>();
        int min = Integer.MAX_VALUE;
        final Set<String> wl =  new HashSet<>(wordList);
        while( !q.isEmpty() )
        {
            if( cnt > min)
            {
                tracePath( parentMap, beginWord, endWord, new ArrayList<String>(), res );
                break;
            }
            String word = q.poll();
            char[] wordArr = word.toCharArray();
            boolean brk = false;
            for( int i = 0; i < word.length(); i++ )
            {
                char temp = wordArr[i];
                for( char c = 'a'; c <= 'z'; c++ )
                {
                    wordArr[i] =  c;
                    String tempWord = String.valueOf( wordArr );
                    
                    if( endWord.equals( tempWord ))
                    {
                        if( min > cnt )
                        {
                            min = cnt;
                            if( parentMap.containsKey( tempWord ))
                            {
                                parentMap.get( tempWord ).add( word );
                            }
                            else
                            {
                                List<String> st = new ArrayList<>();
                                st.add( word );
                                parentMap.put( tempWord, st );
                            }
                        }
                        
                        brk = true;
                    }
                    
                    if( wordList.contains( tempWord ) )
                    {
                        if( !brk && !tempWord.equals( word ))
                        {
                            if( parentMap.containsKey( tempWord ))
                            {
                                parentMap.get( tempWord ).add( word );
                            }
                            else
                            {
                                List<String> st = new ArrayList<>();
                                st.add( word );
                                parentMap.put( tempWord, st );
                            }
                            if( !wl.isEmpty())
                            {
                                tempQ.add( tempWord );
                            }
                            
                            if( wl.contains( tempWord ))
                            {
                                wl.remove( tempWord );
                            }
                        }
                    }
                    
                    wordArr[i] = temp;
                    
                    if( brk )
                    {
                        break;
                    }
                }
                
                if( brk )
                {
                    break;
                }
            }
            
            if( q.isEmpty() )
            {
                cnt++;
                q = tempQ;
                tempQ = new LinkedList<>();
            }
        }
    }
    
    private void tracePath( final Map<String, List<String>> m, final String startWord, final String endWord,
        final List<String> path, final List<List<String>> res )
    {
        
        if ( endWord.equals( startWord ) )
        {
            path.add( 0, startWord );
            res.add( new ArrayList<String>( path ) );
            path.remove( 0 );
            return;
        }
        
        path.add(0,endWord);
        if(m.containsKey( endWord ))
        {
            for (String s:m.get(endWord))
            {
                tracePath( m, startWord, s, path, res );
            }
        }
        path.remove(0);
    }
    
    public static void main( String[] args )
    {
        final WordLadder2 bs = new WordLadder2();
        
        final String beginWord = "red";
        final String endWord = "tax";
        
        String[] strArr = {"ted","tex","red","tax","tad","den","rex","pee"};
        final Set<String> wordList = new HashSet<>();
        
        for( String s : strArr )
        {
            wordList.add( s );
        }
        
        System.out.println( "Conversion Steps = "+  bs.findLadders( beginWord, endWord, wordList ) );
    }
    
}
