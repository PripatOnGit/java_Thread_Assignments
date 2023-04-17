/* Consider a file that contains a number of integers. Create two threads. 
 * Call them ‘producer’ and ‘consumer’ threads. 
 * Producer thread will be reading the integers from the file continuously while consumer thread will add them up.
 * Use a proper synchronization mechanism if needed.
 */

package com.java;

class PC {
	public void produce() throws InterruptedException {
		synchronized(this) {
		
			System.out.println("Producer thread running");
			wait();
			System.out.println("Producer thread resume");
			
			}
		}
	
	public void consume() throws InterruptedException {
		Thread.sleep(1000);
		synchronized(this) {
			
			System.out.println("Consumer Thread running");
			notify();
			Thread.sleep(2000);
		}
	}
}

public class InterThreadComm{
	public static void main(String[] args) throws InterruptedException {
		final PC pc = new PC();
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				try {
					pc.produce();
				} catch (InterruptedException e) {
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