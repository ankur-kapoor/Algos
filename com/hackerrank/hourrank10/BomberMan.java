package com.hackerrank.hourrank10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * https://www.hackerrank.com/contests/hourrank-10/challenges/bomber-man
 * @author ankurkap
 *
 */

public class BomberMan
{
    
    public static void main(String[] args) 
    {
        final InputReader in = new InputReader( System.in );
        final PrintWriter out = new PrintWriter( System.out, true );
        
        final int R = in.nextInt();
        final int C = in.nextInt();
        final int N = in.nextInt();
        
        Map<Cell, Cell> cells = new HashMap<>();
        for( int i =0; i < R; i++ )
        {
            String str = in.next();
            char[] strArr = str.toCharArray();
            
            for( int j =0; j < C; j++ )
            {
                char ch = strArr[j];
                final Cell cell = new Cell( i, j, 0, true ); 
                
                if( ch == '.')
                {
                    cell.isBomb = false;
                }
                
                cells.put( cell, cell );
            }
        }
        
        int time = 1;
        
        final int M;
        if( N > 12 )
        {
            int t = N%4;
            M = 8 + t;
        }
        else
        {
            M = N;
        }
        
        while( time <= M )
        {
            // plant the bomb
            if( (time % 2) == 0 )
            {   
                for( final Cell cell : cells.values() )
                {
                    if( !cell.isBomb )
                    {
                        cell.isBomb = true;
                        cell.seconds = time;
                    }
                }
            }
            else
            {
                final Map<Cell, Cell> cellMap = new HashMap<>();
                for( final Cell cell : cells.values() )
                {
                    if( cell.isBomb && (time - cell.seconds) >= 3 )
                    {
                        int[] dx ={ 1,0,-1,0};
                        int[] dy ={ 0,1,0,-1};
                        
                        cell.isBomb = false;
                        cells.put( cell, cell );
                        
                        for( int i =0; i < 4; i++ )
                        {
                            int rx = dx[i] + cell.row;
                            int cy = dy[i] + cell.col;
                            
                            if( rx >= 0 && rx < R && cy >=0 && cy < C )
                            {
                                final Cell newCell = new Cell( rx, cy, 0, false );
                                cellMap.put( newCell, newCell );
                            }
                        }
                    }
                }
                
                cells.putAll( cellMap );
            }
            
            time++;
        }
        
        printGrid( out, R, C, cells );
        
        out.close();
        System.exit( 0 );
    }

    private static void printGrid( final PrintWriter out, final int R, final int C, Map<Cell, Cell> cells )
    {
        for( int i =0; i < R; i++)
        {
            for( int j =0; j < C; j++)
            {
                final Cell c = new Cell( i, j, 0, false);
                
                final Cell c1 = cells.get( c );
                
                if( c1.isBomb )
                {
                    out.print( "O" );
                }
                else
                {
                    out.print( "." );
                }
            }
            out.println( "" );
        }
    }
    
    static class Cell 
    {
        Integer seconds;
        Integer secondsElapsed;
        int row;
        int col;
        boolean isBomb;
        
        public Cell( int r, int c, int sec, boolean bomb )
        {
            row = r;
            col = c;
            isBomb = bomb;
            seconds = sec;
        }
        
        public void setSeconds( int sec )
        {
            this.seconds = sec;
        }
        
        public void setElapsed( int sec )
        {
            this.secondsElapsed = sec - this.seconds;
        }

        @Override
        public boolean equals( Object o)
        {
            final Cell cell = (Cell)o;
            
            return ( this.row == cell.row && this.col == cell.col);
        }
        
        @Override
        public int hashCode()
        {
            int r = this.row+1;
            int c = this.col+1;
            
            int hash = (((r*c)%(r+c) * (r+c))^(r))^c;
            
            return hash;
        }
        
    }
    
    static class InputReader
    {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader( InputStream stream )
        {
            reader = new BufferedReader( new InputStreamReader( stream ), 32768 );
            tokenizer = null;
        }

        public String next()
        {
            while ( tokenizer == null || !tokenizer.hasMoreTokens() )
            {
                try
                {
                    tokenizer = new StringTokenizer( reader.readLine() );
                }
                catch ( IOException e )
                {
                    throw new RuntimeException( e );
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt()
        {
            return Integer.parseInt( next() );
        }
        
        public long nextLong()
        {
            return Long.parseLong( next() );
        }
    }

}
