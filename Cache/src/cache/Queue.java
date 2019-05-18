package cache;

public class Queue <T>
{
	//need this class to act as lru, if full. 
	
	//enqueue, dequeue
	
	//using what, ll? 
	
	//t is going to be line, not block? 
	
	//Queue of lines.
	
	Node front; 
	Node end; 
	int size; 
	
	Queue()
	{
		size = 0; 
	}
	
	public void enqueue(Line line)
	{
		Node node = new Node(line, null); 
		
		if(end == null)
		{
			//this means that the whole queue is empty. 
			
			end = node; 
			front = node; 
		}
		else {
			end.next = node; 
			end = node; 
		}
		size++; 
		
	}
	
	public Line dequeue()
	{
		if(front == null)
		{
			throw new IllegalArgumentException("Queue is empty, therefore cant take out anything. "); 
		}
		
		Line item = front.line; 
		front = front.next;
		
		size--; 
		
		if(front == null)
		{
			end = null;
		}
		return item; 
	}
	
	public int getSize() 
	{
		return 0; 
	}
	
}
