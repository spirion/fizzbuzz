package uk.zectech.fizzbuzz.step1;

/**
 * Bean used to decide on fizziness, buzziness or otherwise of a number.
 * 
 * Note : I considered using a singleton here but decided against it this time.
 * Static methods can be troublesome when mocking in junit tests as I decided to
 * keep it simple.
 * 
 * @author Michael Conway
 * @version 1.0
 *
 */
public class FizzBuzzDelegate {

	/** Value divider for Fizz. */
	private final static int FIZZ_VALUE = 3;

	/** Value divider for Buzz. */
	private static int BUZZ_VALUE = 5;

	/**
	 * Get the enumerated type associated with the passed integer.
	 * 
	 * @param num
	 *            The integer to inspect
	 * @return The enumerated type
	 */
	public FizzBuzzEnum getType(int num) {
		boolean isFizz = this.isFizz(num);
		boolean isBuzz = this.isBuzz(num);
		FizzBuzzEnum fizzBuzzEnum = FizzBuzzEnum.UNKNOWN;
		if (isFizz && isBuzz) {
			fizzBuzzEnum = FizzBuzzEnum.FIZZBUZZ;
		} else if (isFizz) {
			fizzBuzzEnum = FizzBuzzEnum.FIZZ;
		} else if (isBuzz) {
			fizzBuzzEnum = FizzBuzzEnum.BUZZ;
		}
		return fizzBuzzEnum;
	}

	/**
	 * Is the passed integer fizz.
	 * 
	 * @param num
	 *            The integer
	 * @return True if fizz, otherwise false
	 */
	private boolean isFizz(int num) {
		return num % FIZZ_VALUE == 0;
	}

	/**
	 * Is the passed integer Buzz.
	 * 
	 * @param num
	 *            The integer
	 * @return True if buzz, otherwise false
	 */
	private boolean isBuzz(int num) {
		return num % BUZZ_VALUE == 0;
	}

}
