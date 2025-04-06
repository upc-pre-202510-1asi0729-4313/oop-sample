package com.acme.oop.shared.domain.model.valueobjects;

/**
 * Represents a physical address
 * This value object is immutable and shared across bounded contexts.
 *
 * @param street
 * @param city
 * @param postalCode
 * @param country
 *
 * @author Open source Application Development TEAM
 *
 */
public record Address(String street, String city, String postalCode, String country) {

    public Address {
        if (street == null || street.trim().isEmpty()) {
            throw new IllegalArgumentException("Street cannot be null or empty");
        }
        if (city == null || city.trim().isEmpty()) {
            throw new IllegalArgumentException("City cannot be null or empty");
        }
        if (postalCode == null || postalCode.trim().isEmpty()) {
            throw new IllegalArgumentException("Postal code cannot be null or empty");
        }
        if (country == null || country.trim().isEmpty()) {
            throw new IllegalArgumentException("Country cannot be null or empty");
        }
    }



}
