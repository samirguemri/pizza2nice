package edu.samir.pizza2nice.model;

public abstract class Person {

    protected String firstName;
    protected String lastName;
    protected String address;
    protected String zipCode;

    public String getFirstName() { return firstName; }

    public String getZipCode() {
        return zipCode;
    }

    public String getLastName() { return lastName; }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
