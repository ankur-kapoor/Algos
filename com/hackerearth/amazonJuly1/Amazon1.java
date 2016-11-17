package com.hackerearth.amazonJuly1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 *https://www.hackerearth.com/july-easy-16/algorithm/the-castle-gate-july-easy/
 * @author ankurkap
 *
 */

public class Amazon1
{
    public static void main(String[] args) 
    {
        final InputReader in = new InputReader( System.in );
        final PrintWriter out = new PrintWriter( System.out, true );
        
        int N = in.nextInt();
        
        int[] indexes = new int[1000000];
        
        int k=1;
        for( int i =1; i <= N; i++ )
        {
            int ci = in.nextInt();
            
            for( int j =0; j < ci; j++ )
            {
                indexes[k++] = i; 
            }
        }
        
        int Q = in.nextInt();
        
        for( int i =0; i < Q; i++ )
        {
            int q = in.nextInt();
            out.println( indexes[q]);
        }
        
        out.close();
        System.exit( 0 );
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
