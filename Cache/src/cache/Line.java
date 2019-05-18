package cache;
public class Line
{
  int value;
  boolean valid;

  Line(int value, boolean valid)
  {
    this.value = value;
    this.valid = valid;
  }

  //getters and setters
  int getValue()
  {
    return this.value;
  }
  boolean getValid()
  {
    return this.valid;
  }
  
  public String toString() 
  {
	  return value + " " + valid;  
  }
}
