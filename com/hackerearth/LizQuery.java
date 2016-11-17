package com.hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 *https://www.hackerearth.com/IITK-WPC-Summer16/algorithm/lizzys-queries/
 * @author ankurkap
 *
 */

public class LizQuery
{
    public static void main(String[] args) 
    {
        final InputReader in = new InputReader( System.in );
        final PrintWriter out = new PrintWriter( System.out, true );
        
        int N = in.nextInt();
        int Q = in.nextInt();
        
        String S = in.next();
        char[] strArr = S.toCharArray();
        for( int j=0; j < Q; j++)
        {
            int O = in.nextInt();
            if( O == 0)
            {
                int li = in.nextInt();
                char xi = in.next().toCharArray()[0];
                strArr[li-1] = xi;
            }
            else
            {
                int li = in.nextInt();
                int ri = in.nextInt();
                
                String S_ = new String( strArr);
                
                String sub = S_.substring( li-1, ri );
                
                if( isPalindrome( sub ))
                {
                    System.out.println("Yes");
                }
                else
                {
                    System.out.println("No");
                }
            }
        }
        
        //out.println( count );
        out.close();
        System.exit( 0 );
    }
    
    private static boolean isPalindrome( String s )
    {
        if( s.length() == 1) return true;
        
        int l = 0;
        int r = s.length()-1;
        
        char[] arr = s.toCharArray();
        while( l < r )
        {
            if( arr[l++] != arr[r--])
            {
                return false;
            }
        }
        
        return true;
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
