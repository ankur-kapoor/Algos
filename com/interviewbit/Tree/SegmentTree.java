package com.interviewbit.Tree;

/**
 * An API to create Segment Tree using Arrays, performs operations : 
 *  - Range Query 
 * 
 *  Tree representation in an array
 *  Root i = 0
 *  For Node i - Left Child  = 2*i + 1
 *  For Node i - Right Child = 2*i + 2
 *  Parent of Node i = (i-1)/2
 *   
 * @author ankurkap
 *
 */

public class SegmentTree
{
    private final int[] m_segmentTree;
    private int m_high;
    
    public SegmentTree( final int[] a )
    {
        int n = a.length;
        m_high = n-1;
        int m = getNextPower( n );  
        m_segmentTree =  new int[m];
        
        for( int i = 0; i < m; i++ )
        {
            m_segmentTree[i] = Integer.MAX_VALUE;
        }
        
        buildTree( a, 0, n-1, 0 );
    }
    
    private int getNextPower( int b )
    {
        int c  = 0;
        
        int d = b;
        while( b > 1 )
        {
            b >>= 1;
            c++;
        }
        
        int f = (int)Math.pow( 2, c );
        
        return f ==d ? ( 2*d - 1):(2*(int)Math.pow( 2, c+1 ) -1);
    }
    
    private void buildTree( final int[]a, int low, int high, int pos )
    {
        if( low == high )
        {
            m_segmentTree[pos] = a[low];
            return;
        }
        
        int mid = low + (high - low)/2;
        
        buildTree( a, low, mid, 2*pos+1 );
        buildTree( a, mid+1, high, 2*pos+2 );
        
        m_segmentTree[pos] = Math.min( m_segmentTree[2*pos+1], m_segmentTree[2*pos+2] );
        
    }
    
    public int[] getSegmentTree()
    {
        return m_segmentTree;
    }
    
    /**
     * We need to evaluate 3 basic conditions over here: 
     * 1. If there is total overlap - return the node's value
     * 2. If there is no overlap - return the Max value
     * 3. If there is a partial overlap - Search the min value in both the left and right children
     * 
     * @param qLow
     * @param qHigh
     * @return
     */
    public int getMinBetween( int qLow, int qHigh )
    {
        return getMinQuery( qLow, qHigh, 0, m_high, 0 );
    }
    
    private int getMinQuery( int qLow, int qHigh, int low, int high, int pos )
    {
        if ( qLow <= low && qHigh >= high ) // Total Overlap condition
        {
            return m_segmentTree[pos];
        }

        if ( qLow > high || qHigh < low ) // No overlap
        {
            return Integer.MAX_VALUE;
        }

        int mid = low + ( high - low ) / 2;

        return Math.min( getMinQuery( qLow, qHigh, low, mid, 2 * pos + 1 ),
                         getMinQuery( qLow, qHigh, mid + 1, high, 2 * pos + 2 ) );

    }
    
    public String toString()
    {
        final StringBuilder st = new StringBuilder();
        
        st.append( "[" );
        st.append( m_segmentTree[0] );
        for( int i =1; i < m_segmentTree.length; i++ )
        {
            st.append( ", " );
            st.append( m_segmentTree[i] );
        }
        
        st.append( "]" );
        
        return st.toString();
    }
    
    public static void main( String[] args )
    {
        int nums[] = {-1,2,4,0,7};
        final SegmentTree st = new SegmentTree( nums );
        
        System.out.println( "Segment Tree = " + st );
        
        System.out.println( "Min Value = " + st.getMinBetween( 1, 2 ) );
        
    }
}
