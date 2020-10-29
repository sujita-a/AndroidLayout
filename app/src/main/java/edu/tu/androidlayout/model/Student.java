package edu.tu.androidlayout.model;

public class Student {

    String name;
    String email;
    String address;
    String mobile;
    String salary;
    String password;

    public Student() {

    }

    public Student(String name, String email, String address, String mobile, String salary, String password) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.mobile = mobile;
        this.salary = salary;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
