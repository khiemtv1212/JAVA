import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		Manager m = new Manager();
		m.loadFromFile();
		m.addPerson();
		m.display();
		m.saveToFile();
	}
}
