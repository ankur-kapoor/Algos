package com.techgig;

import java.io.*;
public class CandidateCode 
{ 
    public static int distributeCadbury(int input1,int input2,int input3,int input4)
    {
        int M = input1;
        int N = input2;
        
        int P = input3;
        int Q = input4;
        
        int c = 0;
        
        for( int i =M; i <= N ; i++ )
        {
            for( int j =P; j <= Q ; j++ )
            {
                c++;
                int ii = i;
                int jj = j;
                
                while( ii != jj )
                {
                    if( ii > jj )
                    {
                        ii -= jj; 
                    }
                    else
                    {
                        jj -= ii; 
                    }
                    
                    c++;
                }
            }
        }
        
        return c;
    }
   
   public static void main( String[] args )
   {
       String[] input1 = {"1#1","2#5","3#3","6#3"};
       String[] input2 = {"2#6#8#6#-7","2#5#-5#-5#0","-1#3#-8#8#7","3#2#0#6#9","2#1#-4#5#8","-5#6#7#4#7"};
       int input3 = 3;
       long start = System.currentTimeMillis();
       
       System.out.println( distributeCadbury( 5, 6, 3, 4 ) );
       
       long end = System.currentTimeMillis();
       
       System.out.println( "Time took = "+ (end-start) );
   }
}