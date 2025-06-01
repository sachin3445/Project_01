package OopsConcepts.Polymorphism;

// Method Overloading

public class adder {

	int a=10, b=30;
	void sum()
	{
		System.out.println("Total of a & b:" + (a+b));
	}
	
	void sum (int x, int y)
	{
		System.out.println("Total of x & y:" +(x+y));
	}
	
	void sum(int x, double y)
	{
		System.out.println("Total of x & y:" +(x+y));
	}
	
	void sum(double x, double y)
	{
		System.out.println("Total of x & y:" +(x+y));
	}
	
	void sum(int x, int y, int z)
	{
		System.out.println("Total of x, y & z:" +(x+(y+z)));
	}

}


