package com.jflex.jflexexample.slb;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntUnaryOperator;

public class SLBTestMain {
	

	
	private String[] nodes;
	
	private volatile  int index;
	
	private  int index1;
	
	private int size;
	
	 private AtomicInteger atomicInteger = new AtomicInteger(0);
	
	private List<String> list = new ArrayList<>();
	
	public SLBTestMain(int size) {
		this.size = size;
		nodes = new String[size];
		for(int i=0;i<size;i++) {
			nodes[i] = new String("node : "+i);
		}
	}
	
	
	
	
	public void add() {
		//list.add(++index1);
	}
	
	public List<String> getIndexList() {
		return this.list;
	}
	
	public  String getNextNode() {
		
//		if(++index>= size) {
//			index = 0;
//		}
		int _index = atomicInteger.updateAndGet(new IntUnaryOperator() {

			@Override
			public int applyAsInt(int operand) {
				if(++operand>=size) {
					operand = 0;
				}
				return operand;
			}
			
		});

		synchronized (list) {
			String line = "index: "+_index+","+this.nodes[_index];
			if(line ==null) {
				System.out.println("line is null");
			}else {
				list.add(line);
			}
		}

		
		//System.out.println(Thread.currentThread().getName()+" ,node: " +this.nodes[_index]);
		return this.nodes[index];
		
	}

	public static void main(String[] args) {
		
		SLBTestMain slb = new SLBTestMain(100);
		 ExecutorService executor = Executors.newFixedThreadPool(5);
		 

		// List<Future> futures = new ArrayList<Future>();
		for(int i=0;i<200;i++) {
			Future<?> future = executor.submit(new Runnable() {
					
					@Override
					public void run() {
						slb.getNextNode();
						//slb.add();
					}
				});
		//	futures.add(future);
		 }
		
//		for(Future future:futures) {
//			try {
//				future.get();
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (ExecutionException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		try {
			Thread.sleep(2000l);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<String> rs = slb.getIndexList();
		for(String v :rs) {
			System.out.println(v);
		}
	
		


	}

}
