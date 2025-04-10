package com.acme.oop.sales.domain.model.valueobjects;

import java.util.UUID;

public record ProductId(UUID value) {

    public ProductId {
        if (value == null)
            throw new IllegalArgumentException("Product id cannot be null");
    }

    public ProductId() {
        this(UUID.randomUUID());
    }
}
