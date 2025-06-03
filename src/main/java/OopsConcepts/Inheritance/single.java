package OopsConcepts.Inheritance;

// Single parent single child

class A
	{
		int a=150;
		void display()
		{
			System.out.println(a);
		}
	}
class B extends A
	{
		int b=250;
		void show() 
		{
			System.out.println(b);
		}
		
	}
	
	public class single {
	public static void main(String[] args) 
	{
		B bOjb=new B();
		
		System.out.println(bOjb.b);
		System.out.println(bOjb.a);
		
		bOjb.show();
		bOjb.display();
	}

}
