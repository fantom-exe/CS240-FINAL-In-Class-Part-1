/*************************************************************************
 Winter 2017 CS 240 Programming Exam : Person
 
 Author: <Edward Isajanyan>
 
 Dependencies: Stack, Queue, Dictionary
 
 Description:  Models a person, a list of messages that they can
 read, and a list of their friends, so that when you
 post a message, all your friends can read it too.
 
 **************************************************************************/

public class Person {
	//      ASK
	// attributes
	private String name;
	private ArrayStack friends;
	private LinkedPriorityQueue messages;
//	private DictionaryArray
	
	
	
	// Create a new Person with this name.
	public Person(String name) {
		this.name = name;
	}
	
	// Make these two people become friends with each other.
	// Throw an exception if you try to meet yourself.
	// We are allowed to assume we didn't meet this person yet.
	public void meet(Person otherPerson) throws Exception {
		// meeting yourself error
		if(otherPerson.hashCode() == this.hashCode())
			throw new Exception("Cannot Meet Yourself");
		
		friends.push(otherPerson);
	}
	
	// Are these two people friends?
	// Throw an exception if you ask about knowing yourself.
	public boolean knows(Person otherPerson) throws Exception {
		// meeting yourself error
		if(otherPerson.hashCode() == this.hashCode())
			throw new Exception("Cannot Know Yourself");
		
		// check list of friends
		while (!friends.isEmpty()) {
			friends.peek();
		}
	}
	
	// Post a message to my list and the lists of all my friends
	public void post(String message) {
		messages.add(message);
		
		this.friends.peek();
	}
	
	// Print a header, then all messages this Person can read, newest first
	public void listMessages() {
		System.out.println("== The wall of Kim ==");
		System.out.println();
	}
	
}
