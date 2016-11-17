package com.multithread;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CountingWords
{
    public static void main( String[] args )
    {
        final Scanner in = new Scanner( System.in );
        
        final String target = in.nextLine();
        final StringBuilder bigSentence = new StringBuilder();
        String sentence = in.nextLine();
        
        while( !sentence.equals( "STOPIT" ) )
        {
            bigSentence.append( sentence );
            sentence = in.nextLine();
        }
        
        final String paragraph = bigSentence.toString();
        int N = bigSentence.length();
        
        int T = 1;
        
        int chunks = N/T;
        
        final long start = System.currentTimeMillis();
        final ExecutorService executor = Executors.newFixedThreadPool( T );
        
        final List<Future<Integer>> futureCounts = new ArrayList<>();
        int k =0;
        for( int i =0; i < N; i +=chunks )
        {
            final String sub;
            if( i >= N-chunks)
            {
                sub = paragraph.substring( i );
            }
            else
            {
                sub = paragraph.substring( i, i+chunks );
            }
            
            futureCounts.add( executor.submit( new WordCounter( sub, target ) ));
        }
        
        executor.shutdown();
        
        int cnt=0;
        for( final Future<Integer> f : futureCounts )
        {
            try
            {
                cnt += f.get();
            }
            catch ( InterruptedException e )
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            catch ( ExecutionException e )
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        
        System.out.println( cnt );
        
        final long end = System.currentTimeMillis();
        
        System.out.println( "Total time for the operation = " + (end-start) + "ms");
        in.close();
    }
  
    static class WordCounter implements Callable<Integer>
    {
        final String m_sentence;
        final String m_target;
        public WordCounter( final String sentence, final String target )
        {
            m_sentence = sentence;
            m_target = target;
        }
        
        @Override
        public Integer call() throws Exception
        {
            int cnt = 0;
            final String[] strArr = m_sentence.split( " " );
            
            for( String s : strArr )
            {
                if( s.equals( m_target ))
                {
                    cnt++;
                }
            }
            
            return cnt;
        }
        
    }
}
