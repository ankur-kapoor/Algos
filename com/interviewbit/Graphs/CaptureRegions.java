package com.interviewbit.Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

For example,
X X X X
X O O X
X X O X
X O X X
After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X
 * @author ankurkap
 *
 */

public class CaptureRegions
{
    public void solve(ArrayList<ArrayList<Character>> board) 
    {
        if( null == board || board.size() == 0 ) return;
        
        int N = board.size();
        int M = board.get( 0 ).size();
        
        final Queue<int[]> q = new LinkedList<>();
        int[] ar = new int[2];
        
        for( int i =0 ; i < N; i++ )
        {
            if(board.get( i ).get( 0 ) == 'O' )
            {
                board.get( i ).set( 0, '#' );
                ar[0] = i;
                ar[1] = 0;
                q.add( ar );
                bfs( board, q, N, M );
            }
            
            if( board.get( i ).get( M-1 ) == 'O' )
            {
                board.get( i ).set( M-1, '#' );
                ar[0] = i;
                ar[1] = M-1;
                q.add( ar );
                bfs( board, q, N, M );
            }
        }
        
        for( int i =0 ; i < M; i++ )
        {
            
            if(board.get( 0 ).get( i ) == 'O' )
            {
                board.get( 0 ).set( i, '#' );
                ar[0] = 0;
                ar[1] = i;
                q.add( ar );
                bfs( board, q, N, M );
            }
            
            if( board.get( N-1 ).get( i ) == 'O' )
            {
                board.get( N-1 ).set( i, '#' );
                ar[0] = N-1;
                ar[1] = i;
                q.add( ar );
                bfs( board, q, N, M );
            }
        }
        
        for( int i =0 ; i < N; i++ )
        {
            for( int j =0; j < M; j++ )
            {
                if( board.get( i ).get( j ) == 'O' )
                {
                   board.get( i ).set( j, 'X' ); 
                }
                else if(board.get( i ).get( j ) == '#')
                {
                    board.get( i ).set( j, 'O' ); 
                }
            }
        }
    }
    
    
    private void bfs( ArrayList<ArrayList<Character>> grid, final Queue<int[]> q, int N,
        int M  )
    {
        int[] dx = { 1, 0, -1, 0 };
        int[] dy = { 0, 1, 0, -1 };
        while( !q.isEmpty())
        {
            final int[] c = q.poll();
            
            for( int i=0; i< 4; i++ )
            {
                int xx = c[0] + dx[i];
                int yy = c[1] + dy[i];
                
                if ( xx >= 0 && xx < N && yy >= 0 && yy < M && grid.get( xx ).get( yy ) == 'O' )
                {
                    int[] cr = new int[2];
                    cr[0]=xx;
                    cr[1]=yy;
                    grid.get( xx ).set( yy, '#' );
                    q.add( cr );
                }
            }
        }
    }
    
    
    public static void main( String[] args )
    {
        final CaptureRegions bs = new CaptureRegions();
        
        String[] strA =
            { "XOX","OXO","XOX" };
        
        final char[][] grid = new char[strA.length][strA[0].length()];
        
        for( int i =0; i < strA.length; i++ )
        {
            grid[i] = strA[i].toCharArray();
        }
        
        //bs.solve( grid );
        
        
        System.out.println( "After Changes " + grid.toString()  );
        
        for( int i =0; i < grid.length; i++ )
        {
            for( int j =0; j < grid[0].length; j++ )
            {
                System.out.print( grid[i][j]+ " ");
            }
            System.out.println("");
        }
    }
    
}

