package com.aplication.twitter.entity.user;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(unique = true)
    private String userName;
    private String password;
    @Column( nullable = true ,unique = true)
    private String email;
    private boolean active;
    @Temporal(TemporalType.DATE)
    private Date birthOfDate;
    private String roles;

    public User(String userName, String password, String email, boolean active, Date birthOfDate, String roles) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.active = active;
        this.birthOfDate = birthOfDate;
        this.roles = roles;
    }

    public User() {

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthOfDate() {
        return birthOfDate;
    }

    public void setBirthOfDate(Date birthOfDate) {
        this.birthOfDate = birthOfDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }
}
