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

public class WierdChemist
{
    public static void main(String[] args) 
    {
        final InputReader in = new InputReader( System.in );
        final PrintWriter out = new PrintWriter( System.out, true );
        
        int N = in.nextInt();
        int M = in.nextInt();
        
        
        int[] a = new int[N];
        for( int i =0; i < N; i++ )
        {
            a[i] = in.nextInt();
        }
        
        int[] segTree = buildSegmentTree( a );
        
        int count =0;
        
        for( int i =0; i < M; i++ )
        {
            int li = in.nextInt();
            int ri = in.nextInt();
            int xi = in.nextInt();
            
            int qSum = getSumQuery( 0, N-1, li-1, ri-1, 0, segTree );
            
            if( qSum >= xi )
            {
                count++;
            }
        }
        
        out.println( count );
        
        out.close();
        System.exit( 0 );
    }
    
    
    private static int[] buildSegmentTree( int[] a )
    {
        int n = a.length;
        int sN = getSegmentTreeLength( n );
        
        int[] segTree = new int[sN];
        
        buildSumTree( a, segTree, 0, n-1, 0 );
        return segTree;
    }
    
    private static void buildSumTree( int[] a, int[] segTree, int low, int high, int pos )
    {
        if( low == high )
        {
            segTree[pos] = a[low];
            return;
        }
        
        int mid = low + ( high-low)/2;
        
        buildSumTree( a, segTree, low, mid, 2*pos+1 );
        buildSumTree( a, segTree, mid+1, high, 2*pos+2 );
        
        segTree[pos] = segTree[2*pos+1] + segTree[2*pos+2]; 
    }
   
    private static int getSegmentTreeLength( int n )
    {
        int x = (int) (Math.ceil(Math.log(n) / Math.log(2)));
        
        //Maximum size of segment tree
        int max_size = 2 * (int) Math.pow(2, x) - 1;
        
        return max_size;
    }
    
    private static int getSumQuery(int ss, int se, int qs, int qe, int si, int[] segTree)
    {
        // If segment of this node is a part of given range, then return
        // the sum of the segment
        if (qs <= ss && qe >= se)
        {
            return segTree[si];
        }
 
        // If segment of this node is outside the given range
        if (se < qs || ss > qe)
            return 0;
 
        // If a part of this segment overlaps with the given range
        int mid = ss + (se-ss)/2;
        
        return getSumQuery(ss, mid, qs, qe, 2 * si + 1, segTree) +
                        getSumQuery(mid + 1, se, qs, qe, 2 * si + 2, segTree);
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
