package edu.samir.pizza2nice.exceptions;

public class NotFoundStudentException extends Exception {
    public NotFoundStudentException() {
        super("Object within this ID is NOT exist !!");
    }
}
