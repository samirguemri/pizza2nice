package edu.samir.pizza2nice.api.service.bill;

import edu.samir.pizza2nice.model.*;

import java.util.List;

public interface IBillService {
    void addBill(Bill bill );
    Bill getBillByRef(LocalUniqueId billRef);
    List<Bill> getBills();
    List<Bill> getBillsByCustomerId(LocalUniqueId customerId);
    void updateBillByRef(LocalUniqueId billRef, Bill updateBill);
    void printBillByRef(LocalUniqueId billRef);
    void billToPdfByRef(LocalUniqueId billRef);
    void sendBillByRef(LocalUniqueId billRef);
}
