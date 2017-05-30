package Solutions;

import java.util.HashSet;
import java.util.Set;

public class StringAlgos
{
	/**
	 * My fast implementation of a String Permutation generator.
	 * 
	 * @param s the given String from which we want to generate all permutations
	 * @return a Set of all permutations of the given String s.
	 */
	public static Set<String> permutation( String s )
	{
		Set<String> perms = new HashSet<String>();
		perms.add(s);
		permHelper( perms, s, 0 );
		
		return perms;
	}
	
	/**
	 * A fast, memory efficient, recursive String Permutation helper I figured out. 
	 * Given the current String permutation and the starting integer, the permutation 
	 * method swaps all characters after the given "start" int position.
	 * 
	 * @param set The Set&ltString&gt to hold all String permutations
	 * @param s The current String permutation we are mutating using character swaps.
	 * @param start the integer position denoting all characters we may mutate afterwards.
	 * @param end the end scope of the current Stirng permutation.
	 */
	private static void permHelper( Set<String> set, String s, int start )
	{
		if( start < s.length() )
			permHelper( set, s, start+1 );
		
		for( int i = start+1; i < s.length(); ++i )
		{
			char[] c = s.toCharArray();
			swap(c, start, i);
			
			String s2 = new String(c);
			set.add(s2);
			permHelper( set, s2, start+1 );
		}
	}
	
	/**
	 * Permutation Solution found on Princeton to compare answers in TDD Unit Testing.
	 * 
	 * @param s the given String from which we want to generate all permutations
	 * @return a Set of all permutations of the given String s.
	 */
	public static Set<String> permutationSoln(String s)
	{
		Set<String> perms = new HashSet<String>();
		permSolnHelper(perms, "", s);
		
		return perms;
	}
	
    private static void permSolnHelper(Set<String> perms, String prefix, String s)
    {
    	int n = s.length();
    	if( n == 0 ) perms.add(prefix);
    	else
    	{
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