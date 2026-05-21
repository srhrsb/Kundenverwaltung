package com.brh.kundenverwaltung;

public class Customer{
   private String id;
   private String name;
   private String firstname;
   private String street;
   private String number;
   private String place;
   private String postcode;

    public Customer(String id, String name, String firstname, String street, String number, String place, String postcode) {
        this.id = id;
        this.name = name;
        this.firstname = firstname;
        this.street = street;
        this.number = number;
        this.place = place;
        this.postcode = postcode;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }
}
