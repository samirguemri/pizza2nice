package edu.samir.pizza2nice.api.dao;

import edu.samir.pizza2nice.model.*;

import java.sql.SQLException;
import java.util.Map;

public interface IDatabaseConnexion {
    public void connectToDatabase() throws SQLException;
    public void closeDatabaseConnection() throws SQLException;
}
/*
    Map<String, Admin> getAdminTable();
    Map<LocalUniqueId, Bill> getBillTable();
    Map<LocalUniqueId, Customer> getCustomerTable();
    Map<String, DeliveryMan> getDeliveryManTable();
    Map<String, Dessert> getDessertTable();
    Map<String, Drink> getDrinkTable();
    Map<String, Pizza> getPizzaTable();
    Map<String,Scooter> getScooterTable();
*/