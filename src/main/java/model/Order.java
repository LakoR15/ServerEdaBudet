package model;

import java.sql.Timestamp;

public class Order {

    public Order(Long id, Long listId, Long ownerId, Long productId, Long statusId, Integer numbers) {
        this.id = id;
        this.listId = listId;
        this.ownerId = ownerId;
        this.productId = productId;
        this.statusId = statusId;
        this.numbers = numbers;
    }

    private Long id;
    private Long listId;
    private Long ownerId;
    private Long productId;
    private Long statusId;
    private Timestamp add_datetime;
    private Timestamp kill_datetime;
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

    public Timestamp getAdd_datetime() {
        return add_datetime;
    }

    public void setAdd_datetime(Timestamp add_datetime) {
        this.add_datetime = add_datetime;
    }

    public Timestamp getKill_datetime() {
        return kill_datetime;
    }

    public void setKill_datetime(Timestamp kill_datetime) {
        this.kill_datetime = kill_datetime;
    }

    public Integer getNumbers() {
        return numbers;
    }

    public void setNumbers(Integer numbers) {
        this.numbers = numbers;
    }
}
