package edu.samir.pizza2nice.api.service.bill;

import edu.samir.pizza2nice.api.dao.fake.bill.IBillDao;
import edu.samir.pizza2nice.model.Bill;
import edu.samir.pizza2nice.model.LocalUniqueId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("BillService")
public class BillServiceImpl implements IBillService {

    private final IBillDao billDao;

    @Autowired
    public BillServiceImpl(@Qualifier("FakeBillDao")IBillDao billDao) {
        this.billDao = billDao;
    }

    @Override
    public void addBill(Bill bill) { billDao.insertNewBill(bill);}

    @Override
    public Bill getBillByRef(LocalUniqueId billRef) { return billDao.selectBillByRef(billRef); }

    @Override
    public List<Bill> getBills() { return billDao.selectBills(); }

    @Override
    public List<Bill> getBillsByCustomerId(LocalUniqueId customerId) { return billDao.selectBillsByCustomerId(customerId); }

    @Override
    public void updateBillByRef(LocalUniqueId billRef, Bill updateBill) { billDao.updateBillByRef(billRef,updateBill); }

    @Override
    public void printBillByRef(LocalUniqueId billRef) {
        // TO DO
    }

    @Override
    public void billToPdfByRef(LocalUniqueId billRef) {
        // TO DO
    }

    @Override
    public void sendBillByRef(LocalUniqueId billRef) {
        // TO DO
    }
}
