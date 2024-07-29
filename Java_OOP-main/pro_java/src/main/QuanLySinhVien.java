package main;

import java.util.ArrayList;
import java.util.Scanner;

public class QuanLySinhVien {

    ArrayList<SinhVien> arrSV = new ArrayList<>();

    public void dockingDsSV(ArrayList<SinhVien> arrSV) {
        for (int i = 0; i < arrSV.size(); i++) {
            for (int j = 0; j < arrSV.size(); j++) {
                if (arrSV.get(i).getPointSV() < arrSV.get(j).getPointSV()) {
                    SinhVien sv = new SinhVien();
                    sv = arrSV.get(i);
                    arrSV.set(i, arrSV.get(j));
                    arrSV.set(j, sv);


                }
            }
        }
    }
    public void showListSV(ArrayList<SinhVien> arr) {
        for (int i = 0; i < arr.size(); i++) {
            arr.get(i).outputInforSV();
        }
    }

    public void inputListSV(int n) {
        for (int i = 0; i <= n; i++) {

            System.out.println("Nhập thông tin sinh viên"+i+1);
            SinhVien sv = new SinhVien();
            sv.inputInForSv();
            arrSV.add(sv);
        }

    }

    public void sortSV(ArrayList<SinhVien> arr, String name) {
        int j = 0;
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).getNameSV().lastIndexOf(name) >= 0) {
                arr.get(i).outputInforSV();
                j = 1;
            }
        }

        if (j == 0) {
            System.out.println("không tìm thấy sinh viên");
        }
    }

    public static void main(String[] args) {
        QuanLySinhVien qlsv = new QuanLySinhVien();
        Scanner input = new Scanner(System.in);

        int luachon, i = 0;
        while (i == 0) {
            System.out.println("*********************MENU*******************");
            System.out.println("MỜI BẠN LỰA CHỌN");
            System.out.println("1.Nhập Danh Sách Sinh Viên");
            System.out.println("2.Hiển Thị Thông Tin Sinh Viên");
            System.out.println("3.Sắp Xếp Danh Sách Sinh Viên");
            System.out.println("4.Tìm Kiếm Sinh Viên");
            System.out.println("5.Thoát");
            luachon = input.nextInt();
            switch (luachon) {
                case 1:
                    System.out.println("Hãy nhập danh sách sinh viên");
                    int n = input.nextInt();
                    qlsv.inputListSV(n);
                    break;
                case 2:
                    qlsv.showListSV(qlsv.arrSV);
                    break;
                case 3:
                    qlsv.dockingDsSV(qlsv.arrSV);
                    qlsv.showListSV(qlsv.arrSV);
                    break;
                case 4:
                    input.nextLine();
                    System.out.println("Nhập tên cần tìm kiếm");
                    String text = input.nextLine();
                    qlsv.sortSV(qlsv.arrSV, text);
                    break;
                case 5:
                    i = 1;
                    System.out.println("PPS");
                    break;
            }
        }
    }
}
