package com.jflex.jflexexample.queue;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.function.IntUnaryOperator;
import java.util.function.UnaryOperator;

public class LockFreeQueue<T> {
	
	/**
	 * 出列指针
	 */
	private AtomicInteger beforePointer = new AtomicInteger(0);
	
	/**
	 * 入队指针
	 */
	private AtomicInteger afterPointer = new AtomicInteger(0);
	
	/**
	 * 队列深度
	 */
	private int size = Integer.MAX_VALUE;
	
	
	private AtomicReferenceArray<T> array;
	
	private boolean full = false;
	/**
	 * 数据数组
	 */
	private Object[] objects;
	
	public LockFreeQueue() {
		this.objects = new Object[this.size];
		this.array = new AtomicReferenceArray<>(this.size);
	}
	
	
	public LockFreeQueue(int size) {
		this.size = size;
	}
	
	public boolean add(T obj) {
		
		int _index = afterPointer.updateAndGet(new IntUnaryOperator() {

			@Override
			public int applyAsInt(int operand) {
				
				int index = operand +1;
				if(index>=size) {
					index =0 ;
				}
				
				if(index == beforePointer.get()) {
					full = true;
					return operand;
				}else {
					return index;
				}
			}
			
		});
		
		array.updateAndGet(0, new UnaryOperator<T>() {

			@Override
			public T apply(T t) {
				// TODO Auto-generated method stub
				return null;
			}
			
		});
		
		array.compareAndSet(_index, null, obj);
	}

}
