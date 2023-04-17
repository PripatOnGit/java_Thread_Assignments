/*Consider a file that contains a number of integers. Create two threads. Call them ‘producer’ and ‘consumer’ threads. 
Producer thread will be reading the integers from the file continuously while consumer thread will add them up. 
Use a proper synchronization mechanism if needed.
 */
package com.java;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class ThreadOne extends Thread{
	String name;
	int num;
	ThreadOne(String name){
		this.name = name;
	}
	
	public void readInteger() throws IOException {
		
		File newFile = new File("D:\\Priyanka\\WEB_DEV\\Java_Thread_Assignaments\\ThreadFour\\src\\com\\java\\integerFile2.txt");
		newFile.createNewFile();
		
		File myObj = new File("IntegerFile.txt");
		Scanner sc = new Scanner(myObj);
		while(sc.nextInt()) {
		FileWriter myWriter = new FileWriter("integerFile2.txt");
		myWriter.write(num);
		}
	}
	public void run() {
		try {
			readInteger();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
class ThreadTwo extends Thread {
	String name;
	ThreadTwo(String name){
		this.name = name;
	}
	
	public int sumIntegers() {
		return 0;
		
	}
	
	public void run() {
		sumIntegers();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

public class ThreadFour {
	public static void main(String[] args) {
		ThreadOne t1 = new ThreadOne("producer thread");
		ThreadTwo t2 = new ThreadTwo("consumer thread");
		t1.start();
		t2.start();
	}
}
