package ProblemInterfaces;

import Collections.MutableEntry;

public class BlackWhiteTiles
{
	public static MutableEntry naiveImpl( int TOTAL_WIDTH, int TILE_WIDTH )
	{
		MutableEntry naive = new MutableEntry( 0, 0 );
		
		if( TOTAL_WIDTH < TILE_WIDTH )
			return naive;
		
		int quotient = (int) (TOTAL_WIDTH / TILE_WIDTH);
		if( quotient % 2 == 0 )
			--quotient;
		
		int numWhite = quotient / 2;
		int numBlack = numWhite + 1;
		
		naive.setKey(numBlack);
		naive.setValue(numWhite);
		
		return naive;
	}
	
	public static MutableEntry iterativeImpl( int TOTAL_WIDTH, int TILE_WIDTH )
	{
		MutableEntry iter = new MutableEntry( 0, 0 );
		int currWidth = 0;
		
		if( TOTAL_WIDTH > TILE_WIDTH )
		{
			currWidth += TILE_WIDTH;
			iter.setKey(iter.getKey()+1);
		}
		else
			return iter;
		
		while( currWidth < TOTAL_WIDTH )
		{
			int nextWidth = currWidth+(2*TILE_WIDTH);
			if( TOTAL_WIDTH > nextWidth )
			{
				currWidth = nextWidth;
				iter.setKey(iter.getKey()+1);
				iter.setValue(iter.getValue()+1);
			}
			else
				break;
		}
		
		return iter;
	}
	
	public static MutableEntry recursiveImpl( int totalWidth, int width )
	{
		MutableEntry recursive = new MutableEntry( 0, 0 );
		recursive = recursiveImpl( totalWidth, width, recursive );
		
		return recursive;
	}
	
	private static MutableEntry recursiveImpl( int totalWidth, int width, MutableEntry recursive )
	{
		if( recursive.getKey() == 0 && width < totalWidth ) // Beginning case
			recursive.setKey(recursive.getKey() + 1);
		
		int nextWidth = (width*recursive.getKey()) + (width*recursive.getValue()) + (2*width);
		if( nextWidth < totalWidth )
		{
			recursive.setKey(recursive.getKey() + 1);
			recursive.setValue(recursive.getValue() + 1);
			recursiveImpl( totalWidth, width, recursive );
		}
		
		return recursive;
	}
}