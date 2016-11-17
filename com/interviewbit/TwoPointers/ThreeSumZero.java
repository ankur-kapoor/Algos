package com.interviewbit.TwoPointers;

import java.util.ArrayList;
import java.util.Collections;

public class ThreeSumZero
{

    public ArrayList<ArrayList<Integer>> threeSum(ArrayList<Integer> a) 
    {
        final ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        
        int n = a.size();
        
        if( n < 3 )
        {
            return res;
        }
        else if( n == 3)
        {
            if( a.get( 0 )+ a.get( 1 ) + a.get( 2 ) == 0) 
            {
                res.add( a );
            }
            return res;
        }
        
        Collections.sort( a );
        
        for (int i = 0; i < n - 2; i++) {
            // //avoid duplicate solutions
            if (i == 0 || a.get( i ) > a.get( i-1 )) {
     
                int negate = -a.get( i );
     
                int start = i + 1;
                int end = n-1;
     
                while (start < end) {
                    //case 1
                    if (a.get( start ).intValue() + a.get( end ).intValue() == negate) 
                    {
                        ArrayList<Integer> temp = new ArrayList<Integer>();
                        temp.add(a.get( i ));
                        temp.add(a.get( start ));
                        temp.add(a.get( end ));
     
                        res.add(temp);
                        start++;
                        end--;
                        //avoid duplicate solutions
                        while (start < end && a.get( end ).intValue() == a.get( end + 1 ).intValue())
                            end--;
     
                        while (start < end && a.get( start).intValue() == a.get( start -1 ).intValue())
                            start++;
                    //case 2
                    } 
                    else if (a.get(start).intValue() + a.get( end ).intValue() < negate) 
                    {
                        start++;
                    //case 3
                    } 
                    else 
                    {
                        end--;
                    }
                }
            }
        }
        
        return res;
        
    }
    public static void main( String[] args )
    {
        
    }
}
