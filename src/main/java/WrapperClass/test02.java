package WrapperClass;

public class test02 {

	// Default method and variable can access within a class and outside the class from same package 
	public static void main(String[] args) 
	{
		test01 objPublic=new test01();
		System.out.println(objPublic.a);
		objPublic.m5();
		
		test01 objProtectd=new test01();
		System.out.println(objProtectd.t);
		objPublic.m6();
	}

}
