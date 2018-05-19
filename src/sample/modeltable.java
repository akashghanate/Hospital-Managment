package sample;

import javafx.beans.property.SimpleStringProperty;

public class modeltable {
    String firstname,dob,blood,disease,user,pass,lastname;
    int age,phone;

    public modeltable(String Username,String pass,String firstname,String lastname,int age,String dob,String blood,String disease,int phone){
        this.firstname=firstname;
        this.lastname=lastname;
        this.user=Username;
        this.pass=pass;
        this.blood=blood;
        this.disease=disease;
        this.dob=dob;
        this.age=age;
        this.phone=phone;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getBlood() {
        return blood;
    }

    public void setBlood(String blood) {
        this.blood = blood;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }
}
