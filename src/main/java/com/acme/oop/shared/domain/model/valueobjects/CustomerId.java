package com.acme.oop.shared.domain.model.valueobjects;

import java.util.UUID;

public record CustomerId (UUID value){

    public CustomerId{
        if (value == null) {
            throw new IllegalArgumentException("Customer ID must not be null");
        }
    }

    public CustomerId(){
        this(UUID.randomUUID());
    }

}
