package com.acme.oop.sales.domain.model.aggregates;

import com.acme.oop.sales.domain.model.valueobjects.ProductId;
import com.acme.oop.shared.domain.model.valueobjects.Money;
import lombok.Getter;


@Getter
public class SalesOrderItem {
    private final ProductId productId;
    private final int quantity;
    private final Money unitPrice;

    SalesOrderItem(ProductId productId, int quantity, Money unitPrice) {
        this.productId = productId;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public Money calculateSubTotal() {
        return unitPrice.multiply(quantity);
    }
}
