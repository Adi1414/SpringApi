package com.example.spingApi.restServices;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;
import org.springframework.hateoas.RepresentationModel;

@Entity
@Table(name = "user")
public class User extends RepresentationModel {
    @Id
    @GeneratedValue
    private Long id;

    @NotEmpty(message = "First name should exist")
    @Column(name = "USER_NAME", length = 50, nullable = false, unique = true)
    private String firstName;

    @Size(min = 2, message = "Min 2 characters should be there")
    @Column(name = "LAST_NAME", length = 50, nullable = false)
    private String lastName;

    @Column(name = "EMAIL", length = 50, nullable = false)
    private String email;

    @Column(name = "ROLE", length = 50, nullable = false)
    private String role;

    @Column(name = "SSN", length = 50, nullable = false, unique = true)
    private String ssn;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Order> orders;

    public User(){

    }

    public User(Long id, String firstName, String lastName, String email, String role, String ssn) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.role = role;
        this.ssn = ssn;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                ", ssn='" + ssn + '\'' +
                '}';
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
