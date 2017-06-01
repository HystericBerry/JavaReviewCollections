package Solutions;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class PrimeThread implements Runnable
{
	public static int UPPERBOUND = 5000;
	public PrimeThread( ConcurrentLinkedQueue<Integer> cache, AtomicInteger shared, int id )
	{
		this.mCounter = shared;
		this.mId = id;
		this.primes = cache;
	}
	
	public void run()
	{
		int currInt;
		while( (currInt = this.mCounter.incrementAndGet()) < UPPERBOUND )
		{
			if( isPrime(currInt) )
			synchronized( this )
			{
				this.primes.add(currInt);
			}
		}
//			System.out.printf("Thread<%d>: %d is prime? %b\n", this.mId, currInt, isPrime(currInt) );
	}
	
	private boolean isPrime( int n )
	{
		for( int i = 2; i < n; ++i )
		{
			if( n%i == 0 )
				return false;
		}
		
		return true;
	}
	
	private int mId;
	private AtomicInteger mCounter;
	private ConcurrentLinkedQueue<Integer> primes;
}