
public class Test {
	
	/**********************************************
	 
	 This is a sample test main() for Person. It should output:
	 
	 false
	 true
	 true
	 
	 and then throw a RuntimeException (see the comments).
	 
	 *************************************************/
	
	public static void main(String[] args) {
		
		Person first = new Person("Kim");
		Person second = new Person("Pat");
		
		System.out.println(first.knows(second));   // should print "false"
		
		first.meet(second);
		
		System.out.println(first.knows(second));   // should print "true"
		System.out.println(second.knows(first));   // should print "true"
		
		first.knows(first);                    // should throw a RuntimeException
	}
	
}
