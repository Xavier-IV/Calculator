/*
 * @Author Mohamad Zafranudin Zafrin @ Xavier-IV
 * @Copyright 2016 Calculator
 * 
 * This class is the algorithm class for the project.
 * 
 */

package dev.software;

public class Algorithm extends Main {

	
	public float operationCalculate(float[] operands, char[] operator) {
		switch(operator[0]) {
			case '+':
				result = operands[0] + operands[1];
				break;
			case '-':
				result = operands[0] - operands[1];
				break;
			case '*':
				result = operands[0] * operands[1];
				break;
			case '/':
				result = operands[0] / operands[1];
				break;
			default :
				System.out.println("Wrong operator or operands input!");
		}

		

		return result;
	}
}
