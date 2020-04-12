package com.pvlasenko.inheritance.single_table;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.NotNull;

import com.pvlasenko.Constants;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // JPWH - p. 157
@DiscriminatorColumn(name = "DB_TYPE") // JPWH - p. 157
public abstract class BillingDetails {

    @Id
    @GeneratedValue(generator = Constants.ID_GENERATOR)
    protected Long id;

    @NotNull
    @Column(nullable = false)
    protected String owner;

}
