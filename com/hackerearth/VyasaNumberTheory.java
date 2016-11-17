package com.hackerearth;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 *https://www.hackerearth.com/happay-hiring-challenge/problems/a005172b6c954d5c93878b93d7c70e2b/
 * * @author ankurkap
 *
 */

public class VyasaNumberTheory
{
    
    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        
        long[] a = new long[N];
        final List<List<Long>> subSets = new ArrayList<>();  
        for( int k=0; k < N ; k++ )
        {
            a[k]= in.nextLong();
            
            for( final List l : subSets )
            {
                
            }
        }
        
        Arrays.sort( a );
        in.close();
        //System.out.println(cnt) ;
    }
}
