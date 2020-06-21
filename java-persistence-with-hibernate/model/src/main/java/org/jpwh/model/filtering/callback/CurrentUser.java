package org.jpwh.model.filtering.callback;

/**
 * p. 375
 * Thread-local
 */
public class CurrentUser extends ThreadLocal<User> {

    public static CurrentUser INSTANCE = new CurrentUser();

    private CurrentUser() {
    }
}
