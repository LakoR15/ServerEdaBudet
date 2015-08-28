package model;

import javax.persistence.*;
import java.security.acl.Owner;
import java.sql.Timestamp;

@Entity
@Table(name = "Orders", indexes = {
        @Index(columnList = "addDatetime", name="idx_orders_addDateTime"),
        @Index(columnList = "killDateTime", name="idx_orders_killDateTime")
})
public class Order {

    public Order(List list, User owner, Product product, Status status, Integer numbers) {
        this.list = list;
        this.owner = owner;
        this.product = product;
        this.status = status;
        this.numbers = numbers;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "listId")
    private List list;

    @ManyToOne
    @JoinColumn(name = "ownerId")
    private User owner;

    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "statusId")
    private Status status;

    @Column(name = "addDateTime")
    private Timestamp addDatetime;

    @Column(name = "killDateTime")
    private Timestamp killDatetime;

    @Column(name = "numbers")
    private Integer numbers;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Timestamp getAddDatetime() {
        return addDatetime;
    }

    public void setAddDatetime(Timestamp addDatetime) {
        this.addDatetime = addDatetime;
    }

    public Timestamp getKillDatetime() {
        return killDatetime;
    }

    public void setKillDatetime(Timestamp killDatetime) {
        this.killDatetime = killDatetime;
    }

    public Integer getNumbers() {
        return numbers;
    }

    public void setNumbers(Integer numbers) {
        this.numbers = numbers;
    }
}
