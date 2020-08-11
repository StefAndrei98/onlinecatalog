package com.stefandrei.onlinecatalog.service;

import com.stefandrei.onlinecatalog.model.SchoolGroup;
import com.stefandrei.onlinecatalog.model.Student;
import com.stefandrei.onlinecatalog.repository.SchoolGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("ISchoolGroupService")
public class SchoolGroupService {

    @Autowired
    private SchoolGroupRepository schoolGroupRepository;

    public List<SchoolGroup>findAll(){
       return schoolGroupRepository.findAll ();
    }

    public void save(SchoolGroup schoolgroup) {
        schoolGroupRepository.save(schoolgroup);
    }

    public SchoolGroup findById(Integer id) {
        Optional<SchoolGroup> schoolGroup = schoolGroupRepository.findById (id);
        if (schoolGroup.isPresent())
        {
            return schoolGroup.get ();
        }
        return null;
    }

    public void deleteById(Integer id) {
        schoolGroupRepository.deleteById (id);
    }

    public List<Student> findStudentByGroup(Integer id) {
       return schoolGroupRepository.findById (id).get ().getStudents ();
    }
}
