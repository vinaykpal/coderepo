package mix_practice;

public class RingBuffer<T> {

	int capacity;
	T[] buf;
	int count =0;
	int indexIn =0;
	int indexOut =0;
	
	public RingBuffer(int capacity) {
		// TODO Auto-generated constructor stub
		this.capacity = capacity;
		this.buf = (T[]) new Object[capacity];
	}
	
	public void push(T val) {
		buf[indexIn % capacity] = val;
		indexIn++;
		count++;
	}
	
	public T pop() {
		if (isEmpty()) {
			throw new RuntimeException("empty buffer");
		}
		T val = buf[indexOut % capacity];
		indexOut++;
		count--;
		return val;
	}
	
	boolean isEmpty() {
		return count == 0;
	}
	
	int size() {
		return count;
	}
	
	public void printBuff() {
		System.out.println("out buff: ");
		for(T i : buf) {
			System.out.print(i + " ");
		}
	}
	public static void main(String[] args) {
		RingBuffer<Integer> obj = new RingBuffer<Integer>(5);
		obj.push(1);
		obj.push(2);
		obj.push(3);
		obj.push(4);
		obj.push(5);
		obj.push(6);
		obj.push(7);
		//obj.push(8);
		System.out.println("pop: " +obj.pop());
		System.out.println("pop: " +obj.pop());
		System.out.println("pop: " +obj.pop());
		obj.printBuff();	
	}
}

