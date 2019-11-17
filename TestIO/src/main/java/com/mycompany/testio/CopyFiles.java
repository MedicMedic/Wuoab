/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.testio;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author anthony
 */
public class CopyFiles {

	public static void main(String[] args) {
		FileInputStream input = null;
		FileOutputStream output = null;
		FileReader fr = null;
		BufferedReader br = null;
		PrintWriter outputStream = null;
		int b;
		ArrayList<Character> temp = new ArrayList<Character>();
		try {
			outputStream = new PrintWriter(new FileOutputStream("input.txt"));
			input = new FileInputStream("input.txt");
			output = new FileOutputStream("output.txt");
			fr= new FileReader("input.txt");
			br = new BufferedReader(fr);

			outputStream.println("aB-12c");
			outputStream.println("de* +f");
			outputStream.close();
			String line = null;
			while((line=br.readLine())!=null){
				for(int i = line.length() - 1; i >= 0; i-- ){
					Character c = line.charAt(i);
				if((c<=90 && c >= 65) || (c <= 120 && c>= 97)){
					c = Character.toUpperCase(c);
					output.write(c);				}
				}	
				output.write('\n');
			}
			input.close();
			output.close();

		} catch (IOException e) {
			System.out.println("Error " + e.getMessage());
		} 
	}
}
