package edu.samir.pizza2nice.api.controller.bill;

import edu.samir.pizza2nice.api.service.bill.BillServiceImpl;
import edu.samir.pizza2nice.model.Bill;
import edu.samir.pizza2nice.model.LocalUniqueId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/pizza2nice/bill")
public class BillController {

    private final BillServiceImpl billService;

    @Autowired
    public BillController(@Qualifier("BillService") BillServiceImpl billService) {
        this.billService = billService;
    }

    void addBill(Bill bill ){
        billService.addBill(bill);
    }

    List<Bill> getBills(){
        return billService.getBills();
    }

    Bill getBillByRef(LocalUniqueId billRef){
        return billService.getBillByRef(billRef);
    }

    List<Bill> getBillsByCustomerId(LocalUniqueId customerId){
        return billService.getBillsByCustomerId(customerId);
    }

    void updateBillByRef(LocalUniqueId billRef, Bill updateBill){
        billService.updateBillByRef(billRef,updateBill);
    }

    void printBillByRef(LocalUniqueId billRef){
        billService.printBillByRef(billRef);
    }

    void billToPdfByRef(LocalUniqueId billRef){
        billService.billToPdfByRef(billRef);
    }

    void sendBillByRef(LocalUniqueId billRef){
        billService.sendBillByRef(billRef);
    }

}
