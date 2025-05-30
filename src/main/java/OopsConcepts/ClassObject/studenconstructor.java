package OopsConcepts.ClassObject;

public class studenconstructor {
	
	int sID; String sName; String sBranch; char sgrade;
		
	studenconstructor(int studID, String studName, String studBranch, char grade)
	{
		sID=studID;
		sName=studName; 
		sBranch= studBranch; 
		sgrade= grade; 
	}	
	 
		void printstudData()
		{
			System.out.println("Student details: "+ "ID: "+ sID + "  "+" Name: " + sName + " "+"Branch: " +sBranch + " "+"Grade: "+ sgrade);
		}

		

}
