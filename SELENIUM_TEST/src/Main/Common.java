package Main;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.FileReader;
import junit.framework.*; 

public class Common {
	// some system globals
	private static boolean sleepOn = true;	
	
	// Private sleep function, aids in laying out data in timely chunks
	protected static void Sleep(int Ms)
	{	
		if(sleepOn){
			try {
		    Thread.sleep(Ms);
			} catch(InterruptedException ex) {
				Thread.currentThread().interrupt();
			}
		}
	}
	
	protected static void Sleep(long Ms)
	{	
		if(sleepOn){
			try {
		    Thread.sleep(Ms);
			} catch(InterruptedException ex) {
				Thread.currentThread().interrupt();
			}
		}
	}
	
	////
	// Common Functions
	////
	
	// print text
	public static void print(String text){
		System.out.println(text);
		// this would make printing out a value simpler.
	}
	
	public static String helloWorld(){
		return "Hello World! \nFrom return function.";
	}
	
	//@overloads print 
	public static void print(int text){
		System.out.println(text);
		// this would make printing out a value simpler.
	}
	public static void print(float text){
		System.out.println(text);
		// this would make printing out a value simpler.
	}
	public static void print(double text){
		System.out.println(text);
		// this would make printing out a value simpler.
	}
	
	public static void printDelayed(String text, float speed){
		char[] cha = text.toCharArray();
		
		for(int x = 0; x < cha.length; x++){
			if(cha[x] == '/' && cha[x+1] == 'n' ){ System.out.println(); }
			else{
			System.out.print(cha[x]);
			}
			Sleep((long)speed);
		}
	}
	
}