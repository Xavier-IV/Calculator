package dev.software;

import java.util.Scanner;

public class Main {

	public String inputExpression;
	public float[] operands = new float[10];
	public char[] operator = new char[10];
	
	private String[] splitArray = new String[3];
	
	
	public String[] extractionPoint(String inputString) {
		// This method extract operands and operator from a String
		splitArray = inputString.split(" ");
		
		return splitArray;
	}
	
	public float[] getOperands(String inputString) {
		try {
			operands[0] = Float.parseFloat(splitArray[0]);
			operands[1] = Float.parseFloat(splitArray[1]);
		}catch(NullPointerException a) {
			System.out.println(a);
		}
		
		return operands;
	}
	
	public void showData() {
		// This method prints the data in an appropriate manner
	}

	@SuppressWarnings("resource")
	public String getData() {
		// This method gets input from user, and store it into inputExpression variable.
		Scanner input = new Scanner(System.in);
		
		// Keep asking user for input if inputExpression isEmpty()
		do {
			System.out.println("Please enter a mathematical expression, with postfix");
			
			inputExpression = input.nextLine();
		}while(inputExpression.isEmpty());
		
		return inputExpression;
	}
	
	public static void main(String[] args) {
		// Created an object
		Main object = new Main();
		
		object.getData();
		object.extractionPoint(object.inputExpression);
		object.getOperands(object.inputExpression);

		System.out.println(object.operands[0]+" & "+object.operands[1]);

	}

}
