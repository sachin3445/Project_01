package ArrayCollection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapDemo {

	public static void main(String[] args) {
	
		//Declaration of HashMap
		
		//HashMap<Object, Object> hm2=new HashMap<Object, Object>();
		HashMap <Integer, String> hm=new HashMap<Integer, String>();
		
		//Adding values in HashMap
		hm.put(101, "Sachin");
		hm.put(102, "Trupti");
		hm.put(103, "Sachin");
		hm.put(104, "Vijay");
		hm.put(106, "Kaushllya");
		hm.put(105, "Sachit");
		
		
		//Print all data of HashMap
		System.out.println("All values in HashMap: "+hm);
		
		//Remove data element from HashMap
		hm.remove(103);
		System.out.println("All values in HashMap after removing 103: "+hm);
		
		//Size of HashMap
		System.out.println("Size of HashMap: "+hm.size());
		
		//Read HashMap data using Keys
		System.out.println("Read the data using keys: "+hm.keySet());
		
		//Read HashMap data using values
		System.out.println("Read the data using values: "+hm.values());
		
		//Read the HashMap data using Key& Values
		System.out.println("Read the HashMap using Kays  Values: "+hm.entrySet());
		
		//Read the HashMap using enhance for loop
		for(int x:hm.keySet())
		{
		System.out.println("Key: "+ x + " " + "Values: "+ hm.get(x));		
		}
		
		//Read the HashMap using Iterator
			Iterator <Entry<Integer, String>> it= hm.entrySet().iterator();
			while(it.hasNext())
			{
				System.out.println(it.next());
			}
		
		//Clear the HashMap
		
			hm.clear();
			System.out.println(hm.isEmpty());

	}

}
