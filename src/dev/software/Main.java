/*
 * @Author Mohamad Zafranudin Zafrin @ Xavier-IV
 * @Copyright 2016 Calculator
 * 
 * This is the Main class for the project.
 * 
 */

package dev.software;

import java.io.IOException;
import java.util.Scanner;
import dev.software.buffer.*;
public class Main {

	public String[] inputExpression = new String[10];
	public float[] operands = new float[10];
	public char[] operator = new char[10];
	public float result;
	public String _errorMessage;
	int noOfExpression = 0;

	public String[] splitArray = new String[3];
	public String[] splitArrayBuffer = null;
	private static Scanner input;
	private Scanner input2;
	

	
	public String[] extractionPoint(String inputString) {
		// This method extract operands and operator from a String
		splitArray = inputString.split("\\s");	//Space regex
		
		return splitArray;
	}
	
	public float[] getOperands(String inputString) {
		// This method extract the operands from the expression
		try {
			operands[0] = Float.parseFloat(splitArray[0]);
			operands[1] = Float.parseFloat(splitArray[1]);
		}catch(NullPointerException a) {
			System.out.println(a);
		}catch(NumberFormatException b) {
			System.out.println("Wrong operator format, should be floating number/integer.");
		}
		
		return operands;
	}
	
	public char[] getOperator(String inputString) {
		//This method extract the first operator from the expression
		operator = splitArray[2].toCharArray();
		
		return operator;
	}
	

	
	public void bufferCalculation() throws IOException {
		Main object = new Main();
		Algorithm calculate = new Algorithm();
		
		System.out.println();
		Buffer buffX = new Buffer();
		
		buffX.bufferedReader("input.txt");
		System.out.println("Here is list of data from input.txt file");
		for(int x=0;x<buffX.valueN();x++) {
			object.extractionPoint(buffX.splitArrayBufferData(x));
			
			object.getOperands(buffX.splitArrayBufferData(x));
			object.getOperator(buffX.splitArrayBufferData(x));
			
			calculate.operationCalculate(object.operands, object.operator);
			
			System.out.println("Expression : "+buffX.splitArrayBufferData(x));
			System.out.println("Result :"+calculate.result);
			System.out.println();
		}
	}
	
	public void inputCalculation() {
		// Created an object
		Algorithm calculate = new Algorithm();
		Main object = new Main();

		input2 = new Scanner(System.in);
		// Keep asking user for input if inputExpression, max 10
		do {
			System.out.println("Please enter a mathematical expression, with postfix");
			
			object.inputExpression[noOfExpression] = input2.nextLine();
			
			noOfExpression++;
		}while(noOfExpression<2);
		
		for(int read=0;read<noOfExpression;read++) {
			try {
				object.extractionPoint(object.inputExpression[read]);
				
				// Operation to get the operands and operators
				object.getOperands(object.inputExpression[read]);
				object.getOperator(object.inputExpression[read]);
	
				// Operation to calculate from the algorithm
				calculate.operationCalculate(object.operands, object.operator);
				System.out.println(calculate.result);
			}catch(NullPointerException e) {
				System.out.println(e);
			}
		}

	}
	
	public static void main(String[] args) throws IOException {
		Main object = new Main();

		input = new Scanner(System.in);
		System.out.println("Please choose an option:\n1.Calculate from file\n2.Calculate from keyboard input");
		int option = input.nextInt();
		
		switch(option) {
		case 1:
			object.bufferCalculation();
			break;
		case 2:
			object.inputCalculation();
			break;
		default:
			System.out.println("Wrong option!");
		}
		
	}

}
