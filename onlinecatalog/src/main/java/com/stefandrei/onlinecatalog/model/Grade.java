package com.stefandrei.onlinecatalog.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity

public class Grade {
    private double grade;
    private Date gradeDate;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int gradeId;

}
