package com.hackerrank.hourrank10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * https://www.hackerrank.com/contests/hourrank-10/challenges/jumping-on-the-clouds-revisited
 * @author ankurkap
 *
 */

public class CloudJump2
{
    
    public static void main(String[] args) 
    {
        final InputReader in = new InputReader( System.in );
        final PrintWriter out = new PrintWriter( System.out, true );
        
        final int N = in.nextInt();
        final int K = in.nextInt();
        
        int clouds = 0; 
        for( int i=0; i < N; i++ )
        {
            int ci = in.nextInt();
            
            if( ci == 1)
            {
                clouds |= (1 << i);
            }
        }
        
        int t = 0;
        
        int E = ((1<<t)&clouds) != 0 ? 97:99;
        t = (t + K)%N;
        
        
        while( t != 0 )
        {
            if( ((1<<t) & clouds) != 0 )
            {
                E -= 2;
            }
            
            E--;
            
            t = (t+K)%N;
        }
        
        System.out.println( E );
        
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
