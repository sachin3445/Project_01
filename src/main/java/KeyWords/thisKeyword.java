package KeyWords;

public class thisKeyword {
	
	int a, b;
	
	thisKeyword(int a, int b)
	{
		this.a=a;
		this.b=b;
	}
	
	void display()
	{
		System.out.println(a + " " + b);
	}
	
	public static void main(String[] args) {

		thisKeyword th=new thisKeyword(50, 150);
		th.display();

	}

}
