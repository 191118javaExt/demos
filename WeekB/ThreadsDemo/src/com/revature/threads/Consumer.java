package com.revature.threads;

import java.util.Queue;

/*
 * This is one way to create a custom Thread.
 * Another way is to implement the Runnable interface.
 */
public class Consumer extends Thread {
	
	// This is the buffer that will be shared with other threads
	// Remember that all threads share the same heap
	// This means there will be only 1 queue object in memory,
	// and all threads will have a reference to that same object
	private Queue<Integer> q;

	/*
	 * Note that this is the method that the thread will execute when it is created
	 * We will not call this method directly
	 * 
	 * There is ANOTHER method called start() that we will use to actually
	 * create another thread
	 */
	@Override
	public void run() {
		
		try {
			
			while (true) {
				
				// This prevents multiple threads from accessing
				// that same queue object at the same time
				// Java will "block" the other threads while one thread
				// is using it
				synchronized (q) {
				
					while (q.isEmpty()) {
						System.out.println("Consumer " + getName() + "  falling asleep!");
						q.wait();
					}
					
					int val = q.remove();
					
					System.out.println("Reading value: " + val);
					
					q.notifyAll();
					
					Thread.sleep(4);
				}
			}
			
		} catch (InterruptedException e) { }
	}
	
	public void setQueue(Queue<Integer> q) {
		this.q = q;
	}
}
