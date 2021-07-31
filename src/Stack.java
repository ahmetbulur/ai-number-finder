
public class Stack {
	private Object[] elements;
	private int top;

	Stack(int capacity) {
		elements = new Object[capacity];
		top = -1;
	}

	public void Push(Object data) {
		if (isFull())
			System.out.println("Stack overflow");
		top++;
		elements[top] = data;
	}

	public Object Pop() {
		if (isEmpty())
			System.out.println("Stack is Empty");
		Object data = elements[top];
		elements[top] = null;
		top--;

		return data;
	}

	public int Size() {
		return top + 1;
	}

	public boolean isFull() {
		if (elements.length == (top + 1))
			return true;
		else
			return false;
	}

	public boolean isEmpty() {
		if (top == -1)
			return true;
		else
			return false;
	}

	public Object Peek() {
		if (isEmpty())
			System.out.println("Stack is Empty");
		return elements[top];
	}

	public Object[] getElements() {
		return elements;
	}

	public void setElements(Object[] elements) {
		this.elements = elements;
	}

	public int getTop() {
		return top;
	}

	public void setTop(int top) {
		this.top = top;
	}
}
