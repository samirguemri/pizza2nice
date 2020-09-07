package edu.samir.pizza2nice.api.dao.fake.customer;

import edu.samir.pizza2nice.model.Bill;
import edu.samir.pizza2nice.model.Customer;
import edu.samir.pizza2nice.model.LocalUniqueId;

import java.util.List;

public interface ICustomerDao {
    void insertNewCustomer(Customer customer);
    void insertBillForCustomerById(LocalUniqueId refBill, LocalUniqueId customerId);
    Customer selectCustomerById(LocalUniqueId customerId);
    Customer selectCustomerByName(String firstName, String lastName);
    List<Customer> selectCustomers();
    List<Customer> selectCustomersByZipCode(String zipCode);
    List<Bill> selectCustomerBillsById(LocalUniqueId customerId);
    void updateCustomerAddressById(LocalUniqueId id, String newAddress, String newZipCode);
    void updateLoyaltyPointsById(LocalUniqueId customerId, int wonPoints);
    void deleteCustomerById(LocalUniqueId customerId);
}
