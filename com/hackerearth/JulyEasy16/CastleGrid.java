package com.hackerearth.JulyEasy16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 *https://www.hackerearth.com/july-easy-16/algorithm/gudi-and-the-magical-orbs-july-easy/
 * @author ankurkap
 *
 */

public class CastleGrid
{
    public static void main(String[] args) 
    {
        final InputReader in = new InputReader( System.in );
        final PrintWriter out = new PrintWriter( System.out, true );
        
        int T = in.nextInt();
        
        
        for( int i =0; i < T; i++ )
        {
            
            int N = in.nextInt();
            int M = in.nextInt();
            int K = in.nextInt();
            
            int[][] arr = new int[N][M];
            int[][] res = new int[N][M];
            for( int j =0; j < N; j++ )
            {
                for( int k =0; k < M; k++ )
                {
                    arr[j][k] = in.nextInt();
                    
                    if( j > 0 && k > 0 )
                    {
                        
                    }
                    else if( j > 0 )
                    {
                        res[j][k] = res[j-1][k] + arr[j][k];
                    }
                    else if( k > 0 )
                    {
                        res[j][k] = res[j][k-1] + arr[j][k];
                    }
                    else
                    {
                        res[j][k] = arr[j][k];
                    }
                }
            }
            
            solveMax( res, arr, 0, 0, K );
            
            out.println( res[N-1][M-1] );
        }
        
        out.close();
        System.exit( 0 );
    }
    
    static int solveMax( int[][] res, int[][] arr, int row, int col, int K )
    {
        if( row == arr.length || col == arr[0].length )return 0;
        if( row == arr.length-1 && col == arr[0].length-1 )
        {
            return arr[row][col];
        }
        
        if( row == 0 && col > 0)
        {
            return res[row][col];
        }
        
        if( col == 0 && row > 0 )
        {
            return res[row][col];
        }
        
        if( res[row][col] != 0 && row !=0 && col != 0)
        {
            return res[row][col];
        }
        
        int t = arr[row][col];
        
        int p = solveMax( res, arr, row+1, col+1, K )+t;
        int q = solveMax( res, arr, row, col+1, K )+t;
        int r = solveMax( res, arr, row+1, col, K )+t;
        
        res[row][col] = Math.max( Math.min( r, K ), Math.max( Math.min( p, K ), Math.min( q, K ) ) );
        
        return res[row][col];
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
