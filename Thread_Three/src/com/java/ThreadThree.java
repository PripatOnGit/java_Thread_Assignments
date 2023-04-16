//Consider the following series x = 1+1/1! +1/2! + 1/3! + ………1/10! Create two threads t1 & t2. 
//t1 will generate the denominators and t2 will form the term and add them up. Finally print the result.

package com.java;

class ThreadOne extends Thread {
	synchronized static void printSeries() {
		
			for(int i=1;i<=10;i++) {
				if(i==1) {
					System.out.print("1 ");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else
					{System.out.print("1/"+i);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				} 
			}
		}
	
	public void run() {
		 printSeries();
	}
}

class ThreadTwo extends Thread {
	synchronized static void printSeries() {
		for(int i=1;i<=10;i++) {
			if(i==1) {
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					}
				}
			else{
				System.out.print("! + ");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				}
			} 
		}
	}
	public void run() {
		 printSeries();
	}
}
public class ThreadThree extends Thread {
	public static void main(String[] args) {
		ThreadOne t1 = new ThreadOne();
		ThreadTwo t2 = new ThreadTwo();
		
		t1.start();
		t2.start();
	}

}