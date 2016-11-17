package com.interviewbit.Graphs;

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
    
public class WordSearch
{
    public boolean exist(char[][] board, String word) 
    {
        if( null == board || board.length == 0 ) return false;
        
        for( int x = 0; x < board.length; x++ )
        {
            for( int y = 0; y < board[0].length; y++ )
            {
                if( word.charAt( 0 ) == board[x][y] )
                {
                    board[x][y] ^= 256;
                    if( doExist( board, word, x, y, 1 ) )
                    {
                        return true;
                    }
                    board[x][y] ^= 256;
                }
            }
        }
        
        return false;
    }
    
    private boolean doExist( char[][] board, String word, int x, int y, int i )
    {
        if( i == word.length())
        {
            return true;
        }
        
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,-1,1};
        
        for( int k =0; k < 4; k++ )
        {
            int xx = x + dx[k];
            int yy = y + dy[k];
            
            if( xx >= 0 && xx < board.length && yy >=0 && yy < board[0].length )
            {
                if( board[xx][yy] == word.charAt( i ))
                {
                    board[xx][yy] ^= 256;
                    if(!doExist( board, word, xx, yy, i+1 ))
                    {
                        board[xx][yy] ^= 256;
                    }
                    else
                    {
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
    
    public static void main( String[] args )
    {
        char[][] board = {{'C','A','A'},
                          {'A','A','A'},
                          {'B','C','D'}};
        
        final WordSearch ws = new WordSearch();
        
        System.out.println( ws.exist( board, "AAB" ) );
        
    }
}
