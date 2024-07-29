package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        Main m = new Main();
        List<User> list = m.readFromFile();
        for(User o : list){

            System.out.println(o);
        }

    }

    public void writeToFile(List<User> list) {
        try {
            FileWriter fw = new FileWriter("data.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            for (User o : list) {
                bw.write(o.toString());
                bw.newLine();
            }
            bw.close();
            fw.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public List<User> readFromFile() {
        List<User> list = new ArrayList<>();
        try {
            FileReader fr = new FileReader("data.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while (true) {
                line = br.readLine();
                if (line == null) {
                    break;
                }
                String txt[] = line.split("\\s+");
                String name = txt[0];
                int age = Integer.parseInt(txt[1]);
                double mark = Double.parseDouble(txt[2]);

                list.add(new User(name, age, mark));
                System.out.println(line);
            }

        } catch (Exception e) {
            // TODO: handle exception
        }
        return list;

    }
}
