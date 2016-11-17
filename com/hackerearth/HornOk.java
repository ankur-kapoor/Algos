package com.hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 *https://www.hackerearth.com/IITK-WPC-Summer16/algorithm/horn-ok-please/
 * @author ankurkap
 *
 */

public class HornOk
{
    public static void main(String[] args) 
    {
        final InputReader in = new InputReader( System.in );
        final PrintWriter out = new PrintWriter( System.out, true );
        
        int T = in.nextInt();
        
        
        for( int i =0; i < T; i++ )
        {
            int N = in.nextInt();
            
            int S = 0;
            
            for( int j=1; j <= N; j++)
            {
                if( gcd( j, N ) == j )
                {
                    S += j ;
                }
            }
            
            if( S == 2*N )
            {
                out.println( "YES" );
            }
            else
            {
                out.println( "NO" );
            }
        }
        
        
        //out.println( count );
        
        out.close();
        System.exit( 0 );
    }
    
    private static int gcd(int u, int v) 
    {
        int shift;
        if (u == 0) return v;
        if (v == 0) return u;
       
        for (shift = 0; ((u | v) & 1) == 0; ++shift) {
               u >>= 1;
               v >>= 1;
        }
       
        while ((u & 1) == 0)
          u >>= 1;
       
        do {
             while ((v & 1) == 0)  
                 v >>= 1;

             if (u > v) 
             {
               int t = v; 
               v = u; 
               u = t;
             } 
             
             v = v - u;                       
           } while (v != 0);

        return u << shift;
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
