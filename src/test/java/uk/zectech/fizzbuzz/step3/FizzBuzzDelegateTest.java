package uk.zectech.fizzbuzz.step3;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Test cases for the FizzBuzzDelegate class.
 * 
 * @author Michael Conway
 *
 */
public class FizzBuzzDelegateTest {

	/** Value that return Fizz. */
	private final static int[] FIZZ_VALUES = { 6, 9, 12, 27 };

	/** Value that return Buzz. */
	private static int[] BUZZ_VALUES = { 5, 10, 40, 100 };

	/** Value that return FizzBuzz. */
	private static int[] FIZZBUZZ_VALUES = { 15, 60, 75, 90 };

	/** Value that return Unknown. */
	private static int[] UNKNOWN_VALUES = { 1, 7, 14, 22 };

	/** Value that return Lucky. */
	private static int[] LUCKY_VALUES = { 3, 13, 23, 31, 34, 37 };

	/** Value that return Lucky. */
	private static int[] LUCKY_OVERRIDE_VALUES = { 3, 30, 33, 35, 93 };

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

	/**
	 * Show that a LUCKY number returns the correct enumeration.
	 */
	@Test
	public void shouldReturnUnknownEnumForLuckyNumber() {
		FizzBuzzDelegate fizzBuzzDelegate = new FizzBuzzDelegate();
		for (int number : LUCKY_VALUES) {
			assertTrue("LUCKY number should return LUCKY enumeration",
					fizzBuzzDelegate.getType(number) == FizzBuzzEnum.LUCKY);
		}
	}

	/**
	 * Show that a LUCKY number returns the correct enumeration overriding all other
	 * number types.
	 */
	@Test
	public void shouldOverideAllOtherTypesIfLuckyNumber() {
		FizzBuzzDelegate fizzBuzzDelegate = new FizzBuzzDelegate();
		for (int number : LUCKY_OVERRIDE_VALUES) {
			assertTrue("LUCKY number should override all other types with  LUCKY enumeration",
					fizzBuzzDelegate.getType(number) == FizzBuzzEnum.LUCKY);
		}
	}

}
