package com.hackerearth;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 *https://www.hackerearth.com/quintype-backend-hiring-challenge/problems/0748006174ea457eb1dd36fcb1765e60/ * @author ankurkap
 *
 */

public class TaxiPlease
{
    
    public static void main(String[] args) 
    {
        final Scanner in = new Scanner(System.in);
        final PrintWriter out = new PrintWriter( System.out );
        int N = in.nextInt();
        int M = in.nextInt();
        int T = 1;
        
        Schedule[] schedules = new Schedule[N];
        for( int i =0; i < N; i++ )
        {
            long Si = in.nextLong();
            long Ji = in.nextLong();
            schedules[i] = new Schedule( Si, Ji, i );
        }
        
        Arrays.sort( schedules );
        
        final PriorityQueue<Node> pq = new PriorityQueue<>();
        final int[] res = new int[N]; 
        for( int i=0; i < N ; i++ )
        {
            final Schedule schedule = schedules[i];
            
            if( pq.isEmpty() )
            {
                if( M > 0 )
                {
                    M--;
                    pq.add( new Node( schedule, T ) );
                    //System.out.print( T+" " );
                    res[schedule.index] = T;
                    T++;
                }
                else
                {
                    //System.out.print( -1+" " );
                    res[schedule.index] = -1;
                }
            }
            else
            {
                final Node node = pq.peek();
                
                if( schedule.Si >= (node.sch.Ji + node.sch.Si) )
                {
                    pq.poll();
                    res[schedule.index] = node.Ti;
                    pq.add( new Node( schedule, node.Ti ) );
                }
                else
                {
                    if( M > 0 )
                    {
                        M--;
                        pq.add( new Node( schedule, T ) );
                        res[schedule.index] = T;
                        T++;
                    }
                    else
                    {
                        res[schedule.index] = -1;
                    }
                }
            }
        }
        final StringBuilder result = new StringBuilder();
        for( int i =0; i < N; i++ )
        {
            result.append( res[i] ).append( " " );
        }
        
       // System.out.println( "Result Length = " + result.length());
        out.print( result.toString() );
        
        in.close();
        out.close();
        //System.out.println(cnt) ;
    }
    
    static class Node implements Comparable<Node>
    {
        final Schedule sch;
        Integer Ti;
        Node( final Schedule s, final int T )
        {
            sch = s;
            Ti = T;
        }
        
        @Override
        public int compareTo( Node o )
        {
            long thisT = this.sch.Si+ this.sch.Ji;
            long oT = o.sch.Si + o.sch.Ji;
            
            if( thisT < oT ) return -1;
            else if( thisT > oT ) return 1;
            else 
            {
               return this.Ti.compareTo( o.Ti ); 
            }
        }
        
    }
    
    static class Schedule implements Comparable<Schedule>
    {
        Long Si;
        Long Ji;
        Integer index;
        
        Schedule( long s, long j, int i )
        {
            Si = s;
            Ji = j;
            index = i;
        }

        @Override
        public int compareTo( Schedule o )
        {
            return this.Si.compareTo( o.Si );
        }
        
        @Override
        public String toString()
        {
            return this.Si + "-" +( this.Si + this.Ji);
        }
    }
}
