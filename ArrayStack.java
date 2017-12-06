import java.util.EmptyStackException;

/**
 * A class implementing a Stack using fixed sized array
 */

public final class ArrayStack<T> implements StackInterface<T> {
	// member variables
	private static final int MAX_CAPACITY = 10; // default size of stack
	private T[] stack; // actual stack that will be created
	private int top; // top of the stack
	
	private EmptyStackException emptyStackException = new EmptyStackException(); // exception to throw of stack is empty
	
	public ArrayStack() {
		@SuppressWarnings("unchecked")
		T[] tempStack = (T[])new Object[MAX_CAPACITY]; // This is an unchecked cast
		stack = tempStack;
		top = -1;
	}
	
	/** Adds a new entry to the top of this stack.
	 @param newEntry  An object to be added to the stack. */
	public void push(T newEntry) {
		// Check if there's room to add
		if(checkCapacity()) {
			top++;
			stack[top] = newEntry;
		}
		else System.out.println("Stack is full! Can't add anymore");
		
	}
	
	/** Removes and returns this stack's top entry.
	 @return  The object at the top of the stack.
	 @throws  EmptyStackException if the stack is empty before the operation. */
	public T pop() throws EmptyStackException {
		// Check if empty
		if(isEmpty())
			throw emptyStackException;
		
		// Pop
		T topItem = stack[top];
		stack[top] = null;
		top--;
		
		return topItem;
	}
	
	/** Retrieves this stack's top entry.
	 @return  The object at the top of the stack.
	 @throws  EmptyStackException if the stack is empty. */
	public T peek() throws EmptyStackException {
		// Check if empty
		if(isEmpty())
			throw emptyStackException;
		
		// Peek
		return stack[top];
	}
	
	/** Removes all entries from this stack. */
	public void clear() {
		while (top > -1) {
			stack[top] = null;
			top--;
		}
		
		// Reset top
		top = -1;
	}
	
	/** Detects whether this stack is empty.
	 @return  True if the stack is empty. */
	public boolean isEmpty() {
		return (top < 0);
	}
	
	/** Check if there is room to add onto stack.
	 @return  True if the stack has room to add. */
	private boolean checkCapacity() {
		return (MAX_CAPACITY - top - 1 > 0);
	}
	
}
