package edu.samir.pizza2nice.api.service.customer;

import edu.samir.pizza2nice.api.dao.fake.customer.ICustomerDao;
import edu.samir.pizza2nice.model.Bill;
import edu.samir.pizza2nice.model.Customer;
import edu.samir.pizza2nice.model.LocalUniqueId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("CustomerService")
public class CustomerServiceImpl implements ICustomerService {

    private final ICustomerDao customerDao;

    @Autowired
    public CustomerServiceImpl(@Qualifier("FakeCustomerDao")ICustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Override
    public Customer getCustomerById(LocalUniqueId customerId) {
        return customerDao.selectCustomerById(customerId);
    }

    @Override
    public Customer getCustomerByName(String firstName, String lastName) {
        return customerDao.selectCustomerByName(firstName, lastName);
    }

    @Override
    public List<Customer> getCustomers() {
        return customerDao.selectCustomers();
    }

    @Override
    public List<Customer> getCustomersByZipCode(String zipCode) {
        return customerDao.selectCustomersByZipCode(zipCode);
    }

    @Override
    public void addNewCustomer(Customer customer) {
        customerDao.insertNewCustomer(customer);
    }

    @Override
    public void updateCustomerAddressById(LocalUniqueId id, String newAddress, String newZipCode) {
        customerDao.updateCustomerAddressById(id,newAddress,newZipCode);
    }

    @Override
    public void addBillForCustomerById(LocalUniqueId refBill, LocalUniqueId customerId) {
        customerDao.insertBillForCustomerById(refBill,customerId);
    }

    @Override
    public List<Bill> getCustomerBillsById(LocalUniqueId customerId) {
        return customerDao.selectCustomerBillsById(customerId);
    }

    @Override
    public void updateLoyaltyPointsByCustomerId(LocalUniqueId customerId, int wonPoints) {
        customerDao.updateLoyaltyPointsById(customerId,wonPoints);
    }

    @Override
    public void deleteCustomerById(LocalUniqueId customerId) {
        customerDao.deleteCustomerById(customerId);
    }
}
