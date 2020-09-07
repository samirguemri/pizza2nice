package edu.samir.pizza2nice.api.dao.fake;

import edu.samir.pizza2nice.api.dao.IDatabaseConnexion;
import edu.samir.pizza2nice.model.*;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("FakeDatabase")
public class FakeDatabaseConnexionImpl implements IDatabaseConnexion {

    protected final Map<String, Admin> adminTable;
    protected final Map<LocalUniqueId, Order> orderTable;
    protected final Map<LocalUniqueId, Item> itemTable;
    protected final Map<String, Dessert> dessertTable;
    protected final Map<String, Drink> drinkTable;
    protected final Map<String, Pizza> pizzaTable;
    protected final Map<LocalUniqueId, Customer> customerTable;
    protected final Map<String, DeliveryMan> deliveryManTable;
    protected final Map<String,Scooter> scooterTable;
    protected final Map<LocalUniqueId, Bill> billTable;

    public FakeDatabaseConnexionImpl() {
        adminTable = new HashMap<>();
        orderTable = new HashMap<>();
        billTable = new HashMap<>();
        itemTable = new HashMap<>();
        customerTable = new HashMap<>();
        deliveryManTable = new HashMap<>();
        dessertTable = new HashMap<>();
        drinkTable = new HashMap<>();
        pizzaTable = new HashMap<>();
        scooterTable = new HashMap<>();
    }

    @Override
    public void connectToDatabase() {
        createAdminTable();
        createCustomerTable();
        createDeliveryManTable();
        createPizzaTable();
        createDessertTable();
        createDrinkTable();
        createScooterTable();
        createBillTable();
    }

       private void createDrinkTable() {
        drinkTable.put("B_Eau05cl", new Drink("Eau 50cl","Bouteille d'eau 0.5L",1.5));
        drinkTable.put("B_Eau1.5l", new Drink("Eau 1.5l","Bouteille d'eau 1.5L",2.5));
        drinkTable.put("B_Soda33", new Drink("Soda 33cl","Canette de Soda 33cl",2));
        drinkTable.put("B_Soda1.5l", new Drink("Soda 1.5l","Bouteille de Soda  1.5L",3));
        drinkTable.put("B_EauPétillante50cl", new Drink("Eau Pétillante 50cl","Bouteille d'eau gazeuse 0.5L",2));
        drinkTable.put("B_EauPétillante1.5l", new Drink("Eau Pétillante 1.5l","Bouteille d'eau gazeuse 1.5L",3));
    }

    private void createScooterTable() {
        scooterTable.put("AB-703-FR", new Scooter("AB-703-FR",true));
        scooterTable.put("CF-012-TN", new Scooter("CF-012-TN",true));
        scooterTable.put("FG-548-IT", new Scooter("FG-548-IT",true));
        scooterTable.put("EB-276-DX", new Scooter("EB-276-DX",true));
        scooterTable.put("XI-980-ES", new Scooter("XI-980-ES",true));
    }

    // A rectifier .. constructeur Pizza pour List des ingredients
    private void createPizzaTable() {
        pizzaTable.put("P_Margherita",new Pizza("Margherita","Description Pizza Margherita",7));
        pizzaTable.put("P_4XFromages",new Pizza("4 Fromages","Description Pizza 4XFromages",10));
        pizzaTable.put("P_Végétarienne",new Pizza("Végétarienne","Description Pizza Végétarienne",9));
        pizzaTable.put("P_Orientale",new Pizza("Orientale ","Description Pizza Orientale",9));
        pizzaTable.put("P_ChèvreMiel",new Pizza("Chèvre Miel \n","Description Pizza ChèvreMiel",10));
        pizzaTable.put("P_Suprême",new Pizza("Suprême","Description Pizza Suprême",12));
        pizzaTable.put("P_Campagnarde",new Pizza("Campagnarde","Description Pizza Campagnarde",10));
        pizzaTable.put("P_Mexicaine",new Pizza("Mexicaine","Description Pizza Mexicaine",10));
        pizzaTable.put("P_SpicyHotOne",new Pizza("SpicyHotOne","Description Pizza SpicyHotOne",8));
        pizzaTable.put("P_Provençale",new Pizza("Provençale","Description Pizza Provençale",12));
        pizzaTable.put("P_Nordique",new Pizza("Nordique","Description Pizza Nordique",11));
        pizzaTable.put("P_Perso",new Pizza("Perso","Description Pizza Personaliser",14));
    }

