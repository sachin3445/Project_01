package OopsConcepts.Inheritance;

//Single parent two childs parallels

class x{
	int a;
	void display()
	{
		System.out.println(a);
	}
}

class y extends x{
	int b;
	void shoow()
	{
		System.out.println(b);
	}
}

class z extends x{
	int c;
	void print()
	{
		System.out.println(c);
	}
}

public class hierarchy {

	public static void main(String[] args) {
		y obj =new y();
		
		obj.a=200;
		obj.b=300;
		
		obj.display();
		obj.shoow();
		
		z obj2 =new z();
		obj2.c=310;
		obj2.print();
	}

}
