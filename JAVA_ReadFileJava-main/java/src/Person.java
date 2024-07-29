
public class Person {
	private String name;
	private int age;
	private double salary;

	public Person() {

	}

	public Person(String name, int age, double salary) {
		super();
		this.name = name;
		this.age = age;
		this.salary = salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getSalary() {
		return salary;
	}

	@Override
	public String toString() {
		return String.format("%-10s | %-4d | %-7.1f", name, age, salary);
	}
}
