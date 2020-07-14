package com.example.validator;

import javax.persistence.*;

@Entity
@Table(name = "my_table")
public class MyEntity {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "role")
    @CheckRole
    private String role;

    @Column(name = "user_id")
    private int userId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

}
