package array_questions;

public class RingBuffer<T> {
	int capacity = 0;
	T[] buffer;
	int indexOut = 0;
	int indexIn = 0;
	int count = 0;

	public RingBuffer(int capacity) {
		this.capacity = capacity;	
		buffer = (T[]) new Object[capacity];
	}
	
	public void push(T item) {
		if (count == capacity) {
			throw new RuntimeException("Ring buff overflow");
		}
		
		buffer[indexIn] = item;
		indexIn = (indexIn +1) % capacity;
		count++;
	}
	
	public T pop() {
		if (isEmpty()) {
			throw new RuntimeException("Buff underflow");
		}
		T item = buffer[indexOut];
		
		indexOut = (indexOut +1) %capacity;
		count--;
		
		return item;
	}
	
	public boolean isEmpty() {
		return count == 0;
	}
	
	public int size() {
		return count;
	}
	
	public void printBuff() {
		System.out.println("out buff: ");
		for(T i : buffer) {
			System.out.print(i + " ");
		}
	}
	
	public static void main(String[] args) {
		RingBuffer<Integer> obj = new RingBuffer<Integer>(5);
		obj.push(2);
		obj.push(4);
		obj.push(5);
		obj.push(1);
		obj.push(8);
		System.out.println("pop: " +obj.pop());
		System.out.println("pop: " +obj.pop());
		System.out.println("pop: " +obj.pop());
		obj.printBuff();	
	}	
}
