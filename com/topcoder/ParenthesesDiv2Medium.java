package com.topcoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 
 * @author ankurkap
 *
 */
public class ParenthesesDiv2Medium
{
    public  int[] correct(String s)
    {
        int n = s.length();
        final int[] res = new int[n/2+1];
        
        int c = 0;
        
        while( c <= n/2+1 )
        {
            Stack<Character> st = new Stack<>();
            
            char[] ch = s.toCharArray();
            for( int i =0; i < ch.length; i++ )
            {
                if( ch[i] == '(')
                {
                    st.push( '(' );
                }
                else if( ch[i] == ')')
                {
                    if( st.isEmpty())
                    {
                        st.push( '(' );
                        res[c++] = i;
                    }
                    else
                    {
                        if( !st.isEmpty())
                        {
                            st.pop();
                        }
                    }
                }
            }
            
            if( st.isEmpty())
            {
                return res;
            }
            else
            {
                st = new Stack<>();
                for( int i =ch.length-1; i >=0; i-- )
                {
                    if( ch[i] == ')')
                    {
                        st.push( ')' );
                    }
                    else if( ch[i] == '(')
                    {
                        if( st.isEmpty())
                        {
                            st.push( ')' );
                            res[c++] = i;
                        }
                        else
                        {
                            if( !st.isEmpty())
                            {
                                st.pop();
                            }
                        }
                    }
                }
                
                if( st.isEmpty())
                {
                    return res;
                }
            }
        }
        
        return res;
    }
  
    private boolean isValid( String s )
    {
        
        final Stack<Character> st = new Stack<>();
        
        char[] sa = s.toCharArray();
        for( int i=0; i < sa.length; i++ )
        {
            if( sa[i] == '(')
            {
                st.push( '(' );
            }
            else if( sa[i] == ')')
            {
                if( st.isEmpty())
                {
                    return false;
                }
                while( !st.isEmpty())
                {
                    st.pop();
                }
            }
        }
        
        return st.isEmpty();
    }
    
}
