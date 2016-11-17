package com.interviewbit.Greedy;

import java.util.Iterator;
import java.util.StringTokenizer;

/**
 *  Aurum Nugget, Inc. has just purchased some new gold mines. They have a number of miners available to work in the mines, and would like to allocate the miners in such a way as to maximize their profit. Each mine can support a maximum of 6 miners, and contains a maximum of 6 major ore deposits. After the miners have been allocated to mines, the company earns (or loses) money as follows:

If a mine has fewer miners than ore deposits, the company will earn $60 per miner allocated to that mine.
If a mine has the same number of miners as ore deposits, the company will earn $50 per miner allocated to that mine.
If a mine has more miners than ore deposits, the company will earn $50 for each miner up to the number of ore deposits, and will lose $20 for each extra miner allocated to that mine.


Even if it will lose money, the company must employ every available worker at one of its mines.



Write a class GoldMine with a method getAllocation that takes in a String[] mines and a int miners. Each element of mines will be in the form "<p0>, <p1>, <p2>, <p3>, <p4>, <p5>, <p6>" (quotes for clarity) where each <pn> is a three digit number (with leading 0s if necessary.) Each <pn> represents the probability (as a percentage) that n deposits are present in the mine, and all <pn>'s within a mine will always add up to 100. miners is the number of employees the company must allocate. The method should return a int[] indicating the number of miners to place in each mine in order to maximize the expected profit (where element i in the returned int[] corresponds to element i of mines). If there are multiple allocations which maximize expected profit, return the allocation which places more miners in earlier mines. More specifically, when comparing two different allocations X0, X1, X2, ..., Xn and Y0, Y1, Y2, ..., Yn that yield the same expected profit, let i be the smallest index such that Xi is not equal to Yi. Then if Xi > Yi, allocation X0, X1, X2, ..., Xn is preferred to allocation Y0, Y1, Y2, ..., Yn.



For example, suppose the company has 4 miners available, and purchased the following two mines:

    "000, 030, 030, 040, 000, 000, 000"
        "020, 020, 020, 010, 010, 010, 010"


The first mine has a 30 percent chance of containing 1 ore deposit, a 30 percent chance of containing 2 ore deposits, and a 40 percent chance of containing 3 ore deposits. The second mine has a 20 percent chance of containing 0 ore deposits, a 20 percent chance of containing 1 ore deposit, a 20 percent chance of containing 2 ore deposits, a 10 percent chance of containing 3 ore deposits, a 10 percent chance of containing 4 ore deposits, a 10 percent chance of containing 5 ore deposits, and a 10 percent chance of containing 6 ore deposits.



In this scenario, the company can make the most money by allocating two miners at each mine, yielding an expected profit of 153:

    First Mine
       0.3*30 + 0.3*100 + 0.4*120 =
           9 + 30 + 48 = 87

    Second Mine
           0.2*(-40) + 0.2*30 + 0.2*100 + 0.1*120 + 0.1*120 + 0.1*120 + 0.1*120 = 
           -8 + 6 + 20 + 12 + 12 + 12 + 12 = 66

    Total Profit
       87 + 66 = 153


The method would have returned { 2, 2 }. Other allocations would have yielded:

    { 0, 4 } :  75
    { 1, 3 } : 132
    { 3, 1 } : 129
    { 4, 0 } :  67


 
Definition
        
Class:  GoldMine
Method: getAllocation
Parameters: String[], int
Returns:    int[]
Method signature:   int[] getAllocation(String[] mines, int miners)
(be sure your method is public)
    
 
Notes
-   Each mine can support a maximum of 6 miners.
 
Constraints
-   mines will contain between 1 and 50 elements, inclusive
-   each element of mines will contain exactly 33 characters
-   each element of mines will contain only digits ('0'-'9'), commas (',') and spaces (' ')
-   each element of mines will be in the form "<p0>, <p1>, <p2>, <p3>, <p4>, <p5>, <p6>" (quotes for clarity) where each <pn> is a three digit number (with leading 0s if necessary.) Each <pn> represents the probability (as a percentage) that n deposits are present in the mine, and all <pn>'s within a mine will always add up to 100
-   miners will be between 1 and (6 * the number of elements in mines), inclusive
 
Examples
0)  
        
{ "000, 030, 030, 040, 000, 000, 000",
  "020, 020, 020, 010, 010, 010, 010" }
4
Returns: { 2,  2 }
This is the example from the problem statement.
1)  
        
{ "100, 000, 000, 000, 000, 000, 000",
  "100, 000, 000, 000, 000, 000, 000",
  "100, 000, 000, 000, 000, 000, 000",
  "100, 000, 000, 000, 000, 000, 000",
  "100, 000, 000, 000, 000, 000, 000" }
8
Returns: { 6,  2,  0,  0,  0 }
There are no deposits in any mines. However, since the company must employ every available worker, it loses $160 ($20 per worker). The proper allocation places 6 workers in the first mine and 2 workers in the second mine, since that is the allocation that places more workers in earlier mines and the maximum number of workers a mine can support is 6.
2)  
        
{ "050, 000, 000, 000, 000, 050, 000",
  "050, 000, 000, 000, 000, 050, 000",
  "050, 000, 000, 000, 000, 050, 000",
  "050, 000, 000, 000, 000, 050, 000",
  "050, 000, 000, 000, 000, 050, 000",
  "050, 000, 000, 000, 000, 050, 000",
  "050, 000, 000, 000, 000, 050, 000",
  "050, 000, 000, 000, 000, 050, 000",
  "050, 000, 000, 000, 000, 050, 000",
  "050, 000, 000, 000, 000, 050, 000" }
30
Returns: { 4,  4,  4,  4,  4,  4,  4,  2,  0,  0 }
Each mine has a 50 percent chance of containing no deposits and a 50 percent chance of containing 5 deposits. The expected value from a mine like this is maximized with 4 workers. Since we allocate workers to earlier mines first, the early mines are filled with 4 workers each, and the remaining 2 miners are placed in the next available mine.
3)  
        
{ "026, 012, 005, 013, 038, 002, 004",
  "026, 012, 005, 013, 038, 002, 004",
  "026, 012, 005, 013, 038, 002, 004",
  "026, 012, 005, 013, 038, 002, 004",
  "026, 012, 005, 013, 038, 002, 004",
  "026, 012, 005, 013, 038, 002, 004",
  "026, 012, 005, 013, 038, 002, 004",
  "026, 012, 005, 013, 038, 002, 004",
  "026, 012, 005, 013, 038, 002, 004",
  "026, 012, 005, 013, 038, 002, 004",
  "026, 012, 005, 013, 038, 002, 004",
  "026, 012, 005, 013, 038, 002, 004",
  "026, 012, 005, 013, 038, 002, 004",
  "026, 012, 005, 013, 038, 002, 004",
  "026, 012, 005, 013, 038, 002, 004",
  "026, 012, 005, 013, 038, 002, 004",
  "026, 012, 005, 013, 038, 002, 004",
  "026, 012, 005, 013, 038, 002, 004",
  "026, 012, 005, 013, 038, 002, 004",
  "026, 012, 005, 013, 038, 002, 004",
  "026, 012, 005, 013, 038, 002, 004",
  "026, 012, 005, 013, 038, 002, 004",
  "026, 012, 005, 013, 038, 002, 004",
  "026, 012, 005, 013, 038, 002, 004",
  "026, 012, 005, 013, 038, 002, 004",
  "026, 012, 005, 013, 038, 002, 004",
  "026, 012, 005, 013, 038, 002, 004",
  "026, 012, 005, 013, 038, 002, 004",
  "026, 012, 005, 013, 038, 002, 004",
  "026, 012, 005, 013, 038, 002, 004",
  "026, 012, 005, 013, 038, 002, 004",
  "026, 012, 005, 013, 038, 002, 004",
  "026, 012, 005, 013, 038, 002, 004",
  "026, 012, 005, 013, 038, 002, 004",
  "026, 012, 005, 013, 038, 002, 004",
  "026, 012, 005, 013, 038, 002, 004",
  "026, 012, 005, 013, 038, 002, 004",
  "026, 012, 005, 013, 038, 002, 004",
  "026, 012, 005, 013, 038, 002, 004",
  "026, 012, 005, 013, 038, 002, 004",
  "026, 012, 005, 013, 038, 002, 004",
  "026, 012, 005, 013, 038, 002, 004",
  "026, 012, 005, 013, 038, 002, 004",
  "026, 012, 005, 013, 038, 002, 004",
  "026, 012, 005, 013, 038, 002, 004",
  "026, 012, 005, 013, 038, 002, 004",
  "026, 012, 005, 013, 038, 002, 004",
  "026, 012, 005, 013, 038, 002, 004",
  "026, 012, 005, 013, 038, 002, 004",
  "026, 012, 005, 013, 038, 002, 004" }
56
Returns: 
{ 2,  2,  2,  2,  2,  2,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1 }
4)  
        
{ "100, 000, 000, 000, 000, 000, 000",
  "090, 010, 000, 000, 000, 000, 000",
  "080, 020, 000, 000, 000, 000, 000",
  "075, 025, 000, 000, 000, 000, 000",
  "050, 050, 000, 000, 000, 000, 000",
  "025, 075, 000, 000, 000, 000, 000",
  "020, 080, 000, 000, 000, 000, 000",
  "010, 090, 000, 000, 000, 000, 000",
  "000, 100, 000, 000, 000, 000, 000",
  "000, 090, 010, 000, 000, 000, 000",
  "000, 080, 020, 000, 000, 000, 000",
  "000, 075, 025, 000, 000, 000, 000",
  "000, 050, 050, 000, 000, 000, 000",
  "000, 025, 075, 000, 000, 000, 000",
  "000, 020, 080, 000, 000, 000, 000",
  "000, 010, 090, 000, 000, 000, 000",
  "000, 000, 100, 000, 000, 000, 000",
  "000, 000, 090, 010, 000, 000, 000",
  "000, 000, 080, 020, 000, 000, 000",
  "000, 000, 075, 025, 000, 000, 000",
  "000, 000, 050, 050, 000, 000, 000",
  "000, 000, 025, 075, 000, 000, 000",
  "000, 000, 020, 080, 000, 000, 000",
  "000, 000, 010, 090, 000, 000, 000",
  "000, 000, 000, 100, 000, 000, 000",
  "000, 000, 000, 100, 000, 000, 000",
  "000, 000, 000, 090, 010, 000, 000",
  "000, 000, 000, 080, 020, 000, 000",
  "000, 000, 000, 075, 025, 000, 000",
  "000, 000, 000, 050, 050, 000, 000",
  "000, 000, 000, 025, 075, 000, 000",
  "000, 000, 000, 020, 080, 000, 000",
  "000, 000, 000, 010, 090, 000, 000",
  "000, 000, 000, 000, 100, 000, 000",
  "000, 000, 000, 000, 090, 010, 000",
  "000, 000, 000, 000, 080, 020, 000",
  "000, 000, 000, 000, 075, 025, 000",
  "000, 000, 000, 000, 050, 050, 000",
  "000, 000, 000, 000, 025, 075, 000",
  "000, 000, 000, 000, 020, 080, 000",
  "000, 000, 000, 000, 010, 090, 000",
  "000, 000, 000, 000, 000, 100, 000",
  "000, 000, 000, 000, 000, 090, 010",
  "000, 000, 000, 000, 000, 080, 020",
  "000, 000, 000, 000, 000, 075, 025",
  "000, 000, 000, 000, 000, 050, 050",
  "000, 000, 000, 000, 000, 025, 075",
  "000, 000, 000, 000, 000, 020, 080",
  "000, 000, 000, 000, 000, 010, 090",
  "000, 000, 000, 000, 000, 000, 100" }
150
Returns: 
{ 0,  0,  0,  1,  1,  1,  1,  1,  1,  1,  1,  1,  2,  2,  2,  2,  2,  2,  2,  2,  3,  3,  3,  3,  3,  3,  3,  3,  3,  4,  4,  4,  4,  4,  4,  4,  4,  4,  5,  5,  5,  5,  5,  5,  5,  5,  5,  5,  6,  6 }

 * @author ankurkap
 *
 */

