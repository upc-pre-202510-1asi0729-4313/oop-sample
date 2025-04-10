package com.acme.oop;

import com.acme.oop.crm.domain.model.aggregates.Customer;
import com.acme.oop.sales.domain.model.aggregates.SalesOrder;
import com.acme.oop.sales.domain.model.valueobjects.ProductId;
import com.acme.oop.shared.domain.model.valueobjects.Address;
import com.acme.oop.shared.domain.model.valueobjects.Money;

import java.math.BigDecimal;
import java.util.Currency;

/**
 * Main entry point for the OOP Sample application
 *
 * @author Open Source Application Development Team
 * @version 1.0.0
 */
public class Main {
    public static void main(String[] args) {

        Address address = new Address("123 main st", "springfield", "123", "USA");
        Customer customer = new Customer("John", "Smith", address);
        Address anotherAddress = new Address("456 main st", "springfield", "213", "USA");
        customer.setAddress(anotherAddress);

        SalesOrder order = new SalesOrder(customer.getId());
        Money price = new Money(new BigDecimal("29.99"), Currency.getInstance("USD"));
        ProductId productId = new ProductId();
        order.addItem(productId, 3, price);

        System.out.println("Curstomer: " + customer.getName());
        System.out.println("Order total: " + order.getTotalAmount().amount() + " " +
                order.getTotalAmount().currency());
    }
}
