public class Test2 {
/**
	This is a sample test main() for Person. It should output:
 
			== The wall of Kim ==
	I agree
	Friends are awesome
	Only Kim can read this
			== The wall of Pat ==
	I agree
	Friends are awesome

*************************************************/
	
	public static void main(String[] args) {
		Person first = new Person("Kim");
		Person second = new Person("Pat");
		first.post("Only Kim can read this");
		
		first.meet(second);
		second.post("Friends are awesome");
		first.post("I agree");
		
		first.listMessages();
		second.listMessages();
		
	}
	
}
