package com.interviewbit.Graphs;

import java.util.ArrayList;

/**
 * 
 *  Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

For example,
Given board =

[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false. 
 */
    
public class WordSearch2
{
    public int exist(ArrayList<String> A, String word) 
    {
        if( null == A || A.size() == 0 ) return 0;
        
        char[][] board = new char[A.size()][A.get( 0 ).length()];
        
        for( int i=0; i < A.size(); i++ )
        {
            board[i] = A.get( i ).toCharArray();
        }

        
        for( int x = 0; x < board.length; x++ )
        {
            for( int y = 0; y < board[x].length; y++ )
            {
                if( doExist( board, word, x, y, 0 ) )
                {
                    return 1;
                }
            }
        }
        
        return 0;
    }
    
    private boolean doExist( char[][] board, String word, int x, int y, int i )
    {
        if( x < 0 || x >= board.length || y < 0 || y >= board[0].length )
        {
            return false;
        }
        
        if( i == word.length())
        {
            return true;
        }
        
        char ch = word.charAt( i );
        
        if( ch == board[x][y])
        {
            return doExist( board, word, x+1, y, i+1 )
                   ||doExist( board, word, x, y+1, i+1 )
                   ||doExist( board, word, x-1, y, i+1 )
                   ||doExist( board, word, x, y-1, i+1 );
        }
           
        return false;
    }
    
    public static void main( String[] args )
    {
        char[][] board = {{'C','A','A'},
                          {'A','A','A'},
                          {'B','C','D'}};
        
        final WordSearch2 ws = new WordSearch2();
        
        //System.out.println( ws.exist( board, "AAB" ) );
        
    }
}
