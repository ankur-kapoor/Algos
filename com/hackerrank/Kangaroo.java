package com.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 *https://www.hackerrank.com/contests/w21/challenges/kangaroo
 * @author ankurkap
 *
 */

public class Kangaroo
{
    
    public static void main(String[] args) 
    {
        final InputReader in = new InputReader( System.in );
        final PrintWriter out = new PrintWriter( System.out, true );
        
        int x1 = in.nextInt();
        int v1 = in.nextInt();
        
        int x2 = in.nextInt();
        int v2 = in.nextInt();
        
        if( x1 > x2 )
        {
            int t = x2;
            x2 = x1;
            x1 = t;
            
            t = v2;
            v2 = v1;
            v1 = t;
        }
        
        int d2 = x2+v2;
        int d1 = x1+v1;
        
        if( (d2-d1) >= (x2-x1))
        {
            System.out.println("NO");
            return;
        }
        
        while( (d2-d1) > 0 )
        {
            d2 += v2;
            d1 += v1;
        }
        
        if( d2 == d1 )
        {
            System.out.println("YES");
        }
        else
        {
            System.out.println("NO");
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
