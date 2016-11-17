package com.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * https://www.hackerrank.com/contests/world-codesprint-april/challenges/jumping-on-the-clouds
 * @author ankurkap
 *
 */

public class Braces
{
    
    public static void main(String[] args) 
    {

        System.out.println( evalBraces( "{[}]" ));
        
        divide( 4, 0 );
        
        System.exit( 0 );
    }
    
    static String[] braces(String[] values) 
    {
        final String[] res = new String[values.length];
        
        int i =0;
        for( String s : values )
        {
            res[i++] = evalBraces( s );
        }

        return res;
    }
    public static void divide(int a, int b) {
        try {
                int c = a / b;
        } catch (Exception e) {
                System.out.print("Exception ");
        } finally {
                System.out.println("Finally");
        }
}
    static String evalBraces( String s )
    {
        char[] sArr = s.toCharArray();
        
        final Stack<Character> charStack = new Stack<>(); 
        for( char ch : sArr )
        {
            if( ch == '{' || ch == '[' || ch == '(')
            {
                charStack.push( ch );
            }
            else
            {
                if( charStack.isEmpty() )
                {
                    return "NO";
                }
                else
                {
                    char c = charStack.pop();
                    
                    if( c == '{' && ch != '}' )
                    {
                        return "NO";
                    }
                    else if( c == '[' && ch != ']' )
                    {
                        return "NO";
                    }
                    else if( c == '(' && ch != ')' )
                    {
                        return "NO";
                    }
                }
            }
        }
        
        return "YES";
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
