package edu.samir.pizza2nice.api.dao.fake.customer;

import edu.samir.pizza2nice.api.dao.fake.FakeDatabaseConnexionImpl;
import edu.samir.pizza2nice.model.Bill;
import edu.samir.pizza2nice.model.Customer;
import edu.samir.pizza2nice.model.LocalUniqueId;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository("FakeCustomerDao")
public class FakeCustomerDaoImpl extends FakeDatabaseConnexionImpl implements ICustomerDao {

    public FakeCustomerDaoImpl() {
        super();
        connectToDatabase();
    }

    @Override
    public Customer selectCustomerById(LocalUniqueId customerId) {
        return customerTable.get(customerId);
    }

    @Override
    public Customer selectCustomerByName(String firstName, String lastName) {
        Iterator<Customer> customerIterator = customerTable.values().iterator();
        while (customerIterator.hasNext()) {
            Customer customer = customerIterator.next();
            if(customer.getFirstName().equals(firstName) && customer.getLastName().equals(lastName))
                return customer;
        }
        return null;
    }

    @Override
    public List<Customer> selectCustomers() { return  new ArrayList<>(customerTable.values()); }

    @Override
    public List<Customer> selectCustomersByZipCode(String zipCode) {
        List<Customer> customers = new ArrayList<>();
        Iterator<Customer> customerIterator = customerTable.values().iterator();
        while (customerIterator.hasNext()) {
            Customer customer = customerIterator.next();
            if(customer.getZipCode().equals(zipCode) )
                customers.add(customer);
        }
        return customers;
    }

    @Override
    public void insertNewCustomer(Customer newCustomer) { customerTable.put(newCustomer.getId(),newCustomer); }

    @Override
    public void updateCustomerAddressById(LocalUniqueId customerId, String newAddress, String newZipCode) {
        Customer customer = customerTable.get(customerId);
        customer.setAddress(newAddress);
        customer.setZipCode(newZipCode);
        customerTable.put(customerId,customer);
    }

    @Override
    public void insertBillForCustomerById(LocalUniqueId customerId, LocalUniqueId billRef) {
        Customer customer = customerTable.get(customerId);
        customer.getBills().add(billTable.get(billRef));
        customerTable.put(customerId,customer);
    }

    @Override
    public List<Bill> selectCustomerBillsById(LocalUniqueId customerId) { return customerTable.get(customerId).getBills(); }

    @Override
    public void updateLoyaltyPointsById(LocalUniqueId customerId, int wonPoints) {
        Customer customer = customerTable.get(customerId);
        customer.setBonus(wonPoints);
        customerTable.put(customerId,customer);
    }

    @Override
    public void deleteCustomerById(LocalUniqueId customerId){
        customerTable.remove(customerId);
    }
}
