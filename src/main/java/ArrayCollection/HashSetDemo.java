package ArrayCollection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class HashSetDemo {

	public static void main(String[] args) {

		//Declaration of Hashset 
		//HashSet hs=new HashSet();
		HashSet <Object> hs=new HashSet<Object>();
		//HashSet<String> hs1=new HashSet<String>();
		
		//Adding values in hashset
		hs.add(100);
		hs.add(123.32);
		hs.add(null);
		hs.add(100);
		hs.add('h');
		hs.add("Sachin");
		hs.add(null);
		
		//Print all data of Hashset
		System.out.println("Print data from HashSet: "+hs);
		
		//Remove data element from hashset
		hs.remove(123.32);
		System.out.println("Print data from HashSet after removed: "+hs);
		hs.add(40.25);
		System.out.println("Print data from HashSet: "+hs);
		
		//Size of hash set
		System.out.println("Size of hashset: "+hs.size());
		
		//Access the data from specific position
		
		//convert HaseSet to ArrayList
		ArrayList aList=new ArrayList(hs);
		System.out.println("After converting in to ArrayList: "+aList);
		System.out.println("Get value at 3rd position: "+aList.get(2));
		
		//Read the HashSet using enhance for loop
		System.out.print("Values in HashSet: ");
		for (Object y:hs)
		{ 
			System.out.print(y+ ", ");
		}
		
		//Read the HashSet using Iterator
				Iterator it=hs.iterator();
				while(it.hasNext())
				{
					System.out.println(it.next());
				}
				
		//Clear the HashSet
				hs.clear();
				System.out.println(hs.isEmpty());
	}

}
