package ru.job4j.calculate;

/**
 * Calculator.
 * 
 * @author Maksym Mateiuk (maxymmateuk@gmail.com)
 */
public class Calculator {

	/**
	 * Add numbers.
	 * @param first double
	 * @param second double
	 * @return result
	 */
	public double add(double first, double second) {
		return first + second;
	}

	/**
	 * Substract numbers.
	 * @param first double
	 * @param second double
	 * @return result
	 */
	public double subsctract(double first, double second) {
		return first - second;
	}

	/**
	 * Multiple numbers.
	 * @param first double
	 * @param second double
	 * @return result
	 */
	public double multiple(double first, double second) {
		return first * second;
	}

	/**
	 * Divide numbers.
	 * @param first double
	 * @param second double
	 * @return result
	 */
	public double divide(double first, double second) {
		return first / second;
	}
	
}
