package dependency.injection.setter;


public class Driver {

	public static void main(String[] args) {
		
		Employee employee = new Employee("Charlie", "Delta", "E-123");
		
		Address address = new Address("5th Main", "23rd Cross", "Near Police station", "Bengaluru", "5600XX", "India");
		employee.setAddress(address); // Injecting Dependency using Constructor - Mandatory
		employee.displayInfo();
		
		Address address1 = new Address("KK Apartment, CP Street", "15th Main Road", "Near Nicco Park", "Hyderabad", "X600XX", "India");
		// setter-injection is mutable - after creation, we can change the address
		employee.setAddress(address1);
		
		employee.displayInfo();

	}

}
