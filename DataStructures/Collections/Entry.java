package Collections;

/**
 * This class represents a Mutable Pair
 * 
 * @author pkim7
 */
public class Entry
{
	public Entry() {}
	
	public Entry( Integer key, Integer value )
	{
		this.mKey = key;
		this.mValue = value;
	}
	
	public Integer getKey()
	{
		return this.mKey;
	}
	
	public void setKey( Integer key )
	{
		this.mKey = key;
	}
	
	public Integer getValue()
	{
		return this.mValue;
	}
	
	public void setValue( Integer value )
	{
		this.mValue = value;
	}
	
	private Integer mKey, mValue;
}