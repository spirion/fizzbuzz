package uk.zectech.fizzbuzz.step1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import uk.zectech.fizzbuzz.step1.FizzBuzzEnum;

/**
 * Test cases for the FizzBuzzEnum class.
 * 
 * @author Michael Conway
 *
 */
public class FizzBuzzEnumTest {

	/** Label for FIZZ. */
	private static final Object FIZZ_LABEL = "fizz";

	/** Label for BUZZ. */
	private static final Object BUZZ_LABEL = "buzz";

	/** Label for FIZZBUZZ. */
	private static final Object FIZZBUZZ_LABEL = "fizzbuzz";

	/** Label for UNKNOWN. */
	private static final Object UNKNOWN_LABEL = "Unknown";

	/**
	 * Show that the enumerated value for FIZZ reports the correct value.
	 */
	@Test
	public void shouldCorrectlyReportFizzLabel() {
		assertEquals("FIZZ should return the correct lable", FIZZ_LABEL, FizzBuzzEnum.FIZZ.getLabel());
	}

	/**
	 * Show that the enumerated value for BUZZ reports the correct value.
	 */
	@Test
	public void shouldCorrectlyReportBuzzLabel() {
		assertEquals("BUZZ should return the correct lable", BUZZ_LABEL, FizzBuzzEnum.BUZZ.getLabel());
	}

	/**
	 * Show that the enumerated value for FIZZBUZZ reports the correct value.
	 */
	@Test
	public void shouldCorrectlyReportFizzBuzzLabel() {
		assertEquals("FIZZBUZZ should return the correct lable", FIZZBUZZ_LABEL, FizzBuzzEnum.FIZZBUZZ.getLabel());
	}

	/**
	 * Show that the enumerated value for FIZZBUZZ reports the correct value.
	 */
	@Test
	public void shouldCorrectlyReportUnknownLabel() {
		assertEquals("UNKNOWN should return the correct lable", UNKNOWN_LABEL, FizzBuzzEnum.UNKNOWN.getLabel());
	}

}
