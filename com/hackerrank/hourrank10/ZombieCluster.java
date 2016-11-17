package com.hackerrank.hourrank10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * https://www.hackerrank.com/contests/world-codesprint-april/challenges/jumping-on-the-clouds
 * @author ankurkap
 *
 */

public class ZombieCluster
{
    
    public static void main(String[] args) 
    {
        final InputReader in = new InputReader( System.in );
        final PrintWriter out = new PrintWriter( System.out, true );
        
        int n = in.nextInt();
        
        String[] a = new String[n];
        
        for( int i=0; i< n; i++)
        {
            a[i] = in.next();
        }
        
        System.out.println( zombieCluster( a ));
        
        out.close();
        System.exit( 0 );
    }
    
    static int zombieCluster(String[] zombies) 
    {
        boolean[][] visited = new boolean[zombies.length][zombies[0].length()];
        
        int cnt = 0;
        for( int i =0; i < zombies.length; i++ )
        {
            if( dfs( zombies, i, visited ))
            {
                cnt++ ;
            }
        }
        
        return cnt;
    }

    
    private static boolean dfs( String[] a, int i, boolean[][] visited )
    {
        char[] arr = a[i].toCharArray();
        boolean visit = false;
        for( int j =0; j < a.length; j++ )
        {
            if( !visited[i][j] && arr[j] == '1' )
            {
                visit = true;
                visited[i][j] = true;
                dfs( a, j, visited );
            }
        }
        
        return visit;
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
