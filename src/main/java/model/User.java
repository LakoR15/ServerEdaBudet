package model;

import java.util.UUID;

public class User {

    private Long id;
    private String name;
    private String password;
    private UUID secretKey;

    public User(Long id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.secretKey = UUID.randomUUID();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UUID getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(UUID secretKey) {
        this.secretKey = secretKey;
    }
}
