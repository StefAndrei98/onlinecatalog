package com.stefandrei.onlinecatalog.repository;

import com.stefandrei.onlinecatalog.model.SchoolGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface SchoolGroupRepository extends JpaRepository<SchoolGroup , Integer> {
}
