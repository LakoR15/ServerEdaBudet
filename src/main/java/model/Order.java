package model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "Orders")
public class Order {

    public Order(Long id, Long listId, Long ownerId, Long productId, Long statusId, Integer numbers) {
        this.id = id;
        this.listId = listId;
        this.ownerId = ownerId;
        this.productId = productId;
        this.statusId = statusId;
        this.numbers = numbers;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "listId")
    private Long listId;

    @Column(name = "ownerId")
    private Long ownerId;

    @Column(name = "productId")
    private Long productId;

    @Column(name = "statusId")
    private Long statusId;

    @Column(name = "addDateTime")
    private Timestamp addDatetime;

    @Column(name = "killDatetime")
    private Timestamp killDatetime;

    @Column(name = "numbers")
    private Integer numbers;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getListId() {
        return listId;
    }

    public void setListId(Long listId) {
        this.listId = listId;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getStatusId() {
        return statusId;
    }

    public void setStatusId(Long statusId) {
        this.statusId = statusId;
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
