package KeyWords;

public class staticKeyword {

	static int a=20;
	int b=15;
	
	static void m1()
	{
		System.out.println("This is static method");
	}
	
	void m2()
	{
		System.out.println("This is non static method");
	}
	
	public static void main(String[] args) {
		
	/*	System.out.println("This is static: "+a);
		m1();
	*/	
		staticKeyword sk=new staticKeyword();
		System.out.println("This is non static :"+ sk.b);
		sk.m2();

	}

}
