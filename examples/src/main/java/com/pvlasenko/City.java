package com.pvlasenko;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import javax.validation.constraints.NotNull;
// import javax.validation.constraints.Size;

// import org.hibernate.validator.constraints.Length;

@Embeddable
public class City {

    @NotNull
    @Column(nullable = false)
    protected String name;

    @NotNull
    // @Size(min = 1, max = 5)
    // @Length(min = 1, max = 5) // org.hibernate.validator.constraints
    @Column(nullable = false, length = 5)  // length JPWH p.130
    protected String zipCode;

    @NotNull
    @Column(nullable = false)
    protected String country;

    City() {
    }

    City(String name, String zipCode, String country) {
        this.name = name;
        this.zipCode = zipCode;
        this.country = country;
    }

}
