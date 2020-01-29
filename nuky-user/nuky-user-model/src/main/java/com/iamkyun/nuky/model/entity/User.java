package com.iamkyun.nuky.model.entity;

import java.sql.Timestamp;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * @author kyun
 */
@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Basic
    @Column(name = "username")
    private String username;

    @Basic
    @Column(name = "create_date")
    @CreatedDate
    private Timestamp createDate;

    @Basic
    @Column(name = "email")
    private String email;

    @Basic
    @Column(name = "mobile")
    private String mobile;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof User)) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(getId(), user.getId()) &&
                Objects.equals(getUsername(), user.getUsername()) &&
                Objects.equals(getCreateDate(), user.getCreateDate()) &&
                Objects.equals(getEmail(), user.getEmail()) &&
                Objects.equals(getMobile(), user.getMobile());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUsername(), getCreateDate(), getEmail(), getMobile());
    }
}