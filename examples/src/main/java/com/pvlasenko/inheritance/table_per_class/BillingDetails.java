package com.pvlasenko.inheritance.table_per_class;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.NotNull;

import com.pvlasenko.Constants;

@Entity
@Inheritance(strategy = InheritanceType.JOINED) // JPWH - p. 157
public abstract class BillingDetails {

    @Id
    @GeneratedValue(generator = Constants.ID_GENERATOR)
    protected Long id;

    @NotNull
    protected String owner;

}
