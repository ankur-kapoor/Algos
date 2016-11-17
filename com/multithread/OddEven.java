package com.multithread;

public class OddEven
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
        
        public synchronized void  printEven()
        {
            while( isOdd == true )
            {
                try
                {
                    this.wait();
                }
                catch ( InterruptedException e )
                {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            System.out.println( number++ );
            isOdd = true;
            this.notifyAll();
        }
        
        public synchronized void  printOdd()
        {
            while( isOdd == false )
            {
                try
                {
                    this.wait();
                }
                catch ( InterruptedException e )
                {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            System.out.println( number++ );
            isOdd = false;
            this.notifyAll();
        }
    }
}
