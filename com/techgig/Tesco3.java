package com.techgig;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Tesco3
{
    private static String GetSubString(String input1,String input2)
    {
        if( null == input2 || null == input1 ) return null;
        
        final int[] flag = new int[256];
        
        char[] wordArr = input2.toCharArray();
        
        final Map<Character, List<Integer>> charMap = new HashMap<Character, List<Integer>>();
        
        for( int i=0; i< wordArr.length; i++ )
        {
            char ch = wordArr[i];
            List<Integer> list = charMap.get( ch );
            
            if( null == list)
            {
                list = new ArrayList<Integer>();
            }
            
            list.add( i );
            
            charMap.put( ch, list );
            
            flag[ch]++;
        }
        
        char[] stringArr = input1.toCharArray();
        final int[] pos = new int[input2.length()];
        
        int len =0;
        int maxLen = Integer.MAX_VALUE;
        String resStr = null;
        final int[] counts = new int[256];
        
        for( int i =0; i < input1.length(); i++ )
        {
            char ch = stringArr[i];
            
            if( flag[ch] > 0  )
            {
                if( len < input2.length() && counts[ch] < flag[ch])
                {
                    counts[ch]++;
                    len++;
                }
                
                final List<Integer> list = charMap.get( ch );
                //pos[ch] = i;
                
                int minPosIndex = Integer.MAX_VALUE;
                int minIndex = Integer.MAX_VALUE;
                for( final int index : list )
                {
                    if( minPosIndex > pos[index])
                    {
                        minPosIndex = pos[index];
                        minIndex = index;
                    }
                }
                pos[minIndex] = i;
                
                if( len == input2.length())
                {
                    int minI=Integer.MAX_VALUE;
                    int maxI =Integer.MIN_VALUE;
                    for( int j =0; j < pos.length; j++ )
                    {
                        minI = Math.min( pos[j], minI );
                        maxI = Math.max( pos[j], maxI );
                    }
                    
                    if( maxLen > (maxI-minI))
                    {
                        resStr = input1.substring( minI, maxI+1 );
                        maxLen = maxI-minI;
                    }
                }
            }
        }
        
        return resStr;
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


    public static void main( String[] args )
    {
        final InputReader in = new InputReader( System.in );
        final PrintWriter out = new PrintWriter( System.out, true );
        
        final int T = in.nextInt();
       
        
        for( int i =0; i < T; i++ )
        {
            
        }
        
        //System.out.println(  tesco.GetSubString( input1, input2 ) );
        
        //System.out.println( tes.GetVisibleCount( N, m, input3 ));
    }
}
