package cache;
public class Block
{
  Queue<Line> lines; 

  Block()
  {
    lines = new Queue<Line>(); 
  }

  public void printOut()
  {
	  Node ptr = lines.front; 
	  while(ptr != null)
	  {
		  System.out.println(ptr.line);
		  ptr = ptr.next; 
	  }
  }
}