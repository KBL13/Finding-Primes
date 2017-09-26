import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.util.Vector;
import java.util.Random;
import java.lang.Runnable;
import java.util.concurrent.*;

class PrintPrimes implements Runnable
{	
	public int start;
	public int end;
   	public Set<Integer> t = new HashSet<Integer>();
   	 //ArrayList<int> list = Collections.synchronizedList(new ArrayList<int>());

	public PrintPrimes(int x, int y)
	{
		start = x;
		end = y;
	}

	public void run()
	{

        int s1 = start;
        int s2 = end;
        int flag = 0;
 		int temp = 0;
 		int count = 0;
 		
   		if (end < 2)
    	{
        	/*System.out.println("The prime numbers are: ");
        	System.out.println(2);*/
    	}
    	else
    	{

    		temp = start; //Prime finder taken from scoundry.com
    		if ( temp % 2 == 0)
    		{
        		temp++;
    		}
    		for (int i = temp; i <= end; i = i + 2)
    		{
    			
        		flag = 0;
        		for (int j = 2; j <= i / 2; j++)
        		{
            		if ((i % j) == 0)
            		{
                		flag = 1;
                		break;
            		}
        		}	
        		if (flag == 0)
        		{
      
        			if (i == 1)
        			{
        				System.out.println("The prime numbers are: ");
        				System.out.println(2);
        			}
        			else
        			{

        					System.out.println(i);
        			}
        			count++;
        			
            		
        		}
    		} 		
   		 	
   	}
   }  	
}

public class PrimeThreads
{
	public static void main(String[] args) 
	{
		int temp;
		PrintPrimes temp1[] = new PrintPrimes[100];
		temp = Integer.parseInt(args[0]);
		temp = temp/100;
  		for (int i=0; i<100;i++)
  		{	if (i == 0)
  			{
      		temp1[i]= new PrintPrimes(i*temp,(i+1)*temp);
      		//temp1[i].start();
            ExecutorService executor = Executors.newCachedThreadPool();
            //start off the threads
            temp[i].execute(temp1[i]);

   
      	}
      	else
      	{
      		temp1[i]= new PrintPrimes((i*temp)+1,(i+1)*temp);
      		//temp1[i].start();
            ExecutorService executor = Executors.newCachedThreadPool();
            executor.execute(temp1[i]);
            temp[i].shutdown(); 
      	}
      //Once we're done, we shut the service down   
  		} 
      executor.shutdown(); 
	} 
}