package com.acme.oop.sales.domain.model.aggregates;

import com.acme.oop.sales.domain.model.valueobjects.ProductId;
import com.acme.oop.shared.domain.model.valueobjects.CustomerId;
import com.acme.oop.shared.domain.model.valueobjects.Money;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.function.Function;

@Getter
public class SalesOrder {
    private final UUID id;
    private final CustomerId customerId;
    private final LocalDateTime orderDate;
    private final List<SalesOrderItem> items;
    private Money totalAmount;

    public SalesOrder(CustomerId customerId) {
        if (customerId == null) {
            throw new IllegalArgumentException("Customer ID cannot be null");
        }

        this.id = UUID.randomUUID();
        this.customerId = customerId;
        this.orderDate = LocalDateTime.now();
        this.items = new ArrayList<>();
        this.totalAmount = Money.zero();
    }

    public void addItem(ProductId productId, int quantity, Money unitPrice) {
        if (productId == null) {
            throw new IllegalArgumentException("Product ID cannot be null");
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero");
        }
        if (unitPrice.amount().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Unit price must be positive");
        }

        SalesOrderItem item = new SalesOrderItem(productId, quantity, unitPrice);
        items.add(item);
        totalAmount = calculateTotalAmount();

    }

    public Money calculateTotalAmount(){
        return items.stream()
                .map( x -> x.calculateSubTotal())
                .reduce(Money.zero(), Money::add);
    }

}
