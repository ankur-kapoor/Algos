package com.hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 *https://www.hackerearth.com/thoughtworks-application-developer-hiring-challenge/algorithm/vanya-and-gcd-array/
 * @author ankurkap
 *
 */

public class VanyaGCD
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
        
        int[][] gcdMap = new int[101][101];
        int[] res = new int[1];
        
        for( int i =0; i < N; i++ )
        {
            solve( a, i, gcdMap, new ArrayList<Integer>(), res );
        }
        
        
        out.println( res[0] );
        
        out.close();
        System.exit( 0 );
    }
    
    private static void solve( int[] a, int st, int[][] gcdMap, List<Integer> path, int[] res )
    {
        int prev = -1;
        
        boolean oneGcd = true;
        for( int p : path )
        {
            if( prev > 0 )
            {
                int gcdP = gcdMap[p][prev]!=0 ? gcdMap[p][prev] : gcd( p, prev );
                
                gcdMap[p][prev] = gcdP;
                gcdMap[prev][p] = gcdP;
                prev = gcdP;
                
                if( gcdP != 1 )
                {
                    oneGcd = false;
                    break;
                }
            }
            else
            {
                if( p != 1)
                {
                    oneGcd = false;
                }
                prev = p; 
            }
        }
        
        if( oneGcd && !path.isEmpty())
        {
            res[0] = (res[0]+1)%1000000007;
        }
        
        if( st == a.length) return;
        
        int t = !path.isEmpty() ? path.get( path.size()-1 ) : 0;
        
        for( int i = st; i < a.length; i++ )
        {
            if( path.isEmpty() || a[st] >= t )
            {
                path.add( a[i] );
                solve( a, st+1, gcdMap, path, res );
                path.remove( path.size()-1 );
                t = a[i];
            }
        }
    }
    
    private static int gcd(int a, int b )
    {
        if( a == b ) return a;
        
        while( a > 0 && b > 0 )
        {
            if( a > b )
            {
                a = a-b;
            }
            else
            {
                b = b-a;
            }
        }
        
        return a != 0 ? a : b;
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
