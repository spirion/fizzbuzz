package uk.zectech.fizzbuzz.step1;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.whenNew;

import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import uk.zectech.fizzbuzz.step1.FizzBuzzDelegate;
import uk.zectech.fizzbuzz.step1.FizzBuzzEnum;
import uk.zectech.fizzbuzz.step1.FizzBuzzOutputGenerator;

/**
 * Test cases for the FizzBuzzOutputGenerator class.
 * 
 * @author Michael Conway
 *
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(FizzBuzzOutputGenerator.class)
public class FizzBuzzOutputGeneratorTest {

    /**
     * Mocked fizz buzz delegate instance.
     */
    private FizzBuzzDelegate fizzBuzzDelegate;

    /**
     * Initiate the mocked collaborators.
     * 
     * @throws Exception
     */
    @Before
    public void initializeFizzBuzzOutputGeneratorMocks() throws Exception {
        fizzBuzzDelegate = mock(FizzBuzzDelegate.class);
        whenNew(FizzBuzzDelegate.class).withNoArguments().thenReturn(fizzBuzzDelegate);
    }

    /**
     * Show that attempting to get a stream with the minimum value of zero
     * produces an error.
     */
    @Test(expected = IllegalArgumentException.class)
    public void shouldFailToGetStreamWhenMinimumValueIsZero() {
        new FizzBuzzOutputGenerator().getFizzBuzzStream(0, 99);
    }

    /**
     * Show that attempting to get a stream with the minimum value less than
     * zero produces an error.
     */
    @Test(expected = IllegalArgumentException.class)
    public void shouldFailToGetStreamWhenMinimumValueLessThanZero() {
        new FizzBuzzOutputGenerator().getFizzBuzzStream(-1, 99);
    }

    /**
     * Show that attempting to get a stream with the minimum value greater than
     * the maximum produces an error.
     */
    @Test(expected = IllegalArgumentException.class)
    public void shouldFailToGetStreamWhenMinimumValueGreaterThanMaximumValue() {
        new FizzBuzzOutputGenerator().getFizzBuzzStream(99, 98);
    }

    /**
     * Show that a correctly requested stream returns a value without causing an
     * IllegalArgumentException.
     */
    @Test
    public void shouldCorrectlyGetStreamWhenValuesAreValid() {
        Stream<String> stream = new FizzBuzzOutputGenerator().getFizzBuzzStream(1, 100);

        assertNotNull(stream);

        verifyZeroInteractions(fizzBuzzDelegate);
    }

    /**
     * Show that the FizzBuzzDelegate is called appropriately when processing
     * valid number values.
     */
    @Test
    public void shouldCallTheFizzBuzzDelegateAppropriatelyWhenProcessingStream() {
        when(fizzBuzzDelegate.getType(anyInt())).thenReturn(FizzBuzzEnum.UNKNOWN);

        Stream<String> stream = new FizzBuzzOutputGenerator().getFizzBuzzStream(1, 100);

        assertNotNull(stream);

        stream.forEach(System.out::print);

        verify(fizzBuzzDelegate, times(100)).getType(anyInt());
        for (int index = 1; index > 100; index++) {
            verify(fizzBuzzDelegate, times(1)).getType(index);
        }
        verifyNoMoreInteractions(fizzBuzzDelegate);
    }
	
}
