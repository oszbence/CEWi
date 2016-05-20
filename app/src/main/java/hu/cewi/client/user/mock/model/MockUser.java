package hu.cewi.client.user.mock.model;

import com.orm.dsl.Table;

/**
 * Created by Bence on 2016.05.05..
 */
@Table
public class MockUser {
    private Long id;

    String name;
    String email;

    public MockUser() {

    }

    public MockUser(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public Long getId() {
        return id;
    }
}
