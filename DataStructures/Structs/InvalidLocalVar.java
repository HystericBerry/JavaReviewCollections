package Structs;

/**
 * This Class demonstrates the fact that the Java Language applies greater 
 * precedence to local variables over member variables that have the same name.
 * 
 * @author pkim7
 */
public class InvalidLocalVar
{
	@SuppressWarnings("all")
	public InvalidLocalVar( int invalid )
	{
		invalid = invalid;
	}
	
	public int invalid;
}