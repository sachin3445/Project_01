package WrapperClass.protectedPackage;

import WrapperClass.test01;

public class test02 extends test01 {

	// Protected method and variable can access within a class and outside the class, out side package using inheritance  
	public static void main(String[] args) 
	{
	
		test02 objProtectd=new test02();
		System.out.println(objProtectd.t);
		objProtectd.m6();
	}

}
