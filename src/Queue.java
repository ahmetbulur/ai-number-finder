 
public class Queue {
	Object[] elements= null;
	int front=0;
	int rear =0;
	Queue(int capacity){
		elements= new Object[capacity];
	}
	
	public void Enqueue(Object data)
	{
		/*if(isFull()) {
			System.out.println("queue is full");
		}*/
		elements[rear] = data;
		rear = (rear + 1) % elements.length;
	}
	
	public Object Dequeue()
	{
		/*if(isEmpty()) {
			System.out.println("queue is empty");
		}*/
		Object data = elements[front];
		elements[front] = null;
		front = (front + 1) % elements.length;
		return data;
	}
	
	public Object Peek()
	{
	Object data = elements[front];
	return data;
	}
	
	public int Size() {
		if(front<rear)
			return rear-front;
		else if (front>rear)
			return elements.length-front+rear;
		else if(front==rear) {
			if (elements[front]==null)
				return 0;
			else 
				return elements.length;
		}
		else {System.out.println("empty"); return 0;}
	}
	
	public boolean isFull() {
		if(Size()==elements.length)
			return true;
		else
			return false;
	}
	public boolean isEmpty() {
		if(Size()==0)
			return true;
		else return false;
	}
}
