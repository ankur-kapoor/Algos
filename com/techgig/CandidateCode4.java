package com.techgig;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * Trapping Water 3D matrix
 * @author ankurkap
 *
 */

public class CandidateCode4
{
    public static int GetWaterLevel(int input1,int input2,int[] input3)
    {
        int[][] m = new int[input1][input2];
        boolean[][] v = new boolean[input1][input2];
        
        final PriorityQueue<Cell> pq = new PriorityQueue<>();
        
        int k = 0;
        for( int i = 0; i < input1; i++ )
        {
            for( int j = 0; j < input2; j++ )
            {
                if( j == 0 || j == input2-1 || i == 0 || i == input1-1 )
                {
                    pq.add( new Cell( i, j, input3[k] ) );
                    v[i][j] = true;
                }
                m[i][j] = input3[k];
                k++;
            }
        }
        
        int res = 0;
        
        final int dx[] = {0,1,0,-1};
        final int dy[] = {1,0,-1,0};
        
        System.out.println( " PQ = " + pq );
        
        while( !pq.isEmpty() )
        {
            final Cell c = pq.poll();
            
            for( int i = 0; i < 4; i++ )
            {
                int xx = c.x + dx[i];
                int yy = c.y + dy[i];
                
                if( xx >= 0 && xx < input1 && yy >= 0 && yy < input2 && !v[xx][yy] )
                {
                    res += Math.max( 0, c.h - m[xx][yy] );
                    
                    pq.add( new Cell( xx, yy, Math.max( c.h, m[xx][yy] ) ));
                    v[xx][yy] = true;
                }
            }
        }
        
        return res;
    }
    
    static class Cell implements Comparable<Cell>
    {
        int x;
        int y;
        Integer h;
        
        Cell( int xx, int yy, int hh )
        {
            x = xx;
            y = yy;
            h = hh;
        }
        
        @Override
        public int compareTo( Cell o )
        {
            return this.h.compareTo( o.h );
        }
        
        public String toString()
        {
            return "( " + x +", " + y + ")";
        }
    }
    
    public static void main( String[] args )
    {
       int n = 3;
       int m = 6;
       
       int[] nums =  {3,3,7,3,1,3,4,3,1,4,2,6,4,1,4,2,4,1};
       
       System.out.println( " Volume of water = " + GetWaterLevel( n, m, nums ) );
    }
}