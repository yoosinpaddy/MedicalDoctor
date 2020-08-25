package com.example.e_medics;

public class PatientModel {
    String name,email, phone_no, location,  specilist="";

    public PatientModel(String name, String email, String phone_no, String location, String specilist) {
        this.name = name;
        this.email = email;
        this.phone_no = phone_no;
        this.location = location;
        this.specilist = specilist;
    }

    public PatientModel() {
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

    public String getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSpecilist() {
        return specilist;
    }

    public void setSpecilist(String specilist) {
        this.specilist = specilist;
    }
}
