package com.topcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Problem Statement
Hero has just constructed a very specific graph. He started with n isolated vertices, labeled 0 through n-1. For each vertex i Hero then chose a vertex a[i] (other than i) and he added an edge that connected i and a[i]. This way he created a graph with n vertices and n edges. Note that if a[x]=y and a[y]=x, the vertices x and y were connected by two different edges. Hero now wants to perform the following procedure:
Add a new isolated vertex number n.
Choose a subset M of the original vertices.
For each x in M, erase an edge between vertices x and a[x].
For each x in M, add a new edge between vertices x and n.
Hero's goal is to create a final graph in which the vertices 0 through n-1 are all in the same connected component. (I.e., there must be a way to reach any of these vertices from any other of them by following one or more consecutive edges, possibly visiting vertex n along the way.) Note that Hero does not care whether vertex n is in the same component as the other vertices: both possibilities are fine. In step 2 of the above procedure Hero has 2^n possible subsets to choose from. A choice of M is good if it produces a graph with the desired property. Count how many of the 2^n possibilities are good choices. Return that count as a .
Definition
Class: Sunnygraphs2
Method: count
Parameters: vector <int>
Returns: long long
Method signature: long long count(vector <int> a)
(be sure your method is public)
Limits
Time limit (s): 2.000
Memory limit (MB): 256
Constraints
- a will contain n elements.
- n will be between 2 and 50, inclusive.
- Each element in a will be between 0 and n - 1, inclusive.
- For each i between 0 and n - 1 holds a[i] != i.
Examples
0)
{1,0}
Returns: 4
The original graph contained the vertices 0 and 1. This pair of vertices was connected by two edges. Next, Hero added a new vertex 2. Then he had to choose one of four possible subsets M:
If he chose M = {}, the resulting graph contained the edges 0-1 and 0-1. The vertices 0 and 1 were in the same component.
If he chose M = {0}, the resulting graph contained the edges 0-1 and 0-2. The vertices 0 and 1 were in the same component.
If he chose M = {1}, the resulting graph contained the edges 0-1 and 1-2. The vertices 0 and 1 were in the same component.
Finally, if he chose M = {0, 1}, the resulting graph contained the edges 0-2 and 1-2. And again, the vertices 0 and 1 were in the same component. (In the resulting graph we can still go from vertex 0 to vertex 1, even though we have to go via vertex 2.)
As all four choices of M are good, the correct answer is 4.
1)
{1,0,0}
Returns: 7
Here, M = {2} is not a good choice. This choice produces a graph with edges 0-1, 0-1, and 2-3. In this graph vertex 2 is not in the same component as vertices 0 and 1. The other seven possible choices of M are all good.
2)
{2,3,0,1}
Returns: 9
3)
{2,3,0,1,0}
Returns: 18
4)
{2,3,0,1,0,4,5,2,3}
Returns: 288
5)
{29,34,40,17,16,12,0,40,20,35,5,13,27,7,29,13,14,39,42,9,30,38,27,40,34,33,42,20,29,42,12,29,30,21,4,5,7,25,24,17,39,32,9}
Returns: 6184752906240
"Watch out for integer overflow."
6)
{9,2,0,43,12,14,39,25,24,3,16,17,22,0,6,21,18,29,34,35,23,43,28,28,20,11,5,12,31,24,8,13,17,10,15,9,15,26,4,13,21,27,36,39}
Returns: 17317308137473
 * @author ankurkap
 *
 */
public class Sunnygraphs3
{
    public long count( int[] a )
    {
        int N = a.length;
        final List<Edge>[] edges = new List[N];
        
        long oneMasked = 1L;
        long visitedMask = 0L;
        for( int i =0; i < N; i++ )
        {
           final List<Edge> edgeV = null != edges[i] ? edges[i] : new ArrayList<Edge>();
           edges[i] = edgeV;
           edgeV.add( new Edge( i, a[i]) );

           final List<Edge> edgeU = null != edges[a[i]] ? edges[a[i]] : new ArrayList<Edge>();
           edges[a[i]] = edgeU;
           edgeU.add( new Edge(a[i], i) );
           
           visitedMask |=  (oneMasked << i | oneMasked<< a[i]);
           
        }
        
        long res=0;
        for( long i =0; i < 1L<<N; i++)
        {
            final List<Integer> b = new ArrayList<>();
            for( int j =0; j < N; j++)
            {
                if( (i &(1<<j))!= 0 )
                {
                    b.add( j );
                }
            }
            
            final long newVisitedMask = reconstructGraph( edges, b, a, N, visitedMask );
            
            if( newVisitedMask == ((oneMasked<<N) -1))
            {
                res++;
            }
        }
        
        return res;
    }
    
    private long reconstructGraph( final List<Edge>[] edges, final List<Integer> b, final int[]a, final int N, long visitedMask )
    {
        for( int i =0; i < b.size(); i++ )
        {
            int k = b.get( i );
            int u = a[k];
            visitedMask = visitedMask^u;
        }
        
        for( int i =0; i < b.size(); i++ )
        {
            int k = b.get( i );
            visitedMask |= k;
        }
        
        return visitedMask;
    }
    
    public static void main( String[] args )
    {
        final Sunnygraphs3 graph = new Sunnygraphs3();
        
       // final int[] a = {9,2,0,43,12,14,39,25,24,3,16,17,22,0,6,21,18,29,34,35,23,43,28,28,20,11,5,12,31,24,8,13,17,10,15,9,15,26,4,13,21,27,36,39};
        
        final int[] a = {2,3,0,1};
        System.out.println( graph.count( a ) );
    }
    
    class Edge
    {
        int v;
        int u;
        
        Edge( int _u, int _v )
        {
            this.v = _v;
            this.u = _u;
        }
        
        @Override
        public boolean equals( Object o )
        {
            final Edge e = (Edge)o;
            return (e.v == this.v && e.u == this.u);
        }
        
        @Override
        public String toString()
        {
            return (this.u + "->" + this.v );
        }
    }
}
