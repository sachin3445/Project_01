package OopsConcepts.Encapsulation;

public class CustDetails {

	public static void main(String[] args) {
		
		bankCustomer accDetails= new bankCustomer();
		accDetails.setAccNo(1236487);
		accDetails.setName("Sachin Mehetre");
		accDetails.setAccBalance(1025.36);
		
		System.out.println(accDetails.getAccNo());
		System.out.println(accDetails.getName());
		System.out.println(accDetails.getAccBalance());
		
		
		

	}

}
