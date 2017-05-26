package Math;

import Classes.Measurable;

public final class MathUtils
{
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