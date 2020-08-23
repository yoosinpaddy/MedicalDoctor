package com.example.e_medics;

public class Doctor {
    public String Address;
    public String Email;
    public Double Latitude;
    public Double Longitude;
    public String Name;
    public String Phone;
    public String Specialization;

    public Doctor() {
    }

    public Doctor(String name, String email, String address, String phone, String specialization, Double latitude, Double longitude) {
        this.Name = name;
        this.Email = email;
        this.Address = address;
        this.Phone = phone;
        this.Specialization = specialization;
        this.Latitude = latitude;
        this.Longitude = longitude;
    }
}
