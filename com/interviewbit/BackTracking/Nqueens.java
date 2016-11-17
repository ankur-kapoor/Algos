package com.interviewbit.BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.interviewbit.LinkedList.ListNode;

/**
 N-Queens Problem
 */
public class Nqueens
{
    public ArrayList<ArrayList<String>> solveNQueens(int n) 
    {
        char[][] board = new char[n][n];
        
        for( int i = 0; i < n; i++)
        {
            for( int j = 0; j < n; j++)
            {
                board[i][j] = '.';
            }
        }
        
        final ArrayList<ArrayList<String>> res = new ArrayList<>();
        solve( board, res, 0 );
        
        return res;
    }
    
    private void solve( char[][] board, final ArrayList<ArrayList<String>> res, int col )
    {
        if( col == board.length) 
        {
            res.add( getStringArr( board ) );
            return;
        }
        
        for( int i = 0; i < board.length; i++)
        {
            if( isValid( board, i, col ) )
            {
                board[i][col] = 'Q';
                
                solve( board, res, col+1 );
                
                board[i][col] = '.';
                
            }
        }
        
    }
    
    private ArrayList<String> getStringArr( char[][] board )
    {
        final ArrayList<String> strArr = new ArrayList<>();
        
        for( int i =0;i < board.length; i++)
        {
            String s = new String( board[i]);
            
            strArr.add( s );
        }
        
        return strArr;
    }
    
    private boolean isValid( char[][]board, int r, int c )
    {
        for( int i = 0; i <board.length; i++ )
        {
            if( board[r][i] == 'Q' ) return false;
        }
        
        for( int i = 0; i <board.length; i++ )
        {
            if( board[i][c] == 'Q' ) return false;
        }
        
        int i = r;
        int j = c;
        
        // top left
        while( i>=0 && j >= 0 )
        {
            if( board[i--][j--] == 'Q') return false;
        }
        
        
        i=r;
        j=c;
        // bottom left
        while( i < board.length && j >= 0 )
        {
            if( board[i++][j--] == 'Q') return false;
        }
        
        i=r;
        j=c;
        // bottom right
        while( i < board.length && j < board.length )
        {
            if( board[i++][j++] == 'Q') return false;
        }
        
        i=r;
        j=c;
        // top right
        while( i >= 0 && j < board.length )
        {
            if( board[i--][j++] == 'Q') return false;
        }
    
        return true;
    }
    
    public static void main( String[] args )
    {
        
        final Nqueens r = new Nqueens();
        System.out.println( "N Queens =" + r.solveNQueens( 5 ) );
        
    }
}
