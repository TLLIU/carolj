package com.tlliu.springboot.carolj.model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
//mport javax.persistence.ManyToOne;

@Entity
public class User {
    @Id
    @Column(name="USER_ID")
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

    //@ManyToOne(optional=false)
    //@JoinColumn(name="COUNTRY")
    @Column(name="COUNTRY")
    private Integer country;

    public Integer getCountry() {
        return country;
    }

    public void setCountry(Integer country) {
        this.country = country;
    }

    @Column(name="MAIL_ADDRESS")
    private String mailAddress;

    public String getMailAddress() {
        return mailAddress;
    }

    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }

    @Column(name="PHONE_NUMBER")
    private String phoneNumber;

  public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    //  @ManyToMany(mappedBy ="groups", fetch=FetchType.LAZY)
    @ManyToMany
    @JoinTable(name="USER_AUTHGROUP", joinColumns={@JoinColumn(name="USER_ID")}, inverseJoinColumns={@JoinColumn(name="GROUP_ID")})
    private List<AuthGroup> groups;

    public List<AuthGroup> getGroups() {
        return groups;
    }

    public void setGroups(List<AuthGroup> groups) {
        this.groups = groups;
    }
    
}
