package uk.zectech.fizzbuzz.step3;

import java.util.HashMap;
import java.util.Map;
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

	/** Map of enum type to total output times. */
	private Map<FizzBuzzEnum, Integer> runStatistics = new HashMap<>();

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
	 * Get the run statistics for this instance.
	 * 
	 * @return The run statistics
	 */
	public Map<FizzBuzzEnum, Integer> getRunStatistics() {
		return this.runStatistics;
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
		this.updateStatistics(fizzBuzzEnum);
		final String output = fizzBuzzEnum == FizzBuzzEnum.UNKNOWN ? new Integer(num).toString()
				: fizzBuzzEnum.getLabel();
		return new StringBuilder(output).append(SINGLE_SPACE).toString();
	}

	/**
	 * Update the statistics map with a new output type.
	 * 
	 * @param fizzBuzzEnum
	 *            The enum being output
	 */
	private void updateStatistics(final FizzBuzzEnum fizzBuzzEnum) {
		final Integer currentValue = this.runStatistics.get(fizzBuzzEnum);
		if (currentValue == null) {
			this.runStatistics.put(fizzBuzzEnum, 1);
		} else {
			this.runStatistics.put(fizzBuzzEnum, currentValue + 1);
		}
	}

}
