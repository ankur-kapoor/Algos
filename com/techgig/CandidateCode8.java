package com.techgig;

import java.io.*;
public class CandidateCode8 
{ 
    public static String[] RatsPostions(String[] input1,String[] input2,int input3)
    {
        int[][] pos=new int[input1.length][2];
        int[][] rectangle=new int[input2.length][input2[0].split("#").length];
        for(int i=0;i<pos.length;i++)
        {
            String[] temp=input1[i].split("#");
            pos[i][0]=(Integer.parseInt(temp[0])-1)<0?0:Integer.parseInt(temp[0])-1;
            pos[i][1]=(Integer.parseInt(temp[1])-1)<0?0:Integer.parseInt(temp[1])-1;
        }
        for(int i=0;i<rectangle.length;i++)
        {
            String[] temp=input2[i].split("#");
            for(int k=0;k<temp.length;k++)
            {
                rectangle[i][k]=Integer.parseInt(temp[k]);
            }
        }
        final String[] output = new String[input1.length];
        for(int j=0;j<input3;j++)
        {
            for(int k=0;k<input1.length;k++)
            {
               positionFinder(pos[k][0],pos[k][1],rectangle, output, k, pos);
            }
        }
        return output;
    }
   
   static void positionFinder(int i,int j,int[][] rectangle, final String[] output, int index, int[][] pos )
    {
        int currTemp= rectangle[i][j];
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};
        int _x=i;
        int _y=j;
        int min = Integer.MAX_VALUE;
        for( int k = 0; k < 4; k++) 
        {
            int xx = i+dx[k];
            int yy = j+dy[k];
            if( xx >= 0 && xx < rectangle.length && yy >= 0 && yy < rectangle[0].length )
            {
                int t = Math.abs( currTemp - rectangle[xx][yy] );
                
                if( t < min )
                {
                    _x = xx;
                    _y = yy;
                    min = t;
                }
            }
        }
        pos[index][0] = _x;
        pos[index][1] = _y;
        output[index] = (_x+1)+"#"+(_y+1);
    }
   
   public static void main( String[] args )
   {
       String[] input1 = {"1#1","2#5","3#3","6#3"};
       String[] input2 = {"2#6#8#6#-7","2#5#-5#-5#0","-1#3#-8#8#7","3#2#0#6#9","2#1#-4#5#8","-5#6#7#4#7"};
       int input3 = 3;
       long start = System.currentTimeMillis();
       
       String[] output = RatsPostions( input1, input2, input3 );
       long end = System.currentTimeMillis();
       
       for( String o : output )
       {
           System.out.println( o );
       }
       
       
       
       System.out.println( "Time took = "+ (end-start) );
   }
}