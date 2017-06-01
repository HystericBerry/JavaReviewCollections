package Collections;

public class SingleyList <T>
{
	public SingleyList() {}
	
	public void add( T e )
	{
		if ( mHead == null )
		{
			mHead = new IEntry<T>( e );
			return;
		}
		
		IEntry<T> curr = mHead;
		while( curr.hasNext() )
			curr = curr.next();
		curr.setNext( new IEntry<T>( e ) );
	}
	
	public boolean remove( int pos )
	{
		if ( mHead == null )
			return false;
		
		if( pos == 0 )
		{
			IEntry<T> root = mHead;
			mHead = mHead.next();
			
			root.setNext( null ); // disconnect previous root
			return true;
		}
		
		int i;
		IEntry<T> curr = mHead, prev = curr;
		for( i = 0; i < pos; ++i )
		{
			prev = curr;
			if( curr == null ) return false;
			curr = curr.next();
		}
		
		prev.setNext( curr.next() );
		curr.setNext( null );
		
		return i == pos;
	}
	
	public boolean contains( T e )
	{
		if ( mHead == null )
			return false;
		
		IEntry<T> curr = mHead;
		while( curr.hasNext() )
		{
			if( curr.getValue().equals( e ) )
				return true;
			curr = curr.next();
		}
		
		return false;
	}
	
	public T get( int pos )
	{
		if( mHead == null )
			throw new NullPointerException("Cannot access element if list is empty.\n");
		
		int i;
		IEntry<T> curr = mHead;
		for( i = 0; i < pos; ++i)
		{
			if( curr.hasNext() )
				curr = curr.next();
			else
				break;
		}
		
		if( i == pos )
			return curr.getValue();
		
		throw new IndexOutOfBoundsException("Cannot access an element out of bounds.\n");
	}
	
	public int getSize()
	{
		if ( mHead == null )
			return 0;
		
		int i = 1;
		
		IEntry<T> curr = mHead;
		while( curr.hasNext() )
		{
			++i;
			curr = curr.next();
		}
		
		return i;
	}
	
	private IEntry<T> mHead;
}