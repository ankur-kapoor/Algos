package com.interviewbit.Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 *Knight movement on a chess board

Given any source point and destination point on a chess board, we need to find whether Knight can move to the destination or not.

Knight's movements

The above figure details the movements for a knight ( 8 possibilities ). Note that a knight cannot go out of the board.

If yes, then what would be the minimum number of steps for the knight to move to the said point.
If knight can not move from the source point to the destination point, then return -1

Input:

N, M, x1, y1, x2, y2
where N and M are size of chess board
x1, y1  coordinates of source point
x2, y2  coordinates of destination point
Output:

return Minimum moves or -1
Example

Input : 8 8 1 1 8 8
Output :  6 * @author ankurkap
 *
 */

public class KnightsChess
{
    
    public int knight( int N, int M, int x1, int y1, int x2, int y2 )
    {
        final Cell source = new Cell(x1-1, y1-1, 0);
        source.setCount( 0 );
        final Cell destination = new Cell(x2-1, y2-1, Integer.MAX_VALUE);
        
        Queue<Cell> q = new LinkedList<>();
        
        boolean[][] v = new boolean[N][M];
        v[x1-1][y1-1] = true;
        q.add( source );
        
        final Cell res = bfs( N, M, q, v, destination );
       
        return null != res ? res.cnt : -1;
    }
    
    private Cell bfs( int N, int M, Queue<Cell> q, final boolean[][] v, final Cell destination )
    {
        int[] dx = {-1,-2,1,2,-1,-2,1,2};
        int[] dy = {2,1,2,1,-2,-1,-2,-1};
        
        int cnt=0;
        Queue<Cell> temp = new LinkedList<>();
        while( !q.isEmpty())
        {
            final Cell c = q.poll();
            for( int i=0; i < 8; i++)
            {
                int xx = c.x + dx[i];
                int yy = c.y + dy[i];
                
                if( xx >= 0 && xx < N && yy >=0 && yy < M && !v[xx][yy])
                {
                    v[xx][yy] = true;
                    final Cell ce = new Cell(xx, yy, cnt+1);
                    
                    if( ce.equals( destination ) )
                    {
                        return ce ;
                    }
                    
                    temp.offer( ce );
                }
            }
            
            if( q.isEmpty() )
            {
                q = temp;
                temp = new LinkedList<>();
                cnt++;
            }
        }
        
        return null;
    }
    
   /* public static void main( String[] args )
    {
        final KnightsChess bs = new KnightsChess();
        
        int n = 0;
        int m = 2000000000;
        
        System.out.println( "Minimum Steps = "+  bs.knight( 8, 8, 1, 1, 8, 8 ) );
    }*/
    
}

class Cell implements Comparable<Cell>
{
    int x;
    int y;
    Integer cnt;
    
    Cell( int _x, int _y, int val )
    {
        x = _x;
        y = _y;
        cnt = val;
    }
    
    public void setCount( int val )
    {
        this.cnt = val;
    }
    
    @Override
    public boolean equals( Object o )
    {
        Cell c  = (Cell)o;
        return this.x == c.x && this.y == c.y;
    }

    @Override
    public int compareTo( Cell o )
    {
        return this.cnt.compareTo( o.cnt );
    }
}