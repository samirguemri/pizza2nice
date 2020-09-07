package edu.samir.pizza2nice.api.dao.fake.bill;


import edu.samir.pizza2nice.model.Bill;
import edu.samir.pizza2nice.model.LocalUniqueId;

import java.time.LocalDateTime;
import java.util.List;

public interface IBillDao {
    void insertNewBill(Bill newBill);
    Bill selectBillByRef(LocalUniqueId billRef);
    List<Bill> selectBills();
    List<Bill> selectBillsByCustomerId(LocalUniqueId customerId);
    List<Bill> selectBillsByDate(LocalDateTime date);
    void updateBillByRef(LocalUniqueId billRef, Bill updateBill);
    void deleteBillByRef(LocalUniqueId billRef);
    void deleteBillsByCustomerId(LocalUniqueId customerId);
}
