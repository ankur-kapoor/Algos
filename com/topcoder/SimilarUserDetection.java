package com.topcoder;

import java.util.HashSet;
import java.util.Set;

public class SimilarUserDetection
{
    private static String SUCCESS = "Similar handles found";
    private static String FAILURE = "Similar handles not found";
    
    public String haveSimilar(String[] handles)
    {
        final Set<String> similarSet = new HashSet<>();
        
        for( String s : handles )
        {
            s = s.replace( '0', 'O' );
            s = s.replace( '1', 'I' );
            s = s.replace( 'l', 'I' );
            
            if( !similarSet.add( s ))
            {
                return SUCCESS;
            }
        }
        
        return FAILURE;
    }
}
