package main;

import java.util.Scanner;

public class SinhVien {
    private String nameSV;
    private int yearSV;
    private String addressSV;
    private float pointSV;


    //    hàm nhập thông tin sinh viên
    public void inputInForSv() {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập thông tin tên sing viên:");
        nameSV = input.nextLine();
        System.out.println("Nhập thông tin năm sinh viên:");
        yearSV = input.nextInt();
        input.nextLine();
        System.out.println("Nhập thông tin địa chỉ sinh viên:");
        addressSV = input.nextLine();
        System.out.println("Nhập thông tin điểm sinh viên");
        pointSV = input.nextFloat();
    }

    public void outputInforSV() {
        System.out.println("Sinh viên tên:" +" "+ nameSV+" " + "năm sinh:" +" "+ yearSV +" "+ "địa chỉ:" +" " +addressSV +" "+ "điểm:"+" " + pointSV);
    }

    public String getNameSV() {
        return nameSV;
    }

    public void setNameSV(String nameSV) {
        this.nameSV = nameSV;
    }

    public int getYearSV() {
        return yearSV;
    }

    public void setYearSV(int yearSV) {
        this.yearSV = yearSV;
    }

    public String getAddressSV() {
        return addressSV;
    }

    public void setAddressSV(String addressSV) {
        this.addressSV = addressSV;
    }

    public float getPointSV() {
        return pointSV;
    }

    public void setPointSV(float pointSV) {
        this.pointSV = pointSV;
    }

    public SinhVien() {
    }

    public SinhVien(String nameSV, int yearSV, String addressSV, float pointSV) {
        this.nameSV = nameSV;
        this.yearSV = yearSV;
        this.addressSV = addressSV;
        this.pointSV = pointSV;
    }

    @Override
    public String toString() {
        return "SinhVien{" + "nameSV='" + nameSV + '\'' + ", yearSV=" + yearSV + ", addressSV='" + addressSV + '\'' + ", pointSV=" + pointSV + '}';
    }

}
