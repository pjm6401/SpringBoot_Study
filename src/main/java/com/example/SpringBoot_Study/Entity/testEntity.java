package com.example.SpringBoot_Study.Entity;


import org.springframework.stereotype.Service;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Service
@Entity
@Table(name = "test")
public class testEntity<T> {
    @Id
    private String id;

    private String pw;

    public testEntity() {
    }

    public String getId() {
        return id;
    }

    public String getPw() {
        return pw;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    @Override
    public String toString() {
        return "testEntity{" +
                "id=" + id +
                ", pw=" + pw +
                '}';
    }
}
