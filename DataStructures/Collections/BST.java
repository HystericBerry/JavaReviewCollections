package Collections;

public class BST<T extends Comparable<T>>
{
	public BST() {}
	
	private BST( T val )
	{
		this.mRoot = val;
	}
	
	public boolean add( T val )
	{
		BST<T> curr = this;
		if( mRoot == null )
		{
			mRoot = val;
			return true;
		}
		
		while( true )
		{
			if( val.compareTo(curr.mRoot) < 0 )
			{
				if( curr.mLeft == null )
					curr.mLeft = new BST<T>( val );
				else
					curr = curr.mLeft;
			}
			else if( val.compareTo(curr.mRoot) > 0 )
			{
				if( curr.mRight == null )
					curr.mRight = new BST<T>( val );
				else
					curr = curr.mRight;
			}
			// cannot add duplicate elements for this BST
			else return false;
		}
	}
	
	public boolean contains( T val )
	{
		BST<T> curr = this;
		while( true )
		{
			if( val.compareTo(curr.mRoot) < 0 )
			{
				if( curr.mLeft == null ) break;
				else curr = curr.mLeft;
			}
			else if( val.compareTo(curr.mRoot) > 0 )
			{
				if( curr.mRight == null ) break;
				else curr = curr.mRight;
			}
			// cannot add duplicate elements for this BST
			else return true;
		}
		
		return false;
	}
	
	public void inorder( SingleyList<T> lst, BST<T> curr )
	{
		if( curr == null )
			return;
		if( lst == null || curr.mRoot == null )
			return;
		
		inorder( lst, curr.mLeft );
		lst.add( curr.mRoot );
		inorder( lst, curr.mRight );
	}
	
	private T mRoot;
	private BST<T> mLeft, mRight;
}