public class GoldMine
{
    public int[] getAllocation(String[] mm /*mines*/, int m2 /*miners*/) 
    { 
        int mmlen=mm.length; 
        int c=0, count=0, i=0, j=0, k=0, l=0, x=0, y=0, z=0; 
        char ch; 
        String s; StringTokenizer st; Iterator it; 
        int[] rv = new int[mmlen]; 

        int[][] pb; 
        pb = new int[mmlen][7]; 

        int[][] v; 
        v = new int[mmlen][7]; 

        for (i = 0; i < mmlen; i++) 
        { 
          st = new StringTokenizer(mm[i], " ,"); 
          for (j = 0; j < 7; j++) 
            pb[i][j] = Integer.parseInt("1"+st.nextToken())-1000; 
        } 

        for ( i = 0; i < mmlen; i++ )
        {
            for ( j = 0; j < 7; j++ )
            {
                for ( k = 0; k < 7; k++ )
                {
                    if ( j < k )
                    {
                        v[i][j] += z = pb[i][k] * j * 60;
                        println ("mine " + i + " workers " + j + " ore " + k + " profit " + z);
                    } 
                    else if ( j == k )
                    {
                        v[i][j] += z = pb[i][k] * j * 50;
                        println ("mine " + i + " workers " + j + " ore " + k + " profit " + z);
                    } 
                    else
                    {
                        v[i][j] += z = pb[i][k] * ( k * 50 + ( k - j ) * 20 );
                        println ("mine " + i + " workers " + j + " ore " + k + " profit " + z);
                    } 
                }
            }
        }
         // Table for every worker   
         for (i = 0; i < mmlen; i++) 
         { 
           for (j = 0; j < 7; j++) 
             print (" " + v[i][j]); 
           println (""); 
         } 

        for (i = 0; i < m2; i++) 
        { 
          int bestIncrease = -9999999; 
          int bestMine = 0; 

          for (j = 0; j < mmlen; j++) 
          { 
            if (rv[j] == 6) continue; 
            int increase = v[j][rv[j]+1] - v[j][rv[j]]; 
            if (increase > bestIncrease) 
            { 
              bestIncrease = increase; 
              bestMine = j; 
            } 
          } 
          rv[bestMine]++; 
        } 

        return rv; 
    } 

