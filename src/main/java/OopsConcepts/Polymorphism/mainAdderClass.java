package OopsConcepts.Polymorphism;

public class mainAdderClass {

	public static void main(String[] args) {

		adder addobj=new adder();
		addobj.sum();
		
		addobj.sum(30, 40);
		addobj.sum(30, 40.50);
		addobj.sum(20.23, 41.20);
		addobj.sum(10, 20, 30);

	}

}
