package Solutions;

import java.util.HashSet;
import java.util.Set;

public class StringAlgos
{
	/**
	 * My fast implementation of Permutation generator
	 * 
	 * @param s
	 * @return
	 */
	public static Set<String> permutation( String s )
	{
		Set<String> perms = new HashSet<String>();
		perms.add(s);
		permHelper( perms, s, 0, s.length() );
		
		return perms;
	}
	
	/**
	 * 
	 * @param set
	 * @param s
	 * @param start
	 * @param end
	 */
	private static void permHelper( Set<String> set, String s, int start, int end )
	{
		if( start >= end ) return;
		
		for( int i = start+1; i < end; ++i )
		{
			char[] c = s.toCharArray();
			swap(c, start, i);
			
			String s2 = new String(c);
			set.add(s2);
			permHelper( set, s2, start+1, end );
		}
		
		permHelper( set, s, start+1, end );
	}
	
	/**
	 * Permutation Solution found on Princeton to compare answers in TDD Unit Testing.
	 * 
	 * @param s
	 * @return
	 */
	public  static Set<String> permutationSoln(String s)
	{
		Set<String> perms = new HashSet<String>();
		permSolnHelper(perms, "", s);
		
		return perms;
	}
    private static void permSolnHelper(Set<String> perms, String prefix, String s) {
        int n = s.length();
        if( n == 0 ) perms.add(prefix);
        else {
            for (int i = 0; i < n; i++)
            	permSolnHelper(perms, prefix + s.charAt(i), s.substring(0, i) + s.substring(i+1, n));
        }

    }
	
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
	
	private static void swap( char[] c, int a, int b )
	{
		char temp = c[a]; // store a
		c[a] = c[b]; // overwrite a with b
		c[b] = temp; // overwrite b with temp
	}
}