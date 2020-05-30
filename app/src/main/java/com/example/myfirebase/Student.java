package com.example.myfirebase;


public class Student {
    private   String Name;
    private   String Address;
    private   String PHONE_NUM;
    private   String HOME_NUM;
    private   String FATHER_NAME;
    private   String MOTHER_NAME;
    private   String MOM_NUM;
    private   String DAD_NUM;
    private   boolean isActive;

    public Student(){

    }
    public Student(String Name,String Address, String PHONE_NUM,  String HOME_NUM,String FATHER_NAME,String MOTHER_NAME, String MOM_NUM, String DAD_NUM,  boolean isActive ){
        this.Name = Name;
        this.Address = Address;
        this.PHONE_NUM = PHONE_NUM;
        this.HOME_NUM = HOME_NUM;
        this.FATHER_NAME = FATHER_NAME;
        this.MOTHER_NAME = MOTHER_NAME;
        this.MOM_NUM = MOM_NUM;
        this.DAD_NUM = DAD_NUM;
        this.isActive = isActive;
    }

    public String getName() {
        return Name;
    }

    public String getAddress() {
        return Address;
    }

    public String getHOME_NUM() {
        return HOME_NUM;
    }

    public String getPHONE_NUM() {
        return PHONE_NUM;
    }

    public String getFATHER_NAME() {
        return FATHER_NAME;
    }

    public String getMOTHER_NAME() {
        return MOTHER_NAME;
    }

    public String getMOM_NUM() {
        return MOM_NUM;
    }

    public String getDAD_NUM() {
        return DAD_NUM;
    }

    public boolean isActive() {
        return isActive;
    }
}
