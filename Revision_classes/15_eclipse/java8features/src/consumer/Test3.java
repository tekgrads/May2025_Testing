package consumer;

import java.util.function.Consumer;

class Employee{
	String name;
	int exp;
	public Employee(String name, int exp) {
		this.name = name;
		this.exp = exp;
	}
}
public class Test3 {
	public static void main(String[] args) {
		Consumer<Employee> c1 = e -> System.out.print(e.name + " joined in company");
		Consumer<Employee> c2 = e -> System.out.println(" has an experience of " + e.exp + " years");
		Consumer<Employee> chainedC = c1.andThen(c2);
		Employee e1 = new Employee("Ramesh", 3);
		Employee e2 = new Employee("Suresh", 5);
		chainedC.accept(e1);
		chainedC.accept(e2);
	}
		
	}
