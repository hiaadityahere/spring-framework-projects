package dependency.injection.constructor;

public class Driver {

	public static void main(String[] args) {
		
		Address address = new Address("25th Main", "16th Cross", "Near Watertank", "Bengaluru", "5600XX", "India");
		// Injecting Dependency using Constructor - Mandatory
		Employee employee = new Employee("Alpha", "Beta", "E-123", address);
		
		employee.displayInfo();
		
	}

}
