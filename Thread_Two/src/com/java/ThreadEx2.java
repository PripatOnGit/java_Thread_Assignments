package com.java;

class MyThread extends Thread {
	int num;
	String name;
	
	public MyThread(String name,int start) {
		this.name = name;
		num = start;
	}
	synchronized void print() {
		System.out.println("Number "+num +" " +this.name);
		this.num += 2;
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void run() {
		for(int i=0;i<2;i++) {
			print();
		}
	}
}
// Driver class
public class ThreadEx2 {
	public static void main(String[] args) throws InterruptedException {
		
		MyThread t1 = new MyThread("Even Thread",0);
		MyThread t2 = new MyThread("odd Thread",1);
		t1.start();
		t2.start(); 
		}
}
