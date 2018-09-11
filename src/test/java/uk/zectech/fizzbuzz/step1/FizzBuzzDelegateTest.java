package uk.zectech.fizzbuzz.step1;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import uk.zectech.fizzbuzz.step1.FizzBuzzDelegate;
import uk.zectech.fizzbuzz.step1.FizzBuzzEnum;

/**
 * Test cases for the FizzBuzzDelegate class.
 * 
 * @author Michael Conway
 *
 */
public class FizzBuzzDelegateTest {

	/** Value that return Fizz. */
	private final static int[] FIZZ_VALUES = { 3, 6, 9, 27 };

	/** Value that return Buzz. */
	private static int[] BUZZ_VALUES = { 5, 10, 40, 100 };

	/** Value that return FizzBuzz. */
	private static int[] FIZZBUZZ_VALUES = { 15, 30, 60, 90 };

	/** Value that return Unknown. */
	private static int[] UNKNOWN_VALUES = { 1, 7, 13, 22 };

	/**
	 * Show that a FIZZ number returns the correct enumeration.
	 */
	@Test
	public void shouldReturnFizzEnumForFizzNumber() {
		FizzBuzzDelegate fizzBuzzDelegate = new FizzBuzzDelegate();
		for (int number : FIZZ_VALUES) {
			assertTrue("FIZZ number should return FIZZ enumeration",
					fizzBuzzDelegate.getType(number) == FizzBuzzEnum.FIZZ);
		}
	}

	/**
	 * Show that a BUZZ number returns the correct enumeration.
	 */
	@Test
	public void shouldReturnBuzzEnumForBuzzNumber() {
		FizzBuzzDelegate fizzBuzzDelegate = new FizzBuzzDelegate();
		for (int number : BUZZ_VALUES) {
			assertTrue("BUZZ number should return BUZZ enumeration",
					fizzBuzzDelegate.getType(number) == FizzBuzzEnum.BUZZ);
		}
	}

	/**
	 * Show that a FIZZBUZZ number returns the correct enumeration.
	 */
	@Test
	public void shouldReturnFizzBuzzEnumForFizzBuzzNumber() {
		FizzBuzzDelegate fizzBuzzDelegate = new FizzBuzzDelegate();
		for (int number : FIZZBUZZ_VALUES) {
			assertTrue("FIZZBUZZ number should return FIZZBUZZ enumeration",
					fizzBuzzDelegate.getType(number) == FizzBuzzEnum.FIZZBUZZ);
		}
	}

	/**
	 * Show that a FIZZBUZZ number returns the correct enumeration.
	 */
	@Test
	public void shouldReturnUnknownEnumForUnknownNumber() {
		FizzBuzzDelegate fizzBuzzDelegate = new FizzBuzzDelegate();
		for (int number : UNKNOWN_VALUES) {
			assertTrue("UNKNOWN number should return UNKNOWN enumeration",
					fizzBuzzDelegate.getType(number) == FizzBuzzEnum.UNKNOWN);
		}
	}

}
