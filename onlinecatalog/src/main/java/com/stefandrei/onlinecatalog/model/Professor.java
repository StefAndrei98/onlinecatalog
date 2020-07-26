package com.stefandrei.onlinecatalog.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity

public class Professor {
    private String professorFirstName;
    private String professorLastName;
    @ManyToOne(fetch = FetchType.LAZY)
    private Discipline discipline;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int professorId;
}
