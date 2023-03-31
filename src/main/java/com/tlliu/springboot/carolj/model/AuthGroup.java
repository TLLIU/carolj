package com.tlliu.springboot.carolj.model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;

@Entity
public class AuthGroup {
    @Id
    @Column(name="GROUP_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigDecimal id;
    
    public BigDecimal getId() {
        return id;
    }


    public void setId(BigDecimal id) {
        this.id = id;
    }


    @Column(name="NAME")
    private String name;
    
    
    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    @ManyToMany(mappedBy ="groups", fetch=FetchType.LAZY)
    //@JoinTable(name="USER_AUTHGROUP", joinColumns={@JoinColumn(name="GROUP_ID")}, inverseJoinColumns={@JoinColumn(name="USER_ID")})
    private List<User> users;

    public List<User> getUsers() {
        return users;
    }


    public void setUsers(List<User> users) {
        this.users = users;
    }

    
}
