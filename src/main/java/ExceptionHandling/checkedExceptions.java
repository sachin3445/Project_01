package ExceptionHandling;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class checkedExceptions {

	public static void main(String[] args) throws FileNotFoundException, InterruptedException {

		System.out.println("This this run succssfully");
		
		@SuppressWarnings({ "unused", "resource" })
		FileInputStream file=new FileInputStream("c:/name.txt"); // throws FileNotFoundException
		
		Thread.sleep(3000);// throws InterruptedException
		
		System.out.println("This this run succssfully after expceptions");
		
	}

}
