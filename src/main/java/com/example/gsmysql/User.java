package com.example.gsmysql;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "users")  // If not given, use lower-cased class name as table name
// JPA auditing enables the application to automatically populates the creation date and modification date to the SQL server
// Should also enable JPA auditing in the main application
@EntityListeners(AuditingEntityListener.class)
// We don’t want the clients of the rest api to supply the createdAt and updatedAt values.
// If they supply these values then we’ll simply ignore them.
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)
public class User {
    @Id
    // `IDENTITY` is equivalent to `AUTO`,
    // `AUTO` generates a `hibernate_sequence' storing next id.
    // `IDENTITY` don't generates `hibernate_sequence`
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "name can not be blank")
    private String name;

    @NotBlank(message = "email can not be blank")
    private String email;

    // if `name` not given, use lisp-cased field name as the default column name
    @Column(name = "created_at", nullable = false, updatable = false)
    // converts the date and time values from Java Object to compatible database type and vice versa.
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Column(name = "updated_at",nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}