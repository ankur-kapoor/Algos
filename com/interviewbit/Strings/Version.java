package com.interviewbit.Strings;

import java.util.StringTokenizer;

/**
 * 
 * Compare two version numbers version1 and version2.

If version1 > version2 return 1,
If version1 < version2 return -1,
otherwise return 0.
You may assume that the version strings are non-empty and contain only digits and the . character.
The . character does not represent a decimal point and is used to separate number sequences.
For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.

Here is an example of version numbers ordering:

0.1 < 1.1 < 1.2 < 1.13 < 1.13.4
 *
 */

public class Version
{
    public int compareVersion(String a, String b) 
    {
        String[] levels1 = a.split("\\.");
        String[] levels2 = b.split("\\.");

        int length = Math.max(levels1.length, levels2.length);
        for (int i=0; i<length; i++) {
            try
            {
                Long v1 = i < levels1.length ? Long.parseLong(levels1[i]) : 0;
                Long v2 = i < levels2.length ? Long.parseLong(levels2[i]) : 0;
                int compare = v1.compareTo(v2);
                if (compare != 0) {
                    return compare;
                }
            }
            catch( NumberFormatException e )
            {
                String s1 = String.valueOf( levels1[i] );
                String s2 = String.valueOf( levels2[i] );
                int compare = s1.length()-  s2.length();
                if (compare < 0) {
                    return -1;
                }
                else if( compare > 0)
                {
                    return 1;
                }
                else
                {
                    for( int j =0; j <s1.length(); j++ )
                    {
                        if( Integer.valueOf( s1.charAt( j ) -'0' ) > Integer.valueOf( s2.charAt( j )-'0' ))
                        {
                            return 1;
                        }
                        else if(Integer.valueOf( s1.charAt( j ) -'0' ) < Integer.valueOf( s2.charAt( j )-'0' ))
                        {
                            return -1;
                        }
                    }
                }
            }
        }

        return 0;    
    }

    private String evalString( String a1 )
    {
        if( a1.length() > 1 && a1.charAt( a1.length()-1 ) == '0')
        {
            a1 = a1.substring( 0, a1.length()-1 );
        }
        int c = 0;
        if( a1.length() > 1 )
        {
            while( a1.charAt( c) == '0')
            {
                c++;
            }
        }
        
        if( c > 0 )
        {
            a1 = a1.substring( c );
        }
        return a1;
    }
    
    private String removeDots( String val )
    {
        String b = "";
        
        for( int i =0; i< val.length(); i++)
        {
            char ch = val.charAt( i );
            if( ch != '.' )
            {
                b += String.valueOf( ch );
            }
        }
        
        return b;
    }

    public static void main(String[] args )
    {
        Version p = new Version();
        System.out.println("Version Comparisons = " + p.compareVersion( "444444444444444444444444",  "4444444444444444444444444" ) );
    }
}
