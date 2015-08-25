package model;

import javax.persistence.*;
import java.util.*;


@Entity
@Table(name = "Users", indexes = {
        @Index(columnList = "name", name = "idx_users_name")
})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "secretKey", nullable = false, length = 36)
    private String secretKey;

    @ManyToMany
    @JoinTable(name = "Users_Lists",
            joinColumns = @JoinColumn(name = "userId"),
            inverseJoinColumns = @JoinColumn(name = "listId"))
    private java.util.List<List> lists;

    public User(Integer id, String name, String password) {
        this();
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public User() {
        this.secretKey = UUID.randomUUID().toString();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getSecretKey() {
        return secretKey;
    }
}