    private void createDessertTable() {
        dessertTable.put("D_IceCream", new Dessert("IceCream","IceCream Description",4));
        dessertTable.put("D_CheeseCake", new Dessert("CheeseCake","CheeseCake Description",3));
        dessertTable.put("D_BreadSticksX2", new Dessert("BreadSticks X2","BreadSticksX2 Description",2));
        dessertTable.put("D_DonutsX4", new Dessert("Donuts X4","DonutsX4 Description",2));
        dessertTable.put("D_Tiramisu", new Dessert("Tiramisu","Tiramisu Description",2.5));
        dessertTable.put("D_Brownie", new Dessert("Brownie","Brownie Description",3));
        dessertTable.put("D_Cookies", new Dessert("Cookies","Cookies Description",1.5));
    }

    private void createDeliveryManTable() {
        deliveryManTable.put("JohanDupont", new DeliveryMan("Johan","Dupont","Nice","06000"));
        deliveryManTable.put("ThomaFari", new DeliveryMan("Thoma","Fari","Nice","06100"));
        deliveryManTable.put("AdrienDima", new DeliveryMan("Adrien","Dima","Nice","06200"));
        deliveryManTable.put("FloLemer", new DeliveryMan("Flo","Lemer","Nice","06300"));
    }

    private void createCustomerTable() {
        LocalUniqueId id = LocalUniqueId.randomUniqueId();
        customerTable.put(id, new Customer(id,"Michel","Lepoint","76 Rue Vernier","06000",""));
        id = LocalUniqueId.randomUniqueId();
        customerTable.put(id, new Customer(id,"Suzane","delhoa","58 Rue Etienne Brun","06700",""));
        id = LocalUniqueId.randomUniqueId();
        customerTable.put(id, new Customer(id,"Mamadou","Colibaly","63 Boulevard Gorbella","06100",""));
        id = LocalUniqueId.randomUniqueId();
        customerTable.put(id, new Customer(id,"Philippe","Garnier","6 Impasse des Cèdres","06800",""));
        id = LocalUniqueId.randomUniqueId();
        customerTable.put(id, new Customer(id,"Marco","Dasilva","3 Rue Cais de Pierlas","06300",""));
        id = LocalUniqueId.randomUniqueId();
        customerTable.put(id, new Customer(id,"Adel","Mesrati","13 Rue Bavastro","06000",""));
        id = LocalUniqueId.randomUniqueId();
        customerTable.put(id, new Customer(id,"Jeanne","Piochel","52 Avenue Georges Clemenceau","06230",""));
        id = LocalUniqueId.randomUniqueId();
        customerTable.put(id, new Customer(id,"Fatima","Mouradi","8 Avenue Durante","06000",""));
        id = LocalUniqueId.randomUniqueId();
        customerTable.put(id, new Customer(id,"Raoul","Mira","83 Rue Miollis","06000",""));
        id = LocalUniqueId.randomUniqueId();
        customerTable.put(id, new Customer(id,"Jack","Normain","108 Avenue Buenos Ayres","06000",""));
    }

    private void createBillTable() {
        // creer une facture avec 1 item = pizza nordique X1
        LocalUniqueId customerId = LocalUniqueId.randomUniqueId();
        Customer customer = new Customer(customerId,"Jacob","Normain","150 Avenue Buenos Ayres","06100","");
        customerTable.put(customerId,customer);

        LocalUniqueId orderRef = LocalUniqueId.randomUniqueId();
        Order order = new Order(customer);
        order.setOrderRef(orderRef);

        List<Item> items = new ArrayList<>();
        items.add(new Item(new Product[]{new Pizza("Nordique","Description Pizza Nordique",11)},1));

        order.setItems(items);

        orderTable.put(orderRef,order);

        Bill bill = new Bill(order, DeliveryMode.HOME_DELIVERY);
        billTable.put(bill.getBillRef(), bill);

        // creer une facture avec 1 menu = pizza nordique X1
        customerId = LocalUniqueId.randomUniqueId();
        customer = new Customer(customerId, "Raph","Zayash","83 Avenue Thiers","06000","");
        customerTable.put(customerId,customer);

        orderRef = LocalUniqueId.randomUniqueId();
        order = new Order(customer);
        order.setOrderRef(orderRef);

        items = new ArrayList<>();
        items.add(new Item(new Product[]
                {   new Pizza("Perso","Description Pizza Personaliser",14),
                    new Dessert("IceCream","IceCream Description",4),
                    new Drink("Soda 33cl","Canette de Soda 33cl",2)
                }
                ,1));

        order.setItems(items);

        orderTable.put(orderRef,order);

        bill = new Bill(order, DeliveryMode.HOME_DELIVERY);
        billTable.put(bill.getBillRef(), bill);
    }

    private void createAdminTable() {
        adminTable.put("SamirGuemri", new Admin("Samir","Guemri","Nice","06000", "samir", "guemri"));
        adminTable.put("DavidRuzo", new Admin("David","Ruzo","Antibes","06600", "davru" , "06600"));
    }

    @Override
    public void closeDatabaseConnection() { }
}
