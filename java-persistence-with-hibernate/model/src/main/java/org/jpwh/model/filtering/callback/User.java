package org.jpwh.model.filtering.callback;

import org.jpwh.model.Constants;

import javax.persistence.Entity;
import javax.persistence.ExcludeDefaultListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PostPersist;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

// p.377
@Entity
@Table(name = "USERS")
@ExcludeDefaultListeners // // p.378
public class User {
    @Id
    @GeneratedValue(generator = Constants.ID_GENERATOR)
    protected Long id;

    @NotNull
    protected String username;

    protected User() {
    }

    public User(String username) {
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

    @PostPersist // p.377
    public void notifyAdmin(){
        User currentUser = CurrentUser.INSTANCE.get();
        Mail mail = Mail.INSTANCE;
        mail.send(
            "Entity instance persisted by "
                + currentUser.getUsername()
                + ": "
                + this
        );
    }


    // ...
}
