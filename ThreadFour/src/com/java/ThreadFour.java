/*Consider a file that contains a number of integers. Create two threads. Call them ‘producer’ and ‘consumer’ threads. 
Producer thread will be reading the integers from the file continuously while consumer thread will add them up. 
Use a proper synchronization mechanism if needed.
 */
package com.java;

class ThreadOne extends Thread{
	String name;
	ThreadOne(String name){
		this.name = name;
	}
	
	public int readInteger() {
		
	}
	public void run() {
		readInteger();
		Thread.sleep(1000);
	}
}
class ThreadTwo extends Thread {
	String name;
	ThreadTwo(String name){
		this.name = name;
	}
	
	public int sumIntegers() {
		
	}
	
	public void run() {
		sumIntegers();
		Thread.sleep(1000);
	}
}

public class ThreadFour {
	ThreadOne t1 = new ThreadOne("producer thread");
	ThreadTwo t2 = new ThreadTwo("consumer thread");
	t1.start();
	t2.start();
	
}
