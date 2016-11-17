package com.hackerearth.JulyEasy16;

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

public class CastleGate
{
    public static void main(String[] args) 
    {
        final InputReader in = new InputReader( System.in );
        final PrintWriter out = new PrintWriter( System.out, true );
        
        int T = in.nextInt();
        
        for( int i =0; i < T; i++ )
        {
            int N = in.nextInt();
            
            int cnt =0;
            
            for( int j = 1; j < N; j++)
            {
                for( int k = j+1; k <= N; k++)
                {
                    if( (k^j) <= N )
                    {
                        cnt++;
                    }
                }
            }
            
            out.println( cnt );
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
