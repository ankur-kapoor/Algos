package com.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * https://www.hackerrank.com/contests/world-codesprint-april/challenges/jumping-on-the-clouds
 * @author ankurkap
 *
 */

public class VMWareDare
{
    
    public static void main(String[] args) 
    {
        final Scanner in = new Scanner( System.in );
        final PrintWriter out = new PrintWriter( System.out, true );
        
        int N = in.nextInt();
        in.nextLine();
        String[] strArr = new String[N];
        for( int i =0;i < N; i++ )
        {
            strArr[i] = in.nextLine();
        }
        
        printDomains( strArr );
        
        in.close();
        out.close();
        System.exit( 0 );
    }
    
    static int maxDifference( int[] a )
    {
        int n = a.length;
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int maxIndex = 0;
        int[] minValues = new int[n];
        for( int i=0; i< n; i++)
        {
            min = Math.min( min, a[i] );
            minValues[i] = min;
            
            if( max < a[i] )
            {
                maxIndex = i;
                max = a[i];
            }
        }
        
        if( maxIndex == 0 )
        {
            return -1;
        }
        else
        {
            return (max - minValues[maxIndex]);
        }
    }
    
    static void printDomains(String[] arr) 
    {
        final Set<String> listArr = new HashSet<>();
        for( int i =0; i < arr.length; i++ )
        {
            String s = arr[i];
            
            while( s.indexOf( "www." ) > 0 || s.indexOf( "web." ) > 0 )
            {
                int wwwt = s.indexOf( "www." );
                int wwwb = s.indexOf( "web." );
                
                if( wwwt > 0 && wwwb > 0 )
                {
                    if( wwwt < wwwb)
                    {
                        s = s.substring( wwwt + 4  );
                        if( s.indexOf( "/" ) > 0 )
                        {
                            String t = s.substring( 0, s.indexOf( "/" ) );
                            listArr.add( t );
                        }
                    }
                    else
                    {
                        s = s.substring( wwwb + 4  );
                        if( s.indexOf( "/" ) > 0 )
                        {
                            String t = s.substring( 0, s.indexOf( "/" ) );
                            listArr.add( t );
                        }
                    }
                }
                else if( wwwt > 0 )
                {
                    s = s.substring( wwwt + 4  );
                    if( s.indexOf( "/" ) > 0 )
                    {
                        String t = s.substring( 0, s.indexOf( "/" ) );
                        listArr.add( t );
                    }
                }
                else
                {
                    s = s.substring( wwwb + 4  );
                    if( s.indexOf( "/" ) > 0 )
                    {
                        String t = s.substring( 0, s.indexOf( "/" ) );
                        listArr.add( t );
                    }
                }
            }
        }
        
        final List<String> strArr = new ArrayList<>();
        
        strArr.addAll( listArr );
        
        Collections.sort( strArr );
        
        StringBuilder str = new StringBuilder();
        for( final String s : strArr )
        {
            str.append( s ).append( ";" );
        }
        
        System.out.println( str.toString().substring( 0, str.length()-1 ));

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
