package Collections;

import java.util.Iterator;

/**
 * This class represents an Entry
 * 
 * @author pkim7
 */
public class IEntry<T> implements Iterator<IEntry<T>>
{
	public IEntry( T value )
	{
		this.mValue = value;
	}
	
	public T getValue()
	{
		return mValue;
	}
	
	public void setNext( IEntry<T> e )
	{
		mNext = e;
	}
	
	@Override
	public IEntry<T> next()
	{
		return mNext;
	}

	@Override
	public boolean hasNext()
	{
		return mNext != null;
	}
	
	private T mValue;
	private IEntry<T> mNext;
}