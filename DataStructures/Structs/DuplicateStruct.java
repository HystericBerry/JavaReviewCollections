package Structs;

public class DuplicateStruct
{
	public static class Parent
	{
		public Parent( String text )
		{
			msg = text;
		}
		
		@Override
		public String toString()
		{
			return msg;
		}
		
		private String msg;
	}
	
	public static class Child extends Parent
	{
		public Child(String text)
		{
			super("Child Instance: "+text);
		}
		
		/**
		 * 
		 */
		@Override
		public String toString()
		{
			return msg;
		}
		
		// this variable will be set by the constructor
		private String msg;
	}
}