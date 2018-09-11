package uk.zectech.fizzbuzz.step2;

/**
 * Enumeration used to signal fizz, buzz or unknown. Uses an immutable label to
 * assist in text value production.
 * 
 * @author Michael Conway
 * @version 1.0
 *
 */
public enum FizzBuzzEnum {

    /** Unknown type. */
    UNKNOWN("Unknown"),

    /** Fizz type. */
    FIZZ("fizz"),

    /** Buzz type. */
    BUZZ("buzz"),

    /** Both fizz and buss type. */
    FIZZBUZZ("fizzbuzz"),
    
    /** Lucky number type. */
    LUCKY("lucky");

    /** The label associated with the enumerated value. */
    final private String label;

    /**
     * Construct enumerated vaule utilising the associated label.
     * 
     * @param label
     *            The label
     */
    private FizzBuzzEnum(final String label) {
        this.label = label;
    }

    /**
     * Get the text label value.
     * 
     * @return The string label associated with the enumerated value
     */
    public String getLabel() {
        return this.label;
    }
	
}
