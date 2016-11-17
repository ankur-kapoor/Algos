package com.interviewbit.Graphs;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Given N * M field of O's and X's, where O=white, X=black
Return the number of black shapes. A black shape consists of one or more adjacent X's (diagonals not included)

Example:

OOOXOOO
OOXXOXO
OXOOOXO

answer is 3 shapes are  :
(i)    X
     X X
(ii)
      X
 (iii)
      X
      X
Note that we are looking for connected shapes here.

For example,

XXX
XXX
XXX
is just one single connected black shape.
 * @author ankurkap
 *
 */

public class BlackShapes
{
    
    public int black( ArrayList<String> grid )
    {
        if( null== grid || grid.size() == 0 ) return 0;
        
        int N = grid.size();
        int M = grid.get( 0 ).length();
        boolean[][] v = new boolean[N][M];
        
        final Stack<Cell> st = new Stack<>();
        
        for( int i = 0; i < N; i++ )
        {
            for( int j = 0; j < M; j++ )
            {
                if( grid.get( i ).charAt( j ) == 'X' && !v[i][j])
                {
                   dfs( grid, v, st, N, M, i, j ); 
                }
            }
        }
        
        v = new boolean[N][M];
       
        int res = 0;
        while( !st.isEmpty())
        {
            final Cell c = st.pop();
            
            if( !v[c.x][c.y])
            {
                dfs( grid, v, null, N, M, c.x, c.y );
                res++;
            }
        }
        
        return res;
    }
    
    
    private void dfs( final ArrayList<String> grid, final boolean[][] v, final Stack<Cell> st, int N,
        int M, int x, int y )
    {
        int[] dx = { 1, 0, -1, 0 };
        int[] dy = { 0, 1, 0, -1 };
        
        v[x][y] = true;
        for( int i=0; i< 4; i++ )
        {
            int xx = x + dx[i];
            int yy = y + dy[i];
            
            if( xx >=0 && xx < N && yy >= 0 && yy < M && !v[xx][yy] && grid.get( xx ).charAt( yy ) == 'X' )
            {
                dfs( grid, v, st, N, M, xx, yy );
            }
        }
        
        if( null != st )
        {
            st.push( new Cell(x, y) );
        }
        
    }
    
    class Cell
    {
        int x;
        int y;
        Cell( int _x, int _y )
        {
            x = _x;
            y = _y;
        }
    }
    
    public static void main( String[] args )
    {
        final BlackShapes bs = new BlackShapes();
        
        final ArrayList<String> grid = new ArrayList<>();
        
        grid.add( "OOOXOOO" );
        grid.add( "OOXXOXO" );
        grid.add( "OXOOOXO" );
        
        System.out.println( "No. of Black Shapes = " + bs.black( grid )  );
    }
    
}

