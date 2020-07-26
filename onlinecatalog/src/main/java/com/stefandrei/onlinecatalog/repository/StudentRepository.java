package com.stefandrei.onlinecatalog.repository;

import com.stefandrei.onlinecatalog.model.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Integer> {
}
