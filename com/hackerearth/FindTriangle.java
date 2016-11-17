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

public class FindTriangle
{
    public static void main(String[] args) 
    {
        final InputReader in = new InputReader( System.in );
        final PrintWriter out = new PrintWriter( System.out, true );
        
        int T = in.nextInt();
        
        
        for( int i =0; i < T; i++ )
        {
            int N = in.nextInt();
            int[] a = new int[N];
            for( int j =0; j < N; j++ )
            {
                a[j] = in.nextInt();
            }
            
            int[] res = getMaxTriangle( a );
            
            if( res[0] == -1 )
            {
                out.print( -1 );
            }
            else
            {
                out.print( res[0] + " "  + res[1] + " " + res[2]);
            }
            
            out.println();
        }
        
        
        //out.println( count );
        
        out.close();
        System.exit( 0 );
    }
    
    private static int[] getMaxTriangle( final int[] a)
    {
        int N = a.length;
        final int[] res = new int[3];
        Arrays.fill( res, -1 );
        
        Arrays.sort( a );
        
        for( int i =N-1; i >= 0; i-- )
        {
            int k = i-2;
            for( int j =i-1; j >= 0; j-- )
            {
                while( k >= 0 && (a[k] + a[j]) > a[i])
                {
                    if( j != k )
                    {
                        res[0] = a[k];
                        res[1] = a[j];
                        res[2] = a[i];
                        return res;
                    }
                    
                    k--;
                }
            }
        }
        
        return res;
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
