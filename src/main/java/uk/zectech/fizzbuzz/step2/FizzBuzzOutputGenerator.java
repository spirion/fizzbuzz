package uk.zectech.fizzbuzz.step2;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Provides the output stream for the minimum to maximum values for fizz bizz
 * generation.
 * 
 * Although not in the specification I though it wise to add some validation of
 * the output here.
 * 
 * @author Michael Conway
 * @version 1.0
 *
 */
public class FizzBuzzOutputGenerator {

	/** Single space constant. */
	private static final String SINGLE_SPACE = " ";

	/** String used when formatting an invalid range message. */
	private static final String INVALID_RANGE_SPECIFIED_FORMAT = "Invalid range specified : minimum %d, maximum %d";

	/** The delegate class which calculates fizz or buzz. */
	private final FizzBuzzDelegate fizzBuzzDelegate;

	/**
	 * Default constructor.
	 */
	public FizzBuzzOutputGenerator() {
		fizzBuzzDelegate = new FizzBuzzDelegate();
	}

	/**
	 * Provide a stream to process fizz buzz response output.
	 * 
	 * @param minimum
	 *            The minimum value
	 * @param maximum
	 *            The maximum value
	 * @return The stream
	 */
	public Stream<String> getFizzBuzzStream(int minimum, int maximum) {
		if (!isValidRange(minimum, maximum)) {
			throw new IllegalArgumentException(String.format(INVALID_RANGE_SPECIFIED_FORMAT, minimum, maximum));
		}
		return IntStream.rangeClosed(minimum, maximum).mapToObj(n -> this.getOutputValue(n));
	}

	/**
	 * Is the given number range valid. Must start with a non-zero positive number
	 * and minimum value must be less than or equal to the maximum value.
	 * 
	 * @param minimum
	 *            The minimum value
	 * @param maximum
	 *            The maximum value
	 * @return True if range is valid, otherwise false
	 */
	private boolean isValidRange(int minimum, int maximum) {
		return minimum > 0 && minimum <= maximum;
	}

	/**
	 * Get the output value associated with the input number.
	 * 
	 * @param num
	 *            The number
	 * @return The output string
	 */
	private String getOutputValue(int num) {
		final FizzBuzzEnum fizzBuzzEnum = fizzBuzzDelegate.getType(num);
		final String output = fizzBuzzEnum == FizzBuzzEnum.UNKNOWN ? new Integer(num).toString()
				: fizzBuzzEnum.getLabel();
		return new StringBuilder(output).append(SINGLE_SPACE).toString();
	}

}
