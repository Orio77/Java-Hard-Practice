package oop.exercise12_objectReferences.scenario1;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private String email;
    private List<Order> orders;
    private List<Contact> contacts;

    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
        orders = new ArrayList<>();
        contacts = new ArrayList<>();
    }

    public void addOrder(Order order) {
        orders.add(order);
        order.setCustomer(this);
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
        contact.setCustomer(this);
    }

    public List<Contact> getContacts() {
        return contacts;
    }
    public List<Order> getOrders() {
        return orders;
    }
    public String getEmail() {
        return email;
    }
    public String getName() {
        return name;
    }
}
