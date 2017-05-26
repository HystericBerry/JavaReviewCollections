package Classes;

import java.awt.Rectangle;

public class CallbackExample
{
	public static class RectMeasurer implements Measurable
	{
		/**
		 * The method measure that resides in the User created RectangleMeasurer 
		 * acts as the callback. It lets the user define a specific method for 
		 * the interface measure on a Class that cannot be changed (Rectangle).
		 * Later, another method, we can pass in the Callback Object RectangleMeasurer 
		 * and use its implemented methods.
		 */
		@Override
		public double measure(Object obj)
		{
			Rectangle rect = (Rectangle) obj;
			double area = rect.getWidth() * rect.getHeight();
			return area;
		}
	}
	
	public static class IntegerMeasurer implements Measurable
	{
		@Override
		public double measure(Object obj)
		{
			Integer i = (Integer) obj;
			return i;
		}
	}
}