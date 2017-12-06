/**
 * A class implementing a Priority Queue using single linked chain
 */

public class LinkedPriorityQueue<T extends Comparable<? super T>> implements PriorityQueueInterface<T> {
	// member variables
	private Node frontNode;
	private Node backNode;
	private int size;

	LinkedPriorityQueue() {
		frontNode = null;
		backNode = null;
		size = 0;
	}

	/** Adds a new entry to this priority queue.
	 @param newEntry  An object to be added. */
	public void add(T newEntry) {
		Node newNode = new Node(newEntry, null);
		
		if(isEmpty()) { // if queue is empty
			frontNode = newNode;
			backNode = newNode;
		}
		else if(newNode.getData().compareTo(backNode.getData()) >= 0) { // if priority is lower than or equal to end of queue
			backNode.setNextNode(newNode);
			backNode = newNode;
		}
		else if (newNode.getData().compareTo(frontNode.getData()) <= 0) { // if priority higher than front of queue
			newNode.setNextNode(frontNode);
			frontNode = newNode;
		}
		else if(newNode.getData().compareTo(backNode.getData()) < 0){ // if priority is higher than end of queue
			Node currentNode = frontNode;
			
			System.out.println("ELSE ");
			
			for(int i = 0; i <= size; i++) {
				if (newNode.getData().compareTo(currentNode.getData()) > 0) {
					newNode.setNextNode(currentNode.getNextNode());
					currentNode.setNextNode(newNode);
					break;
				}
				
				currentNode.setData(currentNode.getNextNode().getData());
				currentNode.setNextNode(currentNode.getNextNode());
				
				System.out.println("ELSE WHILE");
			}
			
		}
		
		size++;
	}

	/** Removes and returns the entry having the highest priority.
	 @return  Either the object having the highest priority or,
	 if the priority queue is empty before the operation, null. */
	public T remove() {
		if (isEmpty())
			return null;
		else {
			size--;
			
			T highestPriority = frontNode.getData();
			
			frontNode.setData(null);
			frontNode = frontNode.getNextNode();
			
			if(frontNode == null)
				backNode = null;
			
			return highestPriority;
		}
	}

	/** Retrieves the entry having the highest priority.
	 @return  Either the object having the highest priority or,
	 if the priority queue is empty, null. */
	public T peek() {
		if (isEmpty())
			return null;
		else
			return frontNode.getData();
	}

	/** Detects whether this priority queue is empty.
	 @return  True if the priority queue is empty, or false otherwise. */
	public boolean isEmpty() {
		return frontNode == null && backNode == null;
	}

	/** Gets the size of this priority queue.
	 @return  The number of entries currently in the priority queue. */
	public int getSize() {
		return size;
	}

	/** Removes all entries from this priority queue. */
	public void clear() {
		frontNode = null;
		backNode = null;
		size = 0;
	}
	
	/** Node class */
	private class Node {
		private T data;
		private Node next; // next node
		
		Node(T newEntry, Node next) {
			this.data = newEntry;
			this.next = next;
		}
		
		T getData() {
			return data;
		}
		
		void setData(T newData) {
			data = newData;
		}
		
		Node getNextNode() {
			return next;
		}
		
		void setNextNode(Node newNode) {
			next = newNode;
		}
	}

}
