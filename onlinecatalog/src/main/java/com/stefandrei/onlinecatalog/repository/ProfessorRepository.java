package com.stefandrei.onlinecatalog.repository;

import com.stefandrei.onlinecatalog.model.Professor;
import org.springframework.data.repository.CrudRepository;

public interface ProfessorRepository extends CrudRepository<Professor , Integer> {
}
