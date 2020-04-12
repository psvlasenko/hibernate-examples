package com.pvlasenko.inheritance.table_per_concrete_class_with_unions;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.NotNull;

import com.pvlasenko.Constants;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) // JPWH - p. 154
public abstract class BillingDetails {

    @Id
    @GeneratedValue(generator = Constants.ID_GENERATOR)
    protected Long id;

    @NotNull
    protected String owner;

}
