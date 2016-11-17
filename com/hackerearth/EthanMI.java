package com.hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 *https://www.hackerearth.com/IITK-WPC-Summer16/algorithm/weird-chemists-3/
 * @author ankurkap
 *
 */

public class EthanMI
{
    public static void main(String[] args) 
    {
        final InputReader in = new InputReader( System.in );
        final PrintWriter out = new PrintWriter( System.out, true );
        
        int N = in.nextInt();
        int Q = in.nextInt();
        long M = in.nextInt()*1l;
        
        
        long[] a = new long[N];
        long product = 1l;
        int cnt = 1;
        int[] arr = new int[N];
        for( int i =0; i < N; i++ )
        {
            arr[i] = cnt;
            
            a[i] = in.nextInt()*1l;
            
            if( cnt * product * a[i] > M )cnt++;
            product = (product%M * a[i]%M)%M;
        }
        
        
        for( int i =0; i < Q; i++ )
        {
            int index = in.nextInt()-1;
            
            long ans = (((arr[index]*product)+M)/a[index])%M;
            out.println( ans );
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
