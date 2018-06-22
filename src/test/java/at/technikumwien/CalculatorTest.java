package at.technikumwien;

import org.junit.Before;

import at.technikumwien.Calculator;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {
	private Calculator calculator;
	
	@Before
	public void setUp() {
		calculator = new Calculator();		
	}

	private Calculator calc;

	@Before
	public void setup() {
		this.calc = new Calculator();
	}

	@Test
	public void testSumWith1Parameter() {
		assertEquals(10,calc.sum(10));
	}

	@Test
	public void testSumWithNoParameters() {
		assertEquals(0,calc.sum());
	}

	@Test
	public void testSumWithNull() {
		assertEquals(0,calc.sum(null));
	}
}