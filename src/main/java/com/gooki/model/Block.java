package com.gooki.model;


import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import com.gooki.model.BaseObject;

import javax.persistence.*;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "block", uniqueConstraints = {@UniqueConstraint(columnNames = {"cong", "block", "number"})})
public class Block implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
    private Long id;
    @Column(name = "cong", nullable = false, length = 255)
    private String cong;
    @Column(name = "block", nullable = false, length = 255)
    private String block;
    @Column(name = "number", nullable = false)
    private Integer number;
    @Column(name = "coord", nullable = false, length = 2000)
    private String coord;
    @Column(name = "note", nullable = true, length = 500)
    private String note;
    @Column(name = "marker_coord", nullable = true, length = 50)
    private String markerCoord;
    @Column(name = "print_coord", nullable = true, length = 50)
    private String printCoord;
    @Column(name = "print_zoom_level", nullable = true)
    private Integer printZoomLevel;
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

    public String getMarkerCoord() {
        return markerCoord;
    }

    public void setMarkerCoord(String markerCoord) {
        this.markerCoord = markerCoord;
    }

    public String getPrintCoord() {
        return printCoord;
    }

    public void setPrintCoord(String printCoord) {
        this.printCoord = printCoord;
    }

    public Integer getPrintZoomLevel() {
        return printZoomLevel;
    }

    public void setPrintZoomLevel(Integer printZoomLevel) {
        this.printZoomLevel = printZoomLevel;
    }

    public Date getLastWorkedDate() {
        return lastWorkedDate;
    }

    public void setLastWorkedDate(Date lastWorkedDate) {
        this.lastWorkedDate = lastWorkedDate;
    }

    public Integer getRecommendedWorkerNum() {
        return recommendedWorkerNum;
    }

    public void setRecommendedWorkerNum(Integer recommendedWorkerNum) {
        this.recommendedWorkerNum = recommendedWorkerNum;
    }

    public String getLastWorkedDateString() {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return this.lastWorkedDate == null ? "" : format.format(this.lastWorkedDate);
    }

}
