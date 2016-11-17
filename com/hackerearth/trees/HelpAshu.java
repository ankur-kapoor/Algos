package com.hackerearth.trees;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;


/**
 * https://www.hackerearth.com/problem/algorithm/help-ashu-1/
 * @author ankurkap
 *
 */

public class HelpAshu
{
    public static void main( String[] args )
    {
        final InputReader in = new InputReader( System.in );
        final PrintWriter out = new PrintWriter( System.out, true );
        
        int N = in.nextInt();
        
        int[] a = new int[N];
        
        for( int i =0; i < N; i++ )
        {
            a[i] = in.nextInt();
        }
        
        int[] evenSegTree = getSegmentTree( a, true );
        int[] oddSegTree = getSegmentTree( a, false );
        
        int[] evenLazy = new int[evenSegTree.length];
        int[] oddLazy = new int[evenSegTree.length];
        
        int Q = in.nextInt();
        
        for( int i =0; i < Q; i++ )
        {
            int q = in.nextInt();
            
            if( q == 0)
            {
                int index = in.nextInt()-1;
                int val = in.nextInt();
                updateQuery( a, evenSegTree, evenLazy, oddSegTree, oddLazy, index, val, 0, N-1, 0 );
            }
            else
            {
                int l = in.nextInt()-1;
                int r = in.nextInt()-1;
                if( q == 1)
                {
                    out.println( query( evenSegTree, evenLazy, 0, N-1, l, r, 0 ));
                }
                else
                {
                    out.println( query( oddSegTree, oddLazy, 0, N-1, l, r, 0 ) );    
                }
            }
        }
        
        out.close();
        System.exit( 0 );
    }
    
    private static void updateQuery( final int[] a, final int[] evenSegTree, final int[] evenLazy,
        final int[] oddSegTree, final int[] oddLazy, int index, int newVal, int low, int high, int pos )
    {
        
        if( oddLazy[pos] != 0 )
        {
            oddSegTree[pos] += oddLazy[pos];
            
            if( low != high )
            {
                oddLazy[2*pos+1] = oddLazy[pos];
                oddLazy[2*pos+2] = oddLazy[pos];
            }
            
            oddLazy[pos] = 0;
        }
        
        if( evenLazy[pos] != 0 )
        {
            evenSegTree[pos] += evenLazy[pos];
            
            if( low != high )
            {
                evenLazy[2*pos+1] = evenLazy[pos];
                evenLazy[2*pos+2] = evenLazy[pos];
            }
            
            evenLazy[pos] = 0;
        }
        
        if ( low > high || low > index || high < index )
        {
            return ;
        }
        
        if( low >= index && high <= index )
        {
            if( newVal %2 == 0 )
            {
                if( a[index] % 2 != 0 )
                {
                    // update the even segtree with newVal
                    
                    evenSegTree[pos] += 1;
                    
                    if( low != high )
                    {
                        evenLazy[2*pos+1] += 1;
                        evenLazy[2*pos+2] += 1;
                    }
                    
                    // update the odd segTree with -a[index];
                    
                    oddSegTree[pos] -= 1;
                    
                    if( low != high )
                    {
                        oddLazy[2*pos+1] -= 1;
                        oddLazy[2*pos+2] -= 1;
                    }
                }
                
            }
            else
            {
                if( a[index]%2 == 0 )
                {
                    // update the even segtree with -a[index]
                    evenSegTree[pos] -= 1;
                    
                    if( low != high )
                    {
                        evenLazy[2*pos+1] -= 1;
                        evenLazy[2*pos+2] -= 1;
                    }
                    // update the odd segtree with newVal
                    
                    oddSegTree[pos] += 1;
                    if( low != high )
                    {
                        oddLazy[2*pos+1] += 1;
                        oddLazy[2*pos+2] += 1;
                    }
                }
             }
            
            a[index] = newVal;
            
            return;
        }
        
        int mid = low + (high-low)/2;
        
        updateQuery( a, evenSegTree, evenLazy, oddSegTree, oddLazy, index, newVal, low, mid, 2*pos+1 );
        updateQuery( a, evenSegTree, evenLazy, oddSegTree, oddLazy, index, newVal, mid+1, high, 2*pos+2 );
        
        evenSegTree[pos] = evenSegTree[2*pos+1] + evenSegTree[2*pos+2];
        oddSegTree[pos] = oddSegTree[2*pos+1] + oddSegTree[2*pos+2];
        
    }
    
    private static int query( final int[] segTree, final int[] lazy, int low, int high, int l, int r, int pos )
    {
        if ( low > high || low > r || high < l )
        {
            return 0;
        }

        if ( lazy[pos] != 0 )
        {
            segTree[pos] += lazy[pos];

            if ( low != high )
            {
                lazy[2 * pos + 1] += lazy[pos];
                lazy[2 * pos + 2] += lazy[pos];
            }

            lazy[pos] = 0;
        }

        if ( low >= l && high <= r ) // total overlap
        {
            return segTree[pos];
        }

        int mid = low + ( high - low ) / 2;

        return query( segTree, lazy, low, mid, l, r, 2 * pos + 1 )
            + query( segTree, lazy, mid + 1, high, l, r, 2 * pos + 2 );
    }
    
    private static int[] getSegmentTree( final int[] a, boolean isEven )
    {
        int n = getSegmentTreeLength( a.length );
        final int[] segTree = new int[n];
        
        buildSegmentTree( segTree, a, 0, a.length-1, 0, isEven );
        
        return segTree;
    }
    
    private static void buildSegmentTree( final int[] segTree, final int[]a, int low, int high, int pos, boolean isEven )
    {
        if( low == high )
        {
            if( (isEven && a[low]%2 == 0) || (!isEven && a[low]%2 != 0) )
            {
                segTree[pos] = 1;
            }
            
            return;
        }
        
        int mid = low + (high-low)/2;
        
        buildSegmentTree( segTree, a, low, mid, 2*pos+1, isEven );
        buildSegmentTree( segTree, a, mid+1, high, 2*pos+2, isEven );
        
        segTree[pos] = segTree[2*pos+1] + segTree[2*pos+2];
    }
    
    private static int getSegmentTreeLength( int n )
    {
        int x = (int) (Math.ceil(Math.log(n) / Math.log(2)));
        
        //Maximum size of segment tree
        int max_size = 2 * (int) Math.pow(2, x) - 1;
        
        return max_size;
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
