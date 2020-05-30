package com.example.myfirebase;


public class Grades {

    private String Name ;
    private int Quarter ;
    private String Subject;
    private int Grade ;
    private boolean isActive;

    public Grades(){

    }

    public Grades (String name, int Qua, String Sub, int grade, boolean isActive ){
        Name = name;
        Quarter = Qua;
        Subject = Sub;
        Grade = grade;
        this.isActive = isActive;
    }

    public int getQuarter() {
        return Quarter;
    }

    public String getName() {
        return Name;
    }

    public String getSubject() {
        return Subject;
    }

    public int getGrade() {
        return Grade;
    }

    public boolean isActive() {
        return isActive;
    }
}
