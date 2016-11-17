package com.hackerearth;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;



/**
 *Write a program that prints the numbers in the given range. But for multiples of three print “Fizz” instead of the number and for the multiples of five print “Buzz”. For numbers which are multiples of both three and five print “FizzBuzz”. Print a new line after each string or number.

Input Format First line will be the number of testcases, T. Next line will have T integers, denoted by N.

Output Format For each testcase, print the number from 1 to N. But follow the rules given in the problem statement.

Constraints

1 <= T <= 10

N is an integer.Byteland consists of N houses numbered 1..N. The house i has K[i] members living in it. There are also M roads connecting some pairs of houses. The roads are all bidirectional and each road has a certain length. There is a candy shop located in house S.

The citizens of Byteland decide to send candies to each other's houses (not to their own of-course). The amount of candies sent by house u to house v should be K[v] (one for each member of house v). The owner of the candy shop, being a shrewd businessman, decides the following :

A delivery from u to v must necessarily pass through the candy shop, and it's cost will be the length of the shortest such path.
Each candy shall be delivered independently, so the delivery from u to v will cost K[v] times the length of the shortest path from u to v through the candy shop.
Input

The first line contains three integers N, M, and S.

The next line contains N integers, denoting the K[] values of the houses.

The next M lines contain three integers each: u, v, w, denoting that there is a road of length w connecting house u and v.

Output

Print N space separated integers in the same line, where the ith value is the total cost incurred by house i.

Constraints

1 <= N, M <= 100,000

0 <= w <= 100000

1 <= K[i] <= 100

1 <= u, v, S <= N

Note: There may be certain families who are unable to send candies to each other due to inadequate road connectivity. These incur 0 cost.

ref - https://www.hackerearth.com/april-easy-16/algorithm/delivering-candies-aprileasy/

 * @author ankurkap
 *
 */

public class DeliveringCandies
{
    static class SimpleGraph
    {
        final int V;
        final List<List<Node>> m_adjVertex;
        final boolean m_directed;
        
        SimpleGraph( int v, boolean isDirected )
        {
            V = v;
            m_adjVertex = new ArrayList<>();
            m_directed = isDirected;
            
            for( int i=0; i < V; i++ )
            {
                m_adjVertex.add( new ArrayList<Node>() );
            }
        }
        
        public void addEdge( int v, int u, int wt )
        {
            m_adjVertex.get( v-1 ).add( new Node( u-1, wt ) );
            
            if( !m_directed )
            {
                m_adjVertex.get( u-1 ).add( new Node( v-1, wt ) );
            }
        }
        
        class Node
        {
            int v;
            int wt;
            
            Node( int _v, int _wt )
            {
                v = _v;
                wt = _wt;
            }
        }
    }
    
    private static Integer[] bellmanFord( final SimpleGraph graph, int src )
    {
        int source = src -1;
        int V = graph.V;
        final Integer[] dist = new Integer[V];
        
        for( int i =0; i < V; i++ )
        {
            dist[i] = Integer.MAX_VALUE;
        }
        
        dist[source] = 0;
        
        for( int k = 1; k < V; k++)
        {
            for( int i = 0; i < V; i++)
            {
                for( SimpleGraph.Node node : graph.m_adjVertex.get( i ))
                {
                    int v = node.v;
                    int wt = node.wt;
                    
                    if( dist[i] != Integer.MAX_VALUE && dist[i]+ wt < dist[v] )
                    {
                        dist[v] = dist[i]+ wt;
                    }
                }
            }
        }
        
        return dist;
    }
    
    private static void solve( final SimpleGraph graph, int[] K, int S )
    {
        final Map<Integer, Integer[]> map = new LinkedHashMap<>();
        
        for( int i = 1; i <= graph.V; i++ )
        {
            map.put( i-1, bellmanFord( graph, i ) );
        }
         S -= 1;
         Integer[] Sm = map.get( S );
        for( Map.Entry<Integer, Integer[]> entry : map.entrySet() )
        {
            int v = entry.getKey();
            Integer[] C = entry.getValue();
            
            System.out.print( calculateCost( v, S, C, Sm, K ) + " " );
        }
    }
    
    private static int calculateCost( int v, int s, final Integer[] C, final Integer[] S, final int[] K )
    {
        int t = C[s];
        int sum =0;
        for( int i =0; i < C.length; i++ )
        {
            if( i != v && S[i] != Integer.MAX_VALUE  && t != Integer.MAX_VALUE )
            {
                int p = S[i] + t;
                
                p *= K[i];
                
                sum += p;
            }
        }
        
        return sum;
    }
    
    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        
        String[] st = str.split( " " );
        
        int N = Integer.parseInt( st[0] );
        int M = Integer.parseInt( st[1] );
        int S = Integer.parseInt( st[2] );
      
        str = in.nextLine();
        st = str.split( " " );
        
        int[] K = new int[N];
        
        for( int i =0; i < N; i++ )
        {
            K[i] = Integer.parseInt( st[i] );
        }
        
        final SimpleGraph graph = new SimpleGraph( N, false );
        
        for( int i =0;i < M; i++ )
        {
            str = in.nextLine();
            st = str.split( " " );
            int u = Integer.parseInt( st[0] );
            int v = Integer.parseInt( st[1] );
            int w = Integer.parseInt( st[2] );
            
            graph.addEdge( u, v, w );
        }
        
        solve( graph, K, S );
        
        in.close();
        //System.out.println(cnt) ;
    }
}
