package com.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * https://www.hackerrank.com/contests/world-codesprint-april/challenges/jumping-on-the-clouds
 * @author ankurkap
 *
 */

public class CloudJump
{
    
    public static void main(String[] args) 
    {
        final InputReader in = new InputReader( System.in );
        final PrintWriter out = new PrintWriter( System.out, true );
        
        int n = in.nextInt();
        
        int[] a = new int[n];
        
        for( int i=0; i< n; i++)
        {
            a[i] = in.nextInt();
        }
        
        int sum = 0;
        
        for( int i=0; i< n; )
        {
            if( i+2 < n && a[i+2] != 1 )
            {
                i +=2;
            }
            else 
            {
                i +=1;
            }
            
            if( i >=n) break;
            
            sum++;    
        }
       
        out.println( sum );
        
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
