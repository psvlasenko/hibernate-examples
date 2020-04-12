package com.pvlasenko.inheritance.table_per_concrete_class;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

@MappedSuperclass // JPWH - p. 151
public abstract class BillingDetails {

    @NotNull
    protected String owner;

}
