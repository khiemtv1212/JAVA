import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Manager {
	private List<Person> plist;

	public Manager() {
		plist = new ArrayList<>();
	}

	public void display() {
		if (plist.isEmpty()) {
			System.out.println("NOTHING TO DISPLAY");
			return;
		}
		for (Person u : plist) {
			System.out.print(u);
		}
	}

//	đọc file dữ liệu và add và plist
	public void loadFromFile() throws FileNotFoundException, IOException {
//		File 
//		FileReader + BufferedReader
		File f = new File("person.txt");
		if (!f.exists()) {
			System.out.println("NEW FILE IS CREATED");
			f.createNewFile();
		}

		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);
		while (true) {
			String line = br.readLine();
			if (line == null)
				break;
			String[] info = line.split("[|]");
			String name = info[0].trim();
			int age = Integer.parseInt(info[1].trim());
			double salary = Double.parseDouble(info[2].trim());
			plist.add(new Person(name, age, salary));
		}
		br.close();
		fr.close();
	}

	public void addPerson() {
		Scanner sc = new Scanner(System.in);
		String name;
		int age;
		double salary;
		System.out.print("Enter name");
		name = sc.nextLine();
		System.out.print("Enter age:");
		age = Integer.parseInt(sc.nextLine());
		System.out.print("Enter Salary");
		salary = Double.parseDouble(sc.nextLine());
		plist.add(new Person(name, age, salary));

	}

//	Từ plist sẽ được tải dữ liệu vào file
	public void saveToFile() throws IOException {
//		File 
//		FileWriter + BufferedReader
		File f = new File("person.txt");
		FileWriter fw = new FileWriter(f);
		BufferedWriter bw = new BufferedWriter(fw);
		for (Person p : plist)
			bw.write(p.toString());
		bw.close();
		fw.close();
	}
}
