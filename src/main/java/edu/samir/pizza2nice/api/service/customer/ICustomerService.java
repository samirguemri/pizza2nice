package edu.samir.pizza2nice.api.service.customer;

import edu.samir.pizza2nice.model.Bill;
import edu.samir.pizza2nice.model.Customer;
import edu.samir.pizza2nice.model.LocalUniqueId;

import java.util.List;

public interface ICustomerService {
    Customer getCustomerById(LocalUniqueId customerId);
    Customer getCustomerByName(String firstName, String lastName);
    List<Customer> getCustomers();
    List<Customer> getCustomersByZipCode(String zipCode);
    void addNewCustomer(Customer customer);
    void updateCustomerAddressById(LocalUniqueId id, String newAddress, String newZipCode);
    void addBillForCustomerById(LocalUniqueId refBill, LocalUniqueId customerId);
    List<Bill> getCustomerBillsById(LocalUniqueId customerId);
    void updateLoyaltyPointsByCustomerId(LocalUniqueId customerId, int wonPoints);
    void deleteCustomerById(LocalUniqueId customerId);
}
