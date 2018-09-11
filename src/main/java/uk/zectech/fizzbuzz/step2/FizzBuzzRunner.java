package uk.zectech.fizzbuzz.step2;

/**
 * Run the fizz buzz process against a number range.
 * 
 * @author Michael Conway
 * @version 1.0
 *
 */
public class FizzBuzzRunner {

	/**
	 * Run fizz buzz and produce the output. Hard coded number range for
	 * convenience.
	 * 
	 * @param args
	 *            The arguments
	 */
	public static void main(final String[] args) {
		new FizzBuzzOutputGenerator().getFizzBuzzStream(1, 100).forEach(System.out::print);
	}

}
