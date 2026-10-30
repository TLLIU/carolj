package com.tlliu.springboot.carolj.model;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
//mport jakarta.persistence.ManyToOne;

@Entity
@Table(name = "USER_INFO")
public class UserInfo {
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