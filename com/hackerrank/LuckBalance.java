package com.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 *https://www.hackerrank.com/contests/w21/challenges/luck-balance
 * @author ankurkap
 *
 */

public class LuckBalance
{
    
    public static void main(String[] args) 
    {
        final InputReader in = new InputReader( System.in );
        final PrintWriter out = new PrintWriter( System.out, true );
        
        int N = in.nextInt();
        int K = in.nextInt();
        
        final List<Integer> a1 = new ArrayList<>();
        final List<Integer> a0 = new ArrayList<>();

        int sum = 0;
        for( int i =0; i < N; i++ )
        {
            int Li = in.nextInt();
            int Ti = in.nextInt();
            
            if( Ti == 0 )
            {
                a0.add( Li );
            }
            else
            {
                a1.add( Li );
            }
            
            sum += Li;
        }
        
        if( K < a1.size() )
        {
            Collections.sort( a1 );
            
            for( int i =0; i < a1.size()-K; i++ )
            {
                sum -= 2*a1.get( i );
            }
        }
        
        System.out.println(sum);
        
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
