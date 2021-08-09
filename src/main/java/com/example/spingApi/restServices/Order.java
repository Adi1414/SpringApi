package com.example.spingApi.restServices;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "orders")
public class Order extends RepresentationModel {
    @Id
    @GeneratedValue
    private Long id;

    @NotEmpty(message = "Order  Detail should exist")
    @Column(name = "USER_NAME", length = 50, nullable = false, unique = true)
    private String detail;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private User user;

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Order(){

    }

    public Order(Long id, String detail) {
        this.id = id;
        this.detail = detail;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", detail='" + detail + '\'' +
                '}';
    }
}
