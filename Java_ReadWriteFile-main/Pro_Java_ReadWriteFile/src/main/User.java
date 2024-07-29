package main;

public class User {
    private String name;
    private int age;
    private double mark;
    
    public User(String name, int age, double mark) {
        this.name = name;
        this.age = age;
        this.mark = mark;
    }
    
    
    public User(){
        
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


    public double getMark() {
        return mark;
    }


    public void setMark(double mark) {
        this.mark = mark;
    }



    @Override
    public String toString() {
        return name + ";" + age + ";" + mark;
    }

}
