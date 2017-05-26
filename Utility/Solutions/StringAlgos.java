package Solutions;

public class StringAlgos
{
	public static boolean isPalinIter( String s )
	{
		if( s == null )
			return false;
		else if( s.length() <= 1 )
			return true;
		
		int mid = s.length(), j = s.length()-1;
		for( int i = 0; i < mid; ++i, --j )
		{
			if( s.charAt(i) != s.charAt(j) )
				return false;
		}
		
		return true;
	}
	
	public static boolean isPalinRecurse( String s )
	{
		if( s == null )
			return false;
		
		char[] c = s.toCharArray();
		
		return palinHelper( c, 0, c.length-1);
	}
	
	private static boolean palinHelper( char[] c, int start, int end )
	{
		if( c.length <= 1 )
			return true;
		
		return (c[start] == c[end]) && palinHelper(c, start+1, end-1);
	}
}