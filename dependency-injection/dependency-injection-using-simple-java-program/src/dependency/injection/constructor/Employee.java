package dependency.injection.constructor;

public class Employee {

	String firstName;
	String lastName;
	String empCode;
	
	Address address; // HAS-A

	// Injecting Dependency using constructor
	public Employee(String firstName, String lastName, String empCode, Address address) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.empCode = empCode;
		this.address = address;
	}

	public void displayInfo() {
		System.out.println("Employee Details: "
				+ "\n\tFirst Name - " + firstName 
				+ "\n\tLastName - " + lastName 
				+ "\n\tEmployee Code - " + empCode 
				+ "\n\tAddress - \n" + address
				);
	}
	
}
