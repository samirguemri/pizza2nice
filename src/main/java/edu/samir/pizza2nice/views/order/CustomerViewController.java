package edu.samir.pizza2nice.views.order;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import edu.samir.pizza2nice.api.service.customer.CustomerServiceImpl;
import edu.samir.pizza2nice.api.service.dessert.DessertServiceImpl;
import edu.samir.pizza2nice.api.service.drink.DrinkServiceImpl;
import edu.samir.pizza2nice.api.service.pizza.PizzaServiceImpl;
import edu.samir.pizza2nice.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class CustomerViewController {

    private CustomerServiceImpl customerService;
    private PizzaServiceImpl pizzaService;
    private DrinkServiceImpl drinkService;
    private DessertServiceImpl dessertService;

    @Autowired
    public CustomerViewController(  @Qualifier("CustomerService") CustomerServiceImpl customerService,
                                    @Qualifier("PizzaService") PizzaServiceImpl pizzaService,
                                    @Qualifier("DrinkService") DrinkServiceImpl drinkService,
                                    @Qualifier("DessertService") DessertServiceImpl dessertService  ) {

        this.customerService = customerService;
        this.pizzaService = pizzaService;
        this.drinkService = drinkService;
        this.dessertService = dessertService;
    }

    @GetMapping("/pizza2nice/customer")
    public String customer(){
        return "customer/customer";
    }

    @GetMapping("/pizza2nice/customer/searchCustomerById")
    public String searchCustomerById(HttpServletRequest request, Model model){
        String idCustomer = request.getParameter("idCustomer");
        Customer customer = customerService.getCustomerById(new LocalUniqueId(idCustomer));
        Order order = new Order(customer);
        model.addAttribute("order", order);
        return "order/orderCustomer";
    }

    @GetMapping("/pizza2nice/customer/searchCustomerByName")
    public String searchCustomerByName(HttpServletRequest request, Model model){

        String firstName = request.getParameter("firstNameCustomer");
        String lastName = request.getParameter("lastNameCustomer");
        Customer customer = customerService.getCustomerByName(firstName,lastName);
        if(customer == null)
            return "errror";

        model.addAttribute("order", new Order(customer));
        model.addAttribute("pizzaList",pizzaService.getAllPizza());
        model.addAttribute("pasteList", Arrays.asList(Paste.values()));
        model.addAttribute("sauceList", Arrays.asList(Sauce.values()));
        model.addAttribute("ingredientList", Arrays.asList(Ingredient.values()));
        model.addAttribute("drinkList", drinkService.selectDrinks());
        model.addAttribute("dessertList", dessertService.selectDesserts());

        return "order/orderCustomer";
    }

}