    static public void main (String[] args) 
    { 
        /*{ 
        GoldMine tempObject = new GoldMine (); 
        String[] mines = ; 
        int miners = ; 
        int[] result = tempObject.getAllocation (mines, miners); 

        System.out.println ("Expected: "); 
        System.out.print ("Received: "); 
        String sep = "{ "; for (int ac = 0; ac < result.length; ac++) 
        {System.out.print (sep + result[ac]); sep = ",  ";} 
        System.out.println (" }"); 
        } 
        */ 
        { 
        GoldMine tempObject = new GoldMine (); 
        String[] mines = { "000, 030, 030, 040, 000, 000, 000", 
  "020, 020, 020, 010, 010, 010, 010" }; 
        int miners = 4; 
        int[] result = tempObject.getAllocation (mines, miners); 

        System.out.println ("Expected: { 2,  2 }"); 
        System.out.print ("Received: "); 
        String sep = "{ "; for (int ac = 0; ac < result.length; ac++) 
        {System.out.print (sep + result[ac]); sep = ",  ";} 
        System.out.println (" }"); 
        } 

        /*   { 
        GoldMine tempObject = new GoldMine (); 
        String[] mines = { "100, 000, 000, 000, 000, 000, 000", 
  "100, 000, 000, 000, 000, 000, 000", 
  "100, 000, 000, 000, 000, 000, 000", 
  "100, 000, 000, 000, 000, 000, 000", 
  "100, 000, 000, 000, 000, 000, 000" }; 
        int miners = 8; 
        int[] result = tempObject.getAllocation (mines, miners); 

        System.out.println ("Expected: { 6,  2,  0,  0,  0 }"); 
        System.out.print ("Received: "); 
        String sep = "{ "; for (int ac = 0; ac < result.length; ac++) 
        {System.out.print (sep + result[ac]); sep = ",  ";} 
        System.out.println (" }"); 
        } 

        { 
        GoldMine tempObject = new GoldMine (); 
        String[] mines = { "050, 000, 000, 000, 000, 050, 000", 
  "050, 000, 000, 000, 000, 050, 000", 
  "050, 000, 000, 000, 000, 050, 000", 
  "050, 000, 000, 000, 000, 050, 000", 
  "050, 000, 000, 000, 000, 050, 000", 
  "050, 000, 000, 000, 000, 050, 000", 
  "050, 000, 000, 000, 000, 050, 000", 
  "050, 000, 000, 000, 000, 050, 000", 
  "050, 000, 000, 000, 000, 050, 000", 
  "050, 000, 000, 000, 000, 050, 000" }; 
        int miners = 30; 
        int[] result = tempObject.getAllocation (mines, miners); 

        System.out.println ("Expected: { 4,  4,  4,  4,  4,  4,  4,  2,  0,  0 }"); 
        System.out.print ("Received: "); 
        String sep = "{ "; for (int ac = 0; ac < result.length; ac++) 
        {System.out.print (sep + result[ac]); sep = ",  ";} 
        System.out.println (" }"); 
        } 

        { 
        GoldMine tempObject = new GoldMine (); 
        String[] mines = { "026, 012, 005, 013, 038, 002, 004", 
  "026, 012, 005, 013, 038, 002, 004", 
  "026, 012, 005, 013, 038, 002, 004", 
  "026, 012, 005, 013, 038, 002, 004", 
  "026, 012, 005, 013, 038, 002, 004", 
  "026, 012, 005, 013, 038, 002, 004", 
  "026, 012, 005, 013, 038, 002, 004", 
  "026, 012, 005, 013, 038, 002, 004", 
  "026, 012, 005, 013, 038, 002, 004", 
  "026, 012, 005, 013, 038, 002, 004", 
  "026, 012, 005, 013, 038, 002, 004", 
  "026, 012, 005, 013, 038, 002, 004", 
  "026, 012, 005, 013, 038, 002, 004", 
  "026, 012, 005, 013, 038, 002, 004", 
  "026, 012, 005, 013, 038, 002, 004", 
  "026, 012, 005, 013, 038, 002, 004", 
  "026, 012, 005, 013, 038, 002, 004", 
  "026, 012, 005, 013, 038, 002, 004", 
  "026, 012, 005, 013, 038, 002, 004", 
  "026, 012, 005, 013, 038, 002, 004", 
  "026, 012, 005, 013, 038, 002, 004", 
  "026, 012, 005, 013, 038, 002, 004", 
  "026, 012, 005, 013, 038, 002, 004", 
  "026, 012, 005, 013, 038, 002, 004", 
  "026, 012, 005, 013, 038, 002, 004", 
  "026, 012, 005, 013, 038, 002, 004", 
  "026, 012, 005, 013, 038, 002, 004", 
  "026, 012, 005, 013, 038, 002, 004", 
  "026, 012, 005, 013, 038, 002, 004", 
  "026, 012, 005, 013, 038, 002, 004", 
  "026, 012, 005, 013, 038, 002, 004", 
  "026, 012, 005, 013, 038, 002, 004", 
  "026, 012, 005, 013, 038, 002, 004", 
  "026, 012, 005, 013, 038, 002, 004", 
  "026, 012, 005, 013, 038, 002, 004", 
  "026, 012, 005, 013, 038, 002, 004", 
  "026, 012, 005, 013, 038, 002, 004", 
  "026, 012, 005, 013, 038, 002, 004", 
  "026, 012, 005, 013, 038, 002, 004", 
  "026, 012, 005, 013, 038, 002, 004", 
  "026, 012, 005, 013, 038, 002, 004", 
  "026, 012, 005, 013, 038, 002, 004", 
  "026, 012, 005, 013, 038, 002, 004", 
  "026, 012, 005, 013, 038, 002, 004", 
  "026, 012, 005, 013, 038, 002, 004", 
  "026, 012, 005, 013, 038, 002, 004", 
  "026, 012, 005, 013, 038, 002, 004", 
  "026, 012, 005, 013, 038, 002, 004", 
  "026, 012, 005, 013, 038, 002, 004", 
  "026, 012, 005, 013, 038, 002, 004" }; 
        int miners = 56; 
        int[] result = tempObject.getAllocation (mines, miners); 

        System.out.println ("Expected: { 2,  2,  2,  2,  2,  2,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1 }");
        System.out.print ("Received: "); 
        String sep = "{ "; for (int ac = 0; ac < result.length; ac++) 
        {System.out.print (sep + result[ac]); sep = ",  ";} 
        System.out.println (" }"); 
        } 

        { 
        GoldMine tempObject = new GoldMine (); 
        String[] mines = { "100, 000, 000, 000, 000, 000, 000", 
  "090, 010, 000, 000, 000, 000, 000", 
  "080, 020, 000, 000, 000, 000, 000", 
  "075, 025, 000, 000, 000, 000, 000", 
  "050, 050, 000, 000, 000, 000, 000", 
  "025, 075, 000, 000, 000, 000, 000", 
  "020, 080, 000, 000, 000, 000, 000", 
  "010, 090, 000, 000, 000, 000, 000", 
  "000, 100, 000, 000, 000, 000, 000", 
  "000, 090, 010, 000, 000, 000, 000", 
  "000, 080, 020, 000, 000, 000, 000", 
  "000, 075, 025, 000, 000, 000, 000", 
  "000, 050, 050, 000, 000, 000, 000", 
  "000, 025, 075, 000, 000, 000, 000", 
  "000, 020, 080, 000, 000, 000, 000", 
  "000, 010, 090, 000, 000, 000, 000", 
  "000, 000, 100, 000, 000, 000, 000", 
  "000, 000, 090, 010, 000, 000, 000", 
  "000, 000, 080, 020, 000, 000, 000", 
  "000, 000, 075, 025, 000, 000, 000", 
  "000, 000, 050, 050, 000, 000, 000", 
  "000, 000, 025, 075, 000, 000, 000", 
  "000, 000, 020, 080, 000, 000, 000", 
  "000, 000, 010, 090, 000, 000, 000", 
  "000, 000, 000, 100, 000, 000, 000", 
  "000, 000, 000, 100, 000, 000, 000", 
  "000, 000, 000, 090, 010, 000, 000", 
  "000, 000, 000, 080, 020, 000, 000", 
  "000, 000, 000, 075, 025, 000, 000", 
  "000, 000, 000, 050, 050, 000, 000", 
  "000, 000, 000, 025, 075, 000, 000", 
  "000, 000, 000, 020, 080, 000, 000", 
  "000, 000, 000, 010, 090, 000, 000", 
  "000, 000, 000, 000, 100, 000, 000", 
  "000, 000, 000, 000, 090, 010, 000", 
  "000, 000, 000, 000, 080, 020, 000", 
  "000, 000, 000, 000, 075, 025, 000", 
  "000, 000, 000, 000, 050, 050, 000", 
  "000, 000, 000, 000, 025, 075, 000", 
  "000, 000, 000, 000, 020, 080, 000", 
  "000, 000, 000, 000, 010, 090, 000", 
  "000, 000, 000, 000, 000, 100, 000", 
  "000, 000, 000, 000, 000, 090, 010", 
  "000, 000, 000, 000, 000, 080, 020", 
  "000, 000, 000, 000, 000, 075, 025", 
  "000, 000, 000, 000, 000, 050, 050", 
  "000, 000, 000, 000, 000, 025, 075", 
  "000, 000, 000, 000, 000, 020, 080", 
  "000, 000, 000, 000, 000, 010, 090", 
  "000, 000, 000, 000, 000, 000, 100" }; 
        int miners = 150; 
        int[] result = tempObject.getAllocation (mines, miners); 

        System.out.println ("Expected: { 0,  0,  0,  1,  1,  1,  1,  1,  1,  1,  1,  1,  2,  2,  2,  2,  2,  2,  2,  2,  3,  3,  3,  3,  3,  3,  3,  3,  3,  4,  4,  4,  4,  4,  4,  4,  4,  4,  5,  5,  5,  5,  5,  5,  5,  5,  5,  5,  6,  6 }");
        System.out.print ("Received: "); 
        String sep = "{ "; for (int ac = 0; ac < result.length; ac++) 
        {System.out.print (sep + result[ac]); sep = ",  ";} 
        System.out.println (" }"); 
        } 

        /*{ 
        GoldMine tempObject = new GoldMine (); 
        String[] mines = ; 
        int miners = ; 
        int[] result = tempObject.getAllocation (mines, miners); 

        System.out.println ("Expected: "); 
        System.out.print ("Received: "); 
        String sep = "{ "; for (int ac = 0; ac < result.length; ac++) 
        {System.out.print (sep + result[ac]); sep = ",  ";} 
        System.out.println (" }"); 
        } 
        */ 
    } 
    public String[] tokenize (String s) 
    { 
        // P. Jensen's (Oblok's) library code -- Copyright 2003.  Converts 
        //   a string into an array of its delimited tokens. 
        StringTokenizer st=new StringTokenizer(s," "); 
        String[] rv=new String[st.countTokens()]; 
        for (int i=0;i<rv.length;i++)rv[i]=st.nextToken(); 
        return rv; 
    } 

