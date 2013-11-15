package com.gooki.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "building", uniqueConstraints = {@UniqueConstraint(columnNames = {"cong", "block", "number"})})
public class Building implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "cong", nullable = false, length = 255)
    private String cong;
    @Column(name = "block", nullable = false, length = 255)
    private String block;
    @Column(name = "number", nullable = false)
    private Integer number;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "address", nullable = false)
    private String address;
    @Column(name = "floor", nullable = false)
    private String floor;
    @Column(name = "coord", nullable = false, length = 100)
    private String coord;
    @Column(name = "note", nullable = true, length = 500)
    private String note;
    @Column(name = "recommended_worker_num")
    private Integer recommendedWorkerNum = 4; //Default card is for 4 people

    @Transient
    private Date lastWorkedDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCong() {
        return cong;
    }

    public void setCong(String cong) {
        this.cong = cong;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getCoord() {
        return coord;
    }

    public void setCoord(String coord) {
        this.coord = coord;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getRecommendedWorkerNum() {
        return recommendedWorkerNum;
    }

    public void setRecommendedWorkerNum(Integer recommendedWorkerNum) {
        this.recommendedWorkerNum = recommendedWorkerNum;
    }

    public Date getLastWorkedDate() {
        return lastWorkedDate;
    }

    public void setLastWorkedDate(Date lastWorkedDate) {
        this.lastWorkedDate = lastWorkedDate;
    }
}
