package uk.zectech.fizzbuzz.step3;

import java.util.Map;

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
        final FizzBuzzOutputGenerator fizzBuzzOutputGenerator = new FizzBuzzOutputGenerator();
        fizzBuzzOutputGenerator.getFizzBuzzStream(1, 20).forEach(System.out::print);
        System.out.println();
        Map<FizzBuzzEnum, Integer> runStatistics = fizzBuzzOutputGenerator.getRunStatistics();
        for (FizzBuzzEnum fizzBuzzEnum : runStatistics.keySet()) {
            System.out.println(fizzBuzzEnum.getLabel() + ": " + runStatistics.get(fizzBuzzEnum));
        }
    }
	
}
