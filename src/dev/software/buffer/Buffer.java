/*
 * @Author Mohamad Zafranudin Zafrin @ Xavier-IV
 * @Copyright 2016 Calculator
 * 
 * This class is to read the data of input file using
 * BufferedReader.
 * 
 */

package dev.software.buffer;

import java.io.*;
import java.util.Scanner;

public class Buffer {
	BufferedReader inputStream = null;
	Scanner s = null;
	private String[] splitArrayBuffer = new String[10];
	String data = null;
	int n = 0;


	public void bufferedReader(String inputPath) throws IOException	{
		try {
			
			s = new Scanner(new BufferedReader(new FileReader(inputPath)));
			s.useDelimiter("\\n");
			

			while(s.hasNext()) {
				data = s.next();
				splitArrayBuffer[n] = data;
				n++;
			}

		} 
		finally {
			if (s != null) {
				s.close();
			}
		}
		
	}
	
	public String splitArrayBufferData(int x) {
		return splitArrayBuffer[x];
	}
	
	public void showData(int x) {
		System.out.print(splitArrayBuffer[x]);
	}
	
	public int arrayLength() {
		return splitArrayBuffer.length;
	}
	
	public int valueN() {
		return n;
	}
}
