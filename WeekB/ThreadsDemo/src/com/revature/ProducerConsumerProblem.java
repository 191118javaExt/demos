package com.revature;

import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;

import com.revature.threads.Consumer;
import com.revature.threads.Producer;

public class ProducerConsumerProblem {
	
	public static final int NUM_OF_PRODS = 2;
	public static final int NUM_OF_CONS = 8;

	public static void main(String[] args) throws InterruptedException {
		
		System.out.println(Thread.currentThread().getName());

		// This is the ONLY queue object in memory
		// ALL threads share this one.
		// Note that it is limited in size to ONLY 10 integers
		// The producers will have to first wait for the consumers
		// before they can continue producing
		Queue<Integer> queue = new ArrayBlockingQueue<>(10);
		
		// We create a bunch of Producer threads
		Set<Producer> producers = new HashSet<>();
		
		for(int i = 0; i < NUM_OF_PRODS; i++) {
			Producer p = new Producer();
			p.setQueue(queue);
			producers.add(p);
		}
		
		// And a bunch of Consumer threads
		Set<Consumer> consumers = new HashSet<>();
		
		for(int i = 0; i < NUM_OF_CONS; i++) {
			Consumer c = new Consumer();
			c.setQueue(queue);
			consumers.add(c);
		}
		
		// Then we start the producers first
		// Pay attention that we use the start() method
		// NOT the run() method
		for(Producer p : producers) {
			p.start();
		}

		// Wait for a moment
		Thread.sleep(200);
		
		// And then also start the consumers
		for(Consumer c : consumers) {
			c.start();
		}
		
		// At this point, the 'main' thread will end.
		// And the only threads still going are the ones we
		// created ourselves
	}
}
