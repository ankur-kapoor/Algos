package com.multithread;

public class DeadLock
{
    final static Object lock1 = new Object();
    final static Object lock2 = new Object();
    
    
    private static class ThreadOne extends Thread
    {
        public void run()
        {
            while( true )
            {
                synchronized(lock1)
                {
                    System.out.println( this.getName() +": Holding lock 1");
                    
                    try
                    {
                        Thread.sleep( 3000 );
                    }
                    catch( InterruptedException ie )
                    {
                    }
                    System.out.println( this.getName() +": waiting for lock 2");
                    synchronized(lock2)
                    {
                        System.out.println( this.getName() +": Holding lock 1&2");
                    }
                }
            }
        }
    }
    
    private static class ThreadTwo extends Thread
    {
        public void run()
        {
            while( true )
            {
                synchronized(lock2)
                {
                    System.out.println( this.getName() +": Holding lock 2");
                    
                    try
                    {
                        Thread.sleep( 5000 );
                    }
                    catch( InterruptedException ie )
                    {
                    }
                    System.out.println( this.getName() +": waiting for lock 1");
                    synchronized(lock1)
                    {
                        System.out.println( this.getName() +": Holding lock 2&1");
                    }
                }
            }
        }
    }
    
    public static void main( String... args )
    {
        final ThreadOne t1 = new ThreadOne();
        
        t1.setName( "Thread1" );
        
        final ThreadOne t2 = new ThreadOne();
        
        t2.setName( "Thread2" );
        
        t1.start();
        t2.start();
    }
    
}
