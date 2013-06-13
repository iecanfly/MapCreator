package com.gooki.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "record")
public class Record implements Serializable {

    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
    public Long id;
    @Column(name = "cong", nullable = false, length = 255)
    public String cong;
    @Column(name = "block", nullable = false, length = 255)
    public String block;
    @Column(name = "number", nullable = false)
    public Integer number;
    @Column(name = "work_date", nullable = false)
    public Date workDate;
    @Column(name = "initial", nullable = false, length = 5)
    public String initial;
    @Column(name = "return_date", nullable = false)
    public Date returnDate;
}
