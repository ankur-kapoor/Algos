package com.hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 *https://www.hackerearth.com/IITK-WPC-Summer16/algorithm/inverted-gcd/
 * @author ankurkap
 *
 */

public class InvertedGcd
{
    public static void main(String[] args) 
    {
        final InputReader in = new InputReader( System.in );
        final PrintWriter out = new PrintWriter( System.out, true );
        
        int N = in.nextInt();
        
        int[] a = new int[N];
        for( int i =0; i < N ; i++ )
        {
            a[i] = in.nextInt();
        }

        int d = 0;
        int cnt =0;
        
        final Set<Pair> set = new HashSet<>();
        while( d <= N/2)
        {
            int i = 0;
            int j = N-1;
            
            while( i < j )
            {
                Pair p = new Pair( i+d+1, j-d+1);
                if( i+d < j-d && a[i+d] > a[j-d] && set.add(p) && gcd( a[i+d], a[j-d] ) == 1)
                {
                    cnt++;
                }
                
                p = new Pair( i+1, j-d+1);
                if( i < j-d && a[i] > a[j-d] && gcd( a[i], a[j-d] ) == 1)
                {
                    if( set.add(p))
                    {
                        cnt++;
                    }
                }
                
                p = new Pair( i+d+1, j+1);
                if( i+d < j && a[i+d] > a[j] && gcd( a[i+d], a[j] ) == 1)
                {
                    if( set.add(p))
                    {
                        cnt++;
                    }
                }
                
                i++;
                j--;
            }
            
            d++;
        }
        
        out.println( cnt );
        out.close();
        System.exit( 0 );
    }
    
    private static int gcd( int a, int b)
    {
        if( a == b) return a;
        
        while( a > 0 && b > 0 )
        {
            if( a > b)
            {
                a = a-b;
            }
            else
            {
                b = b-a;
            }
        }
        
        return a!=0?a:b;
    }
    
    static class Pair 
    {
        Integer X;
        Integer Y;
        public Pair( int x, int y )
        {
            X = x;
            Y = y;
        }
        @Override
        public boolean equals( Object o )
        {
            final Pair p = (Pair)o;
            
            return (this.X == p.X && this.Y == p.Y);
        }
        
        public int hashCode()
        {
            return ( ((X%Y) * (Y%X))%(X+Y) );
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
