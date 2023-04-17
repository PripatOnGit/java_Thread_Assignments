package com.java;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class PC{
	
	int[] num = new int[10];
	int n;
	int size;
	int sum;
	int consumed_size;
	int flag;
	
	public void print(String source) {
		System.out.println(source);
		for(int i=0; i<num.length; i++) {
			System.out.print(" " + num[i]);
		}
		System.out.println();
	}
	
	public void produce() throws InterruptedException, FileNotFoundException {
		//read from file
		synchronized(this) {
			File file = new File("../ThreadFour/src/com/java/IntegerFile");
			Scanner sc = new Scanner(file);
			flag = 1;
			while(sc.hasNextLine()) {
				n = sc.nextInt();
				System.out.println(""+ n + ", size(P) = " + size);
				num[size++] = n;  
				//wait till other thread completes execution
				print("Producer");
				notify();
				wait();
				//resume reading from file				
			}
			System.out.println("Producer completed.");
			flag = 2;
		}
	}
	
	public void consume() throws InterruptedException{
			Thread.sleep(1000);		
			int i = 0;
			synchronized(this) {				
				while(i < 100) {
					if(consumed_size < size) {
						sum += num[consumed_size];
						consumed_size++;
						System.out.println("Sum: "+sum + ", size(C) = " + consumed_size);						
					}
					//notify to producer thread to wake up and can start execution once consumer thread terminates			
					notify();	
					wait();
					i++;
				}		
				System.out.println("Consumed Exited");						
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
