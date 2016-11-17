package com.multithread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class OddEvenLock
{
    public static void main( String[] args )
    {
        final Logger logger = new Logger();
        final OddEvenGenerator oddGen = new OddEvenGenerator( logger, false );
        final OddEvenGenerator evenGen = new OddEvenGenerator( logger, true );
        
        Thread t1 = new Thread( oddGen );
        Thread t2 = new Thread( evenGen );
        
        t1.start();
        t2.start();
    }
    
    static class OddEvenGenerator implements Runnable
    {
        final Logger logger;
        final boolean isEvenPrinter;
        public OddEvenGenerator( final Logger log, final boolean isEven )
        {
            logger = log;
            isEvenPrinter = isEven;
        }
        
        @Override
        public void run()
        {
            for( int i =0; i < 100; i++ )
            {
                if( isEvenPrinter )
                {
                    logger.printEven();
                }
                else
                {
                    logger.printOdd();
                }
            }
        }
        
    }
    
    static class Logger
    {
        boolean isOdd = true;
        int number = 1;
        final Lock lock;
        final Condition odd;
        final Condition even;
        
        
        public Logger()
        {
            lock = new ReentrantLock();
            odd = lock.newCondition();
            even = lock.newCondition();
        }
        
        public  void  printEven()
        {
            lock.lock();
            while( isOdd == true )
            {
                try
                {
                    even.await();
                }
                catch ( InterruptedException e )
                {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            System.out.println( number++ );
            isOdd = true;
            odd.signal();
            lock.unlock();
        }
        
        public void  printOdd()
        {
            lock.lock();
            while( isOdd == false )
            {
                try
                {
                    odd.await();
                }
                catch ( InterruptedException e )
                {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            
            System.out.println( number++ );
            isOdd = false;
            even.signal();
            lock.unlock();
        }
    }
}
