package uk.zectech.fizzbuzz.step3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.whenNew;

import java.util.Map;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

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
	 * Show that attempting to get a stream with the minimum value of zero produces
	 * an error.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void shouldFailToGetStreamWhenMinimumValueIsZero() {
		new FizzBuzzOutputGenerator().getFizzBuzzStream(0, 99);
	}

	/**
	 * Show that attempting to get a stream with the minimum value less than zero
	 * produces an error.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void shouldFailToGetStreamWhenMinimumValueLessThanZero() {
		new FizzBuzzOutputGenerator().getFizzBuzzStream(-1, 99);
	}

	/**
	 * Show that attempting to get a stream with the minimum value greater than the
	 * maximum produces an error.
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
	 * Show that the FizzBuzzDelegate is called appropriately when processing valid
	 * number values.
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

	/**
	 * Show that the run statistics are compiled correctly.
	 */
	@Test
	public void shouldCorrectlyCompileRunStatistics() {
		when(fizzBuzzDelegate.getType(anyInt())).thenReturn(FizzBuzzEnum.LUCKY);

		FizzBuzzOutputGenerator fizzBuzzOutputGenerator = new FizzBuzzOutputGenerator();
		Stream<String> stream = fizzBuzzOutputGenerator.getFizzBuzzStream(1, 100);

		assertNotNull(stream);

		stream.forEach(System.out::print);

		Map<FizzBuzzEnum, Integer> runStatistics = fizzBuzzOutputGenerator.getRunStatistics();

		assertNull(runStatistics.get(FizzBuzzEnum.FIZZ));
		assertNull(runStatistics.get(FizzBuzzEnum.BUZZ));
		assertNull(runStatistics.get(FizzBuzzEnum.FIZZBUZZ));
		assertEquals(runStatistics.get(FizzBuzzEnum.LUCKY), Integer.valueOf(100));
		assertNull(runStatistics.get(FizzBuzzEnum.UNKNOWN));
	}

}
