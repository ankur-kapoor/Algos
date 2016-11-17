package com.multithread;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.LinkedBlockingQueue;

public class ConcurrencySamples
{
    
    public static void main( String... args )
    {
        BlockingQueue<String> bQueue = new ArrayBlockingQueue<>( 1024 );
        BlockingQueue<String> cQueue = new LinkedBlockingQueue<>();
        DelayQueue<Delayed> dq = new DelayQueue<>();
        
        Map<String,String> map = new HashMap<>();
        Map<String,String> treemap = new TreeMap<>();
        ConcurrentMap<String, String> concurrentMap = new ConcurrentHashMap<>();
        
        Collections.synchronizedMap( map );
        
        System.out.println( "No. of Processors available = " + Runtime.getRuntime().availableProcessors() );
    }
}
