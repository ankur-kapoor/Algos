package com.interviewbit.StacksAndQueue;

import java.util.Stack;

/**
 * Given an absolute path for a file (Unix-style), simplify it.

For example,
path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"
 * @author ankurkap
 *
 */
public class SimplifyPath
{
    public String simplifyPath(String path)
    {
        final Stack<String> s = new Stack<>();
        path = path.trim();
        final String[] sArr = path.split( "/" );
        
        for( int i =0; i < sArr.length; i++ )
        {
            String st = sArr[i];
            st = st.trim();
            if( null != st && !st.equals( "" ) && !st.equals( " " ) && !st.equals( "." ) && !st.equals( ".." ) )
            {
                s.push( st );
            }
            else if( st.equals( ".." ))
            {
                if(!s.isEmpty())
                {
                    s.pop();
                }
            }
        }
        
        if(s.isEmpty())
        {
            return "/";
        }
        
        String res = "";
        while( !s.isEmpty())
        {
            res = "/" + s.pop() + res;
        }
        
        return res;
    }
    
    public static void main( String[] args )
    {
        final SimplifyPath sim = new SimplifyPath();
        
        System.out.println( "Simplified String Path = " + sim.simplifyPath( "/a/./b/../../c/" ) );
    }
}
