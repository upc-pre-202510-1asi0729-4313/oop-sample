package com.acme.oop.shared.domain.model.valueobjects;

import java.math.BigDecimal;
import java.util.Currency;

public record Money(BigDecimal amount, Currency currency) {

    public Money{
        if (amount == null) throw new NullPointerException("Amount cannot be null");
        if (currency == null) throw new NullPointerException("Currency cannot be null");
        if (amount.scale() > currency.getDefaultFractionDigits())
            throw new IllegalArgumentException("Too many decimal places for currency");
    }

    public static Money zero(){
        return new Money(BigDecimal.ZERO, Currency.getInstance("USD"));
    }

    public Money add(Money other){
        if (!currency.equals(other.currency))
            throw new IllegalArgumentException("Currency does not match");

        return new Money(amount.add(other.amount), currency);
    }

    public Money multiply(int multiplier){
        return new Money(amount.multiply(BigDecimal.valueOf(multiplier)), currency);
    }
}
