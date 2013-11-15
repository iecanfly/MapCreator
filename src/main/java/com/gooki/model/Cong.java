package com.gooki.model;


import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "cong")
public class Cong extends BaseObject implements Serializable {
    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
    private Long id;

    @Column(name = "name",nullable = false, length = 100)
    private String name = "";

    @Column(name = "center_coord", nullable = false, length = 45)
    private String centerCoord;

    @Column(name = "zoom_level", nullable = false, length = 45)
    private String zoomLevel;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_cong",
            joinColumns = { @JoinColumn(name = "cong_id") },
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<User> users = new HashSet<User>();


    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCenterCoord(String centerCoord) {
        this.centerCoord = centerCoord;
    }

    public void setZoomLevel(String zoomLevel) {
        this.zoomLevel = zoomLevel;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCenterCoord() {
        return centerCoord;
    }

    public String getZoomLevel() {
        return zoomLevel;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

    public boolean equals(Object o) {
        return EqualsBuilder.reflectionEquals(this, o);
    }

    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }
}
