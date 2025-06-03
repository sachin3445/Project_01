package mtheodOverRiding;

class abc{
	void m1(int a)
	{
		System.out.println(a);
	}

	void m2(int x, int y) {
		System.out.println(x+y);
	}
}

class xyz extends abc{
	void m2(int x, int y)
	{
		System.out.println(x*y);
	}
	
	void m1 (int a, int b) {
		System.out.println(a + "&" +b);
	}
}



public class OverloadingVSOverrinding {

	public static void main(String[] args) {

 xyz ob=new xyz();
 ob.m1(20);
 ob.m2(20, 30);
 ob.m1(30, 50); 

	}

}
