package cache;

public class Node 
{
	Line line; 
	Node next; 
	
	Node(Line line, Node next)
	{
		this.line = line; 
		this.next = next; 
	}
}