    public String[][] tokenize (String s[]) 
    { 
        // P. Jensen's (Oblok's) library code -- Copyright 2003.  Converts 
        //   a string array into arrays of its delimited tokens. 
        String[][] rv = new String[s.length][]; 
        for (int j=0;j<s.length;j++){ 
          StringTokenizer st=new StringTokenizer(s[j]," "); 
          rv[j]=new String[st.countTokens()]; 
          for (int i=0;i<rv[j].length;i++)rv[j][i]=st.nextToken();} 
        return rv; 
    } 

    static public char[] charize (String s) 
    { 
        // P. Jensen's (Oblok's) library code -- Too simple to comment. 
        return s.toCharArray(); 
    } 

    static public char[][] charize (String[] s) 
    { 
        // P. Jensen's (Oblok's) library code -- Copyright 2003.  Converts 
        //   a string array into arrays of its characters. 
        char[][] rv = new char[s.length][]; 
        for (int i=0;i<s.length;i++) 
          rv[i]=s[i].toCharArray(); 
        return rv; 
    } 

    public int[] valueize (String s) 
    { 
        // P. Jensen's (Oblok's) library code -- Copyright 2003.  Converts 
        //   the string tokens to an array of integers, replacing invalid 
        //   values with MIN_VALUE. 
        String[] t=tokenize(s); 
        int[] rv=new int[t.length]; 
        for (int i=0;i<t.length;i++) 
          try{rv[i]=Integer.parseInt(t[i]);}catch(NumberFormatException e){rv[i]=Integer.MIN_VALUE;} 
        return rv; 
    } 
    public int[][] valueize (String s[]) 
    { 
        // P. Jensen's (Oblok's) library code -- Copyright 2003.  Converts 
        //   the array of string tokens to arrays of integers, replacing invalid 
        //   values with MIN_VALUE. 
        int[][] rv=new int[s.length][]; 
        for (int i=0;i<s.length;i++) 
          rv[i]=valueize(s[i]); 
        return rv; 
    } 
    public void print (String s){System.out.print(s);} 
    public void println (String s){System.out.println(s);} 
}
