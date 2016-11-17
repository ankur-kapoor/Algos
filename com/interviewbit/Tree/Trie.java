package com.interviewbit.Tree;


/**
 * Implement a trie with insert, search, and startsWith methods.

Analysis

A trie node should contains the character, its children and the flag that marks if it is a leaf node.

Java Solution


*/
class TrieNode
{
    char c;
    TrieNode[] children = new TrieNode[26];
    boolean isLeaf;
    
    public TrieNode()
    {}
    
    public TrieNode( char ch )
    {
        this.c = ch;
    }
}

public class Trie
{
    private final TrieNode m_root;
    
    public Trie()
    {
        m_root = new TrieNode(); 
    }
    
    // Inserts a word into the trie.
    public void insert(final String word)
    {
        if( word == null ) return;
        
        final String newWord = word.toLowerCase();
        TrieNode t = m_root;
        for( int i =0; i < newWord.length(); i++)
        {
            char ch = newWord.charAt( i );
            TrieNode[] childs = t.children;
            
            if( null == childs[ch-'a'])
            {
                t = new TrieNode( ch );
                childs[ch-'a'] = t;
            }
            else
            {
                t = childs[ch-'a'];
            }
            
            if( i == word.length()-1 )
            {
                t.isLeaf = true;
            }
        }
    }
    
    // Returns if the word is in the trie.
    public boolean search(String word) 
    {
        if( null == word ) return false;
        
        final TrieNode n = searchNode( word.toLowerCase() );
        
        if( null != n && n.isLeaf )
        {
            return true;
        }
        
        return false;
    }
    
    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix)
    {
        if( null == prefix ) return false;
        
        if( null != searchNode( prefix.toLowerCase() ))
        {
            return true;
        }
        
        return false;
    }
    
    private TrieNode searchNode( final String val )
    {
        TrieNode t = m_root;
        for( int i =0; i < val.length(); i++)
        {
            char ch = val.charAt( i );
            TrieNode[] childs = t.children;
            
            if( childs[ch-'a'] != null )
            {
                t = childs[ch-'a'];
            }
            else
            {
                return null;
            }
        }
        
        return t;
    }
    
    public String toString()
    {
        return String.valueOf( m_root.c  ) + m_root.children;
    }
    
    public static void main( String[] args )
    {
        final Trie tr = new Trie();
        
        tr.insert( "Ankur" );
        tr.insert( "amit" );
        tr.insert( "Ulhas" );
        tr.insert( "shailendra" );
        tr.insert( "ricky" );
        tr.insert( "pruthy" );
        
        System.out.print( tr );
        
        String searchWord = "Rahul";
        if( tr.search( searchWord ))
        {
            System.out.println( searchWord + " Found");
        }
        else
        {
            System.out.println( searchWord + " Not Found");
        }
        
        String searchPrefix = "Ami";
        if( tr.startsWith( searchPrefix ))
        {
            System.out.println( searchPrefix + " Found prefix");
        }
        else
        {
            System.out.println( searchPrefix + " Not Found prefix");
        }
    }
}
