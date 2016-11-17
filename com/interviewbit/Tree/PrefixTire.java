package com.interviewbit.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Implement a trie with insert, search, and startsWith methods.

Analysis

A trie node should contains the character, its children and the flag that marks if it is a leaf node.

Java Solution


*/

public class PrefixTire
{
    class TrieNode
    {
        char c;
        Map<Character, TrieNode> children = new HashMap<>();
        
        public TrieNode()
        {}
        
        public TrieNode( char ch )
        {
            this.c = ch;
        }
    }
    
    private final TrieNode m_root = new TrieNode();
    private void insert(final String word)
    {
        if( word == null ) return;
        
        final String newWord = word.toLowerCase();
        TrieNode t = m_root;
        for( int i =0; i < newWord.length(); i++)
        {
            char ch = newWord.charAt( i );
            Map<Character, TrieNode> childs = t.children;
            
            if( !childs.containsKey( ch ))
            {
                t = new TrieNode( ch );
                childs.put( ch, t );
            }
            else
            {
                t = childs.get( ch );
            }
        }
    }
    
    public ArrayList<String> prefix(ArrayList<String> a) 
    {
        final ArrayList<String> res = new ArrayList<>();
        
        for( final String str : a )
        {
            insert( str );
        }
        
        for( final String str : a )
        {
            TrieNode t = m_root;
            
            int index = -1;
            for( int i =0; i < str.length(); i++)
            {
                char ch = str.charAt( i );
                Map<Character, TrieNode> childs = t.children;
                t = childs.get( ch );
                
                if( null != t && t.children.size() > 1 )
                {
                    index = i+1;
                }
            }
            
            if( index != -1 )
            {
                res.add( str.substring( 0, index+1 ) );
            }
            else
            {
                res.add( String.valueOf( str.charAt( 0 ) ) );
            }
        }
        
        return res;
    }
    
    public static void main( String[] args )
    {
        final PrefixTire tr = new PrefixTire();
        
        final String[] strArr = {"zebra", "dog", "dove", "duck"};
        
        final ArrayList<String> a = new ArrayList<>( Arrays.asList( strArr ));
        
        System.out.println( tr.prefix( a ) );
        
    } 
}
