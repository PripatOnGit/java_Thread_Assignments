package com.java;


class myThread  {
	int num;
	public void run(int a) {
		System.out.println("Even thread");
		for(int i=1;i<=a;) {
			System.out.println(i);
			i+=2;
		}
	};
}

class myThreadTwo extends Thread {
	int num;
	myThreadTwo(int a){
		num = a;
	}
	public void run(int a) {
		System.out.println("odd thread");
		for(int i=2;i<=a;) {
			System.out.println(i);
			i+=2;
		}
	};
}


public class ThreadTwo{
	public static void main(String[] args) {
		
		myThreadOne t1 = new myThreadOne(10);
		myThreadTwo t2 = new myThreadTwo(10);
		t1.start();
		t2.start();
		
	}
}