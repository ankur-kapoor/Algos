package com.interviewbit.BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.interviewbit.LinkedList.ListNode;

/**
 Sudoku Solver
 */
public class Sudoku
{
    public void solveSudoku( ArrayList<ArrayList<Character>> board )
    {
        solve( board );
    }
    
    private boolean solve( final ArrayList<ArrayList<Character>> board )
    {
        for( int i =0; i < board.size(); i++ )
        {
            for( int j =0; j < board.get( 0 ).size(); j++ )
            {
                if( board.get( i ).get( j ) == '.' )
                {
                    for( char c = '1'; c <= '9'; c++)
                    {
                        if( isValid( board, c, i, j ))
                        {
                            board.get( i ).set( j, c );
                            
                            if( solve( board ))
                            {
                                return true;
                            }
                            else
                            {
                                board.get( i ).set( j, '.' );
                            }
                        }
                    }
                    
                    return false;
                }
            }
        }
        
        return true;
    }
    
    private boolean isValid( final ArrayList<ArrayList<Character>> board, char ch, int r, int c )
    {
        for( int i =0; i < board.get( r ).size(); i++ )
        {
            if( board.get( r ).get( i ) == ch ) return false;
        }
        
        for( int i =0; i < board.size(); i++ )
        {
            if( board.get( i ).get( c ) == ch ) return false;
        }
        
        for( int i =(r/3)*3; i < (r/3)*3 + 3; i++ )
        {
            for( int j =(c/3)*3; j < (c/3)*3 + 3; j++ )
            {
                if( board.get( i ).get( j ) == ch ) return false;
            }
        }
        
        return true;
    }
    
    public static void main( String[] args )
    {
        
        final Sudoku r = new Sudoku();
        Integer[] li = {1,2,3};
        ArrayList<Integer> ai = new ArrayList<>(Arrays.asList( li )); 
       // System.out.println( "Combine " + r.combine( 5, 3 ) );
        
    }
}
