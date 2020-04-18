package com.pvlasenko.converter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Currency;

class MonetaryAmount implements Serializable {

    private final Currency currency;
    private final BigDecimal value;

    public static MonetaryAmount fromString(String str) {
        var split = str.split(" ");

        return new MonetaryAmount(
            Currency.getInstance(split[0]),
            new BigDecimal(split[1])
        );
    }

    public MonetaryAmount(Currency currency, BigDecimal value) {
        this.currency = currency;
        this.value = value;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof MonetaryAmount)) return false;

        // https://github.com/microsoft/vscode-java-pack/issues/313
        // https://sandny.com/2019/10/08/enable-the-preview-feature-in-java-13-with-maven/
        // release>11</release> - java version, chek: mvn -version
        final var ma = (MonetaryAmount) obj;

        if (!ma.currency.equals(currency)) return false;
        if (!ma.value.equals(value)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return 29 * value.hashCode() + currency.hashCode();
    }

}
