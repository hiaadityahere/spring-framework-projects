package dependency.injection.setter;

public class Employee {

	String firstName;
	String lastName;
	String empCode;
	
	Address address; // HAS-A

	public Employee(String firstName, String lastName, String empCode) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.empCode = empCode;
	}

	// Injecting Dependency using setter
	public void setAddress(Address address) {
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
