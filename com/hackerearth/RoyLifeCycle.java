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

public class RoyLifeCycle
{
    public static void main(String[] args) 
    {
        final InputReader in = new InputReader( System.in );
        final PrintWriter out = new PrintWriter( System.out, true );
        
        int N = in.nextInt();
        
        int maxDay = 0;
        int prevDay = 0;
        int maxOverall =0;
        boolean updateMaxOverAll = false;
        for( int i = 0; i < N; i++ )
        {
            String s = in.next();
            char[] chArr = s.toCharArray();
            
            int cnt = 0;
            for( int j =0; j < chArr.length; j++ )
            {
                if( chArr[j] == 'C')
                {
                    cnt++;
                }
                else
                {
                    if( updateMaxOverAll )
                    {
                        maxOverall = Math.max( maxOverall, prevDay + cnt);
                        updateMaxOverAll = false;
                    }
                    cnt = 0;
                }
                
                maxDay = Math.max( maxDay, cnt );
            }
            
            if( updateMaxOverAll )
            {
                prevDay += cnt;
            }
            else
            {
                prevDay = cnt;
            }
            updateMaxOverAll = cnt != 0;
            maxOverall = Math.max( maxOverall, prevDay );
        }
        
        maxOverall = Math.max( maxOverall, maxDay );
        out.println( maxDay + " " + maxOverall );
        
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
