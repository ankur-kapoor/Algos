package com.hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 *https://www.hackerearth.com/IITK-WPC-Summer16/algorithm/om-nom-and-candies/
 * @author ankurkap
 *
 */

public class NomCandies
{
    public static void main(String[] args) 
    {
        final InputReader in = new InputReader( System.in );
        final PrintWriter out = new PrintWriter( System.out, true );
        
        int N = in.nextInt();
        
        int[] a = new int[N];
        for( int i =0; i < N; i++ )
        {
            a[i] = in.nextInt();
        }
        
        int[] res = Arrays.copyOf( a, N );
        
        for( int i = 0; i < N; i++)
        {
            int t = i+1;
            int c = 2;
            int m = t*c;
            while( m-1 < N )
            {
                res[m-1] += a[i];
                c++;
                m =t*c;
            }
        }
        
        for( int i = 0; i < N; i++)
        {
            out.print( res[i]+ " " );
        }
        //out.println( count );
        
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
