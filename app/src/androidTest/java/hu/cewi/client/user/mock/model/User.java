package hu.cewi.client.user.mock.model;

import com.orm.dsl.Table;

/**
 * Created by Bence on 2016.05.05..
 */
@Table
public class User {
    private Long id;

    String name;
    String email;

    public User() {

    }

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public Long getId() {
        return id;
    }
}
