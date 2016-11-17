package com.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * https://www.hackerrank.com/contests/world-codesprint-april/challenges/beautiful-triplets
 * @author ankurkap
 *
 */

public class BeautifulTriplets
{
    
    public static void main(String[] args) 
    {
        final InputReader in = new InputReader( System.in );
        final PrintWriter out = new PrintWriter( System.out, true );
        
        int n = in.nextInt();
        int d = in.nextInt();
        
        int[] a = new int[n];
        
        int cnt = 0;
        int lastI =0;
        List<Pair> pairs = new ArrayList<>();
        for( int i=0; i< n; i++)
        {
            a[i] = in.nextInt();
            
            int k = lastI;
            for( ; k < i; k++ )
            {
                if( a[i] == a[k]+d )
                {
                    lastI = k;
                    final Pair p = new Pair(a[k], a[i]);
                    
                    Pair oldP = null;
                    for( final Pair pair : pairs )
                    {
                        if( pair.equals( p ))
                        {
                            oldP = pair;
                            break;
                        }
                    }
                    if( oldP != null )
                    {
                        pairs.remove( oldP );
                        cnt++;
                    }
                    pairs.add( p );
                }
            }
        }
       
        out.println( cnt );
        
        out.close();
        System.exit( 0 );
    }
    
    static class Pair
    {
        int x;
        int y;
        
        Pair( int _x, int _y)
        {
            x = _x;
            y = _y;
        }
        
        @Override
        public boolean equals( Object o )
        {
            final Pair p = (Pair)o;
            
            return this.y == p.x;
        }
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
