package com.usman.crypto;

import java.io.BufferedReader;
import java.io.Console;
import java.io.InputStreamReader;
import java.util.Scanner;

import com.usman.crypto.ciphers.VigenereCipher;

/**
 * Hello world!  vvv 
 *
 */
public class App {
	public static void main(String[] args) throws Exception{	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int x=checkInput(args);
		String result="";
		String key;
		
		if(x!=-1) {
			
			VigenereCipher vc=new VigenereCipher();
			
			Scanner sc = new Scanner(System.in); // System.in is a standard input stream
			printString("Enter characters for key: ");
			String k = br.readLine();
			printString("\nEnter text: ");
			String pt = br.readLine();
			
			if(x==0) {
				result=vc.encrypt(pt, k);
	
			}
			else {
				result=vc.decrypt(pt, k);
			}
			printString("");
			printString("Key: "+vc.getKey());
			printString("Result: "+result);
			
			
		}
	}
	
	private static int checkInput(String[] args) {
		
		if(args.length==0||(!args[0].equalsIgnoreCase("-e")&&!args[0].equalsIgnoreCase("-d"))) {
			printString("USAGE:  App  -e | -d ");
			printString("-e for encryption");
			printString("-d for decryption ");
			return -1;
		}
		
		if (args[0].equalsIgnoreCase("-e")) {
			return 0;
		}
		else {
			return 1;
		}

	}
	
	private static void printString(String s) {
		System.out.println(s);
	}
}

