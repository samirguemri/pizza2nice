package edu.samir.pizza2nice.api.dao.fake.bill;

import edu.samir.pizza2nice.api.dao.fake.FakeDatabaseConnexionImpl;
import edu.samir.pizza2nice.model.Bill;
import edu.samir.pizza2nice.model.LocalUniqueId;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository("FakeBillDao")
public class FakeBillDaoImpl extends FakeDatabaseConnexionImpl implements IBillDao {

    public FakeBillDaoImpl() {
        super();
        connectToDatabase();
    }

    @Override
    public void insertNewBill(Bill newBill) {
        billTable.put(newBill.getBillRef(),newBill);
    }

    @Override
    public Bill selectBillByRef(LocalUniqueId billRef) { return billTable.get(billRef); }

    @Override
    public List<Bill> selectBills() {
        return new ArrayList<>(billTable.values());
    }

    @Override
    public List<Bill> selectBillsByCustomerId(LocalUniqueId customerId) {
        List<Bill> customerBills = new ArrayList<>();
        for (Iterator<Bill> billIterator = billTable.values().iterator(); billIterator.hasNext(); ) {
            Bill bill = billIterator.next();
            if (bill.getCustomer().getId().equals(customerId))
                customerBills.add(bill);
        }
        return customerBills;
    }

    @Override
    public List<Bill> selectBillsByDate(LocalDateTime date) {
        List<Bill> bills = new ArrayList<>();
        Iterator<Bill> billIterator = billTable.values().iterator();
        while (billIterator.hasNext()){
            Bill bill = billIterator.next();
            if (bill.getOrderDate().equals(date))
                bills.add(bill);
        }
        return bills;
    }

    @Override
    public void updateBillByRef(LocalUniqueId billRef, Bill updateBill) {
        billTable.put(billRef,updateBill);
    }

    @Override
    public void deleteBillByRef(LocalUniqueId billRef) {
        billTable.remove(billRef);
    }

    @Override
    public void deleteBillsByCustomerId(LocalUniqueId customerId) {
        Iterator<Bill> billIterator = billTable.values().iterator();
        while (billIterator.hasNext()){
            Bill bill = billIterator.next();
            if (bill.getCustomer().getId().equals(customerId))
                billTable.remove(bill.getBillRef());
        }
    }
}
