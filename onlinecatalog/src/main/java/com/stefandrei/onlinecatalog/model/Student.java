package com.stefandrei.onlinecatalog.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Student {
    private String firstName;
    private String lastName;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentId;
    @ManyToOne(fetch = FetchType.LAZY)
    private SchoolGroup schoolGroup;

    @ManyToMany
    @JoinTable(name = "students_grade" , joinColumns = @JoinColumn (name="student_id") , inverseJoinColumns = @JoinColumn(name = "grade_id"))
    private List<Grade> grades;

    @ManyToMany
    @JoinTable(name = "students_discipline" , joinColumns = @JoinColumn (name="student_id") , inverseJoinColumns = @JoinColumn(name = "discipline_id"))
    private List<Discipline> disciplines;

}
