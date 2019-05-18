package cache; 
import java.util.*;
import java.io.*;

public class Cache
{
	
	public static void main(String [] args)
	{
		Scanner scanner = new Scanner(System.in);
	    int input = -2;
	    Block[] cache = new Block[10]; // each block has a queue of elements. 
	    
	    int totalReads = 0; 
	    int hitCount = 0; 
	    int missCount = 0; 
	    double hitRatio = 0.00; 
	    
	    do {
	    	System.out.println("Enter value from 0 - 99 to enter in cache, or -1 to exit program. ");
	        input = scanner.nextInt();

	        //now add this number to the cache.
	        if(input > 99 || input < -1)
	        {
	        	System.out.println("wrong input.  ");
	        	continue; 
	        }
	        if(input != -1)
	        {
	        	totalReads++; 
		        int key = input/10;
		        int value = input % 10; 
		        if(cache[key] == null)
		        {
		        	missCount++; 
		        	System.out.println("when initialized array element " + key +  " is null. ");
		        	Block a = new Block();
		        	cache[key] = a; 
		        	
		        	//now add these to the queue.
		        	Line l = new Line(value, true);
		        	a.lines.enqueue(l);
		        	System.out.println("adding " + value + " to the queue. ");
		        }
		        else {
		        	boolean foundVal = false; 
		        	Node ptr = cache[key].lines.front;
		        	while(ptr != null)
		        	{
		        		if(ptr.line.value == value)
		        		{
		        			hitCount++; 
		        			foundVal = true; 
		        			break; 
		        		}
		        		ptr = ptr.next; 
		        	}
		        	
		        	if(foundVal == false)
		        	{
		        		if(cache[key].lines.size == 2)
			        	{
			        		cache[key].lines.dequeue(); 
			        		Line line = new Line(value, true); 
			        		cache[key].lines.enqueue(line);
			        	}
			        	else {
			        		missCount++; 
			        		Line line = new Line(value, true); 
			        		cache[key].lines.enqueue(line);
			        	}
		        	}
		        	
		        }
	        }
	    } while(input != -1); 
	    
		System.out.println("---------------------------------------------");
		System.out.println("Terminating program. ");
	    System.out.println(totalReads + " is the total number of reads. ");
		System.out.println(hitCount + " is the total hits. ");
		System.out.println(missCount + " is the total misses. ");
		hitRatio = (double)hitCount/(double)totalReads; 
		System.out.println(hitRatio+ " is the hit ratio. ");
		System.out.println("---------------------------------------------");
		
		for(int i = 0; i < cache.length; i++)
		{
			if(cache[i]!= null) 
			{
				System.out.println("Block " + i + " is not null. ");
				cache[i].printOut();
			}
			else {
				System.out.println("Block " + i + " is null. ");
			}
			System.out.println("---------------------------------------------");
		} 
	    scanner.close();
	}
}