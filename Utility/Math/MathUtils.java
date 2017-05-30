package Math;

import java.util.List;

import Classes.Measurable;

public final class MathUtils
{
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void swap( List<?> lst, int pos1, int pos2 )
	{
		if( pos1 < 0 || pos2 < 0 || pos1 >= lst.size() || pos2 >= lst.size() )
			throw new IndexOutOfBoundsException("Cannot swap values that are out of bound.\n");
		
		List list = lst;
		Object temp = list.get(pos1);
		list.set(pos1, list.get(pos2));
		list.set(pos2, temp);
	}
	
	public static <T extends Comparable<T>> int seekMin( List<T> lst, int lower )
	{
		return MathUtils.seekMin( lst, lower, lst.size() );
	}
	
	public static <T extends Comparable<T>> int seekMin( List<T> lst, int lower, int upper )
	{
		if( lower < 0 || upper > lst.size() )
		{
			throw new IndexOutOfBoundsException("Cannot search for min elements that are out of bounds.\n");
		}
		
		int pos = lower;
		T min = lst.get(pos);
		for( int i = lower+1; i < upper; ++i )
		{
			// if the next position is less than the current min, update
			if( min.compareTo(lst.get(i)) > 0 )
			{
				pos = i;
				min = lst.get(i);
			}
		}
		
		return pos;
	}

	// Used to be Measurable[] arr before the callback
	public static double average( Object[] arr, Measurable meas )
	{
		double sum = 0;
		for( int i = 0; i < arr.length; ++i )
			sum += meas.measure( arr[i] );
		sum /= arr.length;
		return sum;
	}
}