package com.java;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class PC{
	
	int[] num = new int[10];
	int n;
	int size;
	int sum;
	public void produce() throws InterruptedException, FileNotFoundException {
		//read from file
		synchronized(this) {
			File file = new File("../ThreadFour/src/com/java/IntegerFile");
			Scanner sc = new Scanner(file);
			while(sc.hasNextLine()) {
				System.out.println("Produer started");
				n = sc.nextInt();
				System.out.println(""+ n + ", size(P) = " + size);
				num[size++] = n;  
				//wait till other thread completes execution
				wait();
				//resume reading from file
				System.out.println("-------------------------");
				System.out.println("producer waiting now.");
			}
		}
	}
	
	public void consume() throws InterruptedException{
		
			synchronized(this) {
				Thread.sleep(1000);
				System.out.println("Consumer started.");			
				// add values from file and get sum
				sum += num[size-1];
				System.out.println("Sum: "+sum + ", size(C) = " + size);
				//notify to producer thread to wake up and can start execution once consumer thread terminates			
				notify();				
				System.out.println("consumer notifying producer.");
		
			}
		}
	}



public class InterThreadCommunication {
	public static void main(String[] args) throws InterruptedException {
		final PC pc = new PC();
		
		Thread t1 = new Thread(new Runnable(){
			public void run() {
				try {
					pc.produce();
				} catch (InterruptedException | FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				try {
					pc.consume();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
	}
}
