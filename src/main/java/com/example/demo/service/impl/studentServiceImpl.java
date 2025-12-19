 
package com.example.demo.service.impl; 
 
import java.util.*; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service; 
 
import com.example.demo.entity.*; 
import com.example.demo.repository.*; 
import com.example.demo.service.*; 
import com.example.demo.exception.*; 
 
@Service 
public class studentServiceImpl implements studentService { 
 
    @Autowired 
    studentRepo repo; 
 
    @Override 
    public List<studentEntity> getAll() { 
        return repo.findAll(); 
    } 
 
    @Override 
    public studentEntity addStudent(studentEntity stu) { 
        return repo.save(stu); 
    } 
 
    @Override 
    public studentEntity getById(Long id) { 
        return repo.findById(id) 
            .orElseThrow(() ->  
                new ResourceNotFoundException("Student with ID "+id+" not found") 
            ); 
    } 
 
    @Override 
    public String updateStudent(Long id, studentEntity newstu) { 
        studentEntity existing = repo.findById(id) 
            .orElseThrow(() ->  
                new ResourceNotFoundException("Student with ID "+id+" not found") 
            ); 
 
        existing.setName(newstu.getName()); 
        existing.setEmail(newstu.getEmail()); 
        repo.save(existing); 
        return "Updated Successfully"; 
    } 
 
    @Override 
    public String deleteStudent(Long id) { 
        studentEntity stu = repo.findById(id) 
            .orElseThrow(() ->  
                new ResourceNotFoundException("Student with ID "+id+" not found") 
            ); 
 
        repo.delete(stu); 
        return "Deleted Successfully"; 
    } 
} 
 
 