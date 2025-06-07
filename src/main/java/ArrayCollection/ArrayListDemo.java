package ArrayCollection;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListDemo {

	public static void main(String[] args) {

		ArrayList <Object> myList=new ArrayList<Object>(); //Declaration of Array
		//add element in array
		myList.add(110);
		myList.add('s');
		myList.add(null);
		myList.add("Sachin");
		myList.add("Trupti");
		myList.add(null);
		myList.add(110);
		
		// size of array
		System.out.println(myList.size());
		//get value at position 3
		System.out.println(myList.get(4));
		myList.add(7,"Sachit");
		System.out.println("List of all object: "+myList); 
		myList.remove(5);
		System.out.println("List of all object after remover object at position 5: "+myList);
		ArrayList myList2=new ArrayList();
		myList2.add("Sachin");
		myList2.add(null);
		
		myList.removeAll(myList2);
		System.out.println("List of all object after remover object at position 5: "+myList);
		
		//read the ArrayList using normal for loop
		System.out.println("\n"+"Using classic for loop: ");
		for (int i=0; i<myList.size(); i++)
		{
			System.out.print(myList.get(i)+ ", ");
		}
		
		//read the ArrayList using Enhance for loop
		System.out.println("\n"+"Using Enhance for Loop: ");
		for (Object x:myList)
		{
			System.out.print(x+", ");
		}
		
		//Reading data using iterator
		
		Iterator<Object> it=myList.iterator();
		System.out.println("\n"+ "Using Iterator" );
		while(it.hasNext())
		{
			System.out.print(it.next()+", ");
		}
		System.out.println("");
		
		myList.clear();
		System.out.println(myList.isEmpty());
	}

	
}
