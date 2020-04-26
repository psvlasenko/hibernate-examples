package com.pvlasenko.inheritance.mixed;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.validation.constraints.NotNull;

@Entity
@DiscriminatorValue("CC")
@SecondaryTable( // p. 164
    name = "CREDITCARD",
    pkJoinColumns = @PrimaryKeyJoinColumn(name = "CREDITCARD_ID")
)
public class CreditCard extends BillingDetails {

    @NotNull
    @Column(table = "CREDITCARD", nullable = false)
    protected String cardNumber;

    @NotNull
    @Column(table = "CREDITCARD", nullable = false)
    protected String expMonth;

    @NotNull
    @Column(table = "CREDITCARD", nullable = false)
    protected String expYear;

}
