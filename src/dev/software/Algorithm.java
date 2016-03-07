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
