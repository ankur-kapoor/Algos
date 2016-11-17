package com.hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

/**
 *https://www.hackerearth.com/nuvizz-java-hiring-challenge/problems/50f6f02df33e4690b9bb82c062958875/
 * @author ankurkap
 *
 */

public class MicroPrimePrime
{
    public static void main(String[] args) 
    {
        final InputReader in = new InputReader( System.in );
        final PrintWriter out = new PrintWriter( System.out, true );
        
        int T = in.nextInt();
        int[] arr = new int[1000001];
        int[] primeNum = new int[1000001];
        primeNum[2] = 1;
        primeNum[3] = 2;
        boolean[] isPrime = new boolean[1000001];
        
        isPrime[2] = true;
        isPrime[3] = true;
        
        arr[3] = 1;
        int lastRight = prePopulateData( arr, primeNum, isPrime, 4, 100001);
        
        for( int i =0; i < T; i++ )
        {
            int L = in.nextInt();
            int R = in.nextInt();
            
            if( R < lastRight )
            {
                out.println( arr[R] - arr[L-1]);
            }
            else
            {
                lastRight = prePopulateData( arr, primeNum, isPrime, lastRight, R+100 );
                out.println( arr[R] - arr[L-1]);
            }
            
        }
        
        out.close();
        System.exit( 0 );
    }

    private static int prePopulateData( int[] arr, int[] primeNum, boolean[] isPrime, int left, int right  )
    {
        for( int i=left; i < right; i++ )
        {
            BigInteger bi = new BigInteger( i+"" );
            if( isPrime[i] || bi.isProbablePrime( 4 ) )
            {
                isPrime[i] = true;
                primeNum[i] = primeNum[i-1]+1;
            }
            else
            {
                primeNum[i] = primeNum[i-1];
            }
            
            bi = new BigInteger( primeNum[i]+"" );
            if( isPrime[primeNum[i]] || bi.isProbablePrime( 4 ))
            {
                isPrime[primeNum[i]] = true;
                arr[i] = arr[i-1]+1;
            }
            else
            {
                arr[i] = arr[i-1];
            }
        }
        
        return right;
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
