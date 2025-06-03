package OopsConcepts.Inheritance;

//Single parent two child one after another

class parent{
	int a;
	
	void display()
	{
		System.out.println(a);
	}
}

class chiildOne extends parent{
	int b;
	void show()
	{
		System.out.println(b);
	}
}

class childTwo extends chiildOne {
	int c;
	void print()
	{
		System.out.println(c);
	}
}


public class multilevel {

	public static void main(String[] args) {

		childTwo obj=new childTwo();
		obj.a=20;
		obj.b=30;
		obj.c=45;
		
		obj.show();
		obj.display();
		obj.print();

	}

}
