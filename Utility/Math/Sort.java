package Math;

import java.util.List;

public class Sort
{
	/**
	 * Given an int array, the method sorts the array in O(N^2) time using
	 * the insertion sort algorithm.
	 * 
	 * The <strong>Selection Sort</strong> algorithm maintains a sorted list and 
	 * an unsorted list. Every adjacent element in the unsorted list is "added" 
	 * to the sorted list from one end and percolated to the other end if it out 
	 * of order. The newly added element that is out of order is swapped until 
	 * it is in its right place with respect to the sorted list's scope.
	 * 
	 * With the first element "continue" optimization, this algorithm performs 
	 * o(N): when the list is already sorted.
	 * 
	 * @param arr the given List of elements to sort.
	 */
	public static void insertionSort( List<Integer> arr )
	{
		if( arr == null )
			throw new NullPointerException("Cannot sort a null array");
		// lists are already sorted for lists of size 0 or 1
		if( arr.size() < 2 )
			return;
		
		// start at i = 1 to indicate a list of size 1 is already sorted.
		for( int i = 1; i < arr.size(); ++i )
		{
			int j = i;
			// if the next, first element of a loop iteration is larger, 
			// it is currently in its right place
			if( arr.get(j-1) < arr.get(j) )
				continue;
			
			// while the newly added element is out of order:
			while( j > 0 && arr.get(j-1) > arr.get(j) )
			{
				// swap if the elements are out of order
				MathUtils.swap( arr, j-1, j );
				--j;
			}
		}
	}
	
	/**
	 * Selection Sort actively looks for the next element in order... it's terrible. 
	 * Why? Because there is no way to remember what you've looked at already. Therefore, 
	 * for every iteration (when looking for the next smallest element), you need to 
	 * traverse what is left in the array. This means that it will <strong>always</strong> 
	 * perform N^2. Specifically, it will perform exactly: Summation( N ) | range N to 0 or 
	 * N(N-1)/2
	 * 
	 * @param arr the given List of elements to sort.
	 */
	public static void selectionSort( List<Integer> arr )
	{
		if( arr == null )
			throw new NullPointerException("Cannot sort a null array");
		// lists are already sorted for lists of size 0 or 1
		if( arr.size() < 2 )
			return;
		
		// by the time you have reached target position = arr.size()-1, the last element 
		// is already in the right place.
		for( int target = 0; target < arr.size()-1; ++target ) //
		{
			int pos = target; // track the minimum and its position.
			int min = MathUtils.seekMin( arr, pos );
			
			MathUtils.swap( arr, target, min );
		}
	}
	
	/**
	 * The <strong>Bubble Sort</strong> is a algorithm that naturally percolates the 
	 * largest values to one end. This implies that after every iteration, the sorted 
	 * list is always on the other end of the loop's/ comparison's (unsorted) starting 
	 * end. The <strong>Bubble Sort</strong> algorithm always swaps elements that are 
	 * out of order, naturally picking up the largest value in the unsorted list and 
	 * percolating it towards the sorted list. With the shrinking unsorted list 
	 * optimization, we are guaranteed that in its worst case, <strong>Bubble Sort
	 * </strong> will perform O(N^2) - specifically N(N-1)/2 like selection sort - 
	 * rather than an exact N^2.
	 * 
	 * @param arr the given List of elements to sort.
	 */
	public static void bubbleSort( List<Integer> arr )
	{
		if( arr == null )
			throw new NullPointerException("Cannot sort a null array");
		// lists are already sorted for lists of size 0 or 1
		if( arr.size() < 2 )
			return;
		
		// shrinking optimization that reduced an exact O(N^2) to O( N(N-1)/2 )
		for( int i = arr.size()-1; i > 0; --i )
		{
			boolean swapped = false;
			for( int j = 0; j < i; ++j )
			{
				if( arr.get(j) > arr.get(j+1) )
				{
					swapped = true;
					MathUtils.swap( arr, j, j+1 );
				}
			}
			
			// no longer need to swap if the list is already sorted.
			if (!swapped ) break;
		}
	}
	
	public static void quickSort( List<Integer> arr )
	{
		if( arr == null )
			throw new NullPointerException("Cannot sort a null array");
		// lists are already sorted for lists of size 0 or 1
		if( arr.size() < 2 )
			return;
		
		// TODO implement this later
	}
}