package org.jpwh.model.associations.onetoone.sharedprimarykey;

import javax.persistence.*;

// p. 213
@Entity
@Table(name = "USERS")
public class User {

    @Id
    protected Long id;

    protected String username;

    @OneToOne( // p. 213
        fetch = FetchType.LAZY,  // Defaults to EAGER p. 213
        optional = false // Required for lazy loading with proxies! p. 213
    )
    @PrimaryKeyJoinColumn // p. 213
    protected Address shippingAddress;

    protected User() {
    }

    public User(Long id, String username) { // p. 213
        this.id = id;
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }
    // ...
}
