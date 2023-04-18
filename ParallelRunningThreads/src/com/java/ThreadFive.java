/*Consider the series 1+2+3+…+100. This can be considered as (1+3+5+…+99)+(2+4+6+…+100). 
 * Create two threads to compute two series in parallel (do not use simplified equations). Finally print the final sum.
 */


package com.java;

class Number{
	
	int[] arr = new int[99];
	int size;
	int sum;
	public void printEven() {
		 synchronized(this) {
			 System.out.print("(");
			 int i=2;
			 while(i<100) {
				 System.out.print(i+"+");
				 i+=2;
				 if(i==100) {
					 System.out.print(i);
				 }
			 arr[size++] = i;
			 sum+=i;
			 }
			System.out.println(")");
			
		 }
	 }
	 
	public void printOdd() {
		 synchronized(this) {
			 System.out.print("(");
			 int i=1;
			 while(i<99) {
				 System.out.print(i+"+");
				 i+=2;
				 if(i==99) {
					 System.out.print(i);
				 }
				 arr[size++] = i;
				 sum+=i;
			 }
			 System.out.println(")");
			 System.out.println("sum: "+sum);
		 }
	 }
	
}
public class ThreadFive {
	public static void main(String[] args) {
		
		final Number num = new Number();
		
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				num.printEven();
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				num.printOdd();
			}
		});
		
		t1.start();
		t2.start();
	
	}
}
