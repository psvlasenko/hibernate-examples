package com.pvlasenko;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
// import javax.persistence.Access;
// import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Embeddable;

import javax.validation.constraints.NotNull;

@Embeddable // JPWH p.122
// @Access(AccessType.PROPERTY) //optional, default the same as access type for root entity JPWH - p. 124
public class Address {

    @NotNull
    @AttributeOverrides({  // JPWH - p. 126
        @AttributeOverride(name = "name", column = @Column(name = "CITY", nullable = false)),
    })
    protected City city;

    @NotNull
    @Column(nullable = false)
    protected String street;

}
