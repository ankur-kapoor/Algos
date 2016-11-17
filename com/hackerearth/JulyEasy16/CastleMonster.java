package com.hackerearth.JulyEasy16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

/**
 *https://www.hackerearth.com/july-easy-16/algorithm/the-string-monster-july-easy/
 * @author ankurkap
 *
 */

public class CastleMonster
{
    public static void main(String[] args) 
    {
        final InputReader in = new InputReader( System.in );
        final PrintWriter out = new PrintWriter( System.out, true );
        
        int T = in.nextInt();
        
        for( int i =0; i < T; i++ )
        {
            int N = in.nextInt();
            final Trie trie = new Trie();
            for( int j = 0; j < N; j++)
            {
                String s = in.next();
                trie.addWord( s );
            }
            
            String targetWord = in.next();
            
            if( trie.findWord( targetWord ))
            {
                System.out.println("YES");
            }
            else
            {
                System.out.println("NO");
            }
        }
        
        out.close();
        System.exit( 0 );
    }
    
    static class TrieNode
    {
        final TrieNode[] children = new TrieNode[26];
        char ch;
        boolean isWord;
        int length;
        String label;
        TrieNode()
        {
            
        }
        
        TrieNode( char chr, String value )
        {
            ch = chr;
            label = value;
        }
        
        
        @Override
        public String toString()
        {
            return String.valueOf( ch ) + "-" + length;
        }
    }
    
    static class Trie
    {
        final TrieNode root;
        
        Trie()
        {
            root = new TrieNode();
        }
        
        public void addWord( final String word )
        {
            if( null == word )
            {
                return;
            }
            
            final char[] chaArr = word.toCharArray();
            TrieNode t = root;
            for( int i=0; i< chaArr.length; i++ )
            {
                char c = chaArr[i];
                final TrieNode[] tchildlren = t.children;
                
                if( tchildlren[c-'a'] == null )
                {
                    t = new TrieNode( c, word );
                    tchildlren[c-'a'] = t;
                }
                else
                {
                    t = tchildlren[c-'a'];
                }
                
                if( i == word.length()-1)
                {
                    t.isWord = true;
                    t.length = word.length();
                }
            }
        }
        
        public boolean findWord( final String targetWord )
        {
            if( null == targetWord )
            {
                return false;
            }
            
            final List<TrieNode> nodes = new ArrayList<>();
            
            char[] chArr = targetWord.toCharArray();
            for( final char ch : chArr )
            {
                final List<TrieNode> newNodes = matchNode( ch, nodes ); 
                nodes.addAll( newNodes );
            }
            
            int cnt = 0;
            final Map<String, Integer> map = new HashMap<>(); 
            for( final TrieNode node : nodes )
            {
                Integer c = map.get( node.label );
                
                if( c == null)
                {
                    c =1;
                    map.put( node.label, c );
                }
                else
                {
                    map.put( node.label, c+1 );
                    c++;
                }
                
                if( c == node.label.length())
                {
                    cnt +=c;
                }
            }
            
            if( cnt == targetWord.length() ) 
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        
        private List<TrieNode> matchNode( final char ch, final List<TrieNode> nodes )
        {
            final List<TrieNode> newNodes = new ArrayList<>();
            
            if( null != nodes )
            {
                for(  int i =0; i< nodes.size() ; i++ )
                {
                    final TrieNode node = nodes.get( i );
                    
                    if( node.children[ch-'a'] != null )
                    {
                        newNodes.add( node.children[ch-'a'] );
                    }
                }
            }
            
            if( root.children[ch-'a'] != null )
            {
                newNodes.add( root.children[ch-'a'] );
            }
            
            return newNodes;
        }
    }
    
    static class InputReader
    {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader( InputStream stream )
        {
            reader = new BufferedReader( new InputStreamReader( stream ), 32768 );
            tokenizer = null;
        }

        public String next()
        {
            while ( tokenizer == null || !tokenizer.hasMoreTokens() )
            {
                try
                {
                    tokenizer = new StringTokenizer( reader.readLine() );
                }
                catch ( IOException e )
                {
                    throw new RuntimeException( e );
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt()
        {
            return Integer.parseInt( next() );
        }
        
        public long nextLong()
        {
            return Long.parseLong( next() );
        }
    }

}
