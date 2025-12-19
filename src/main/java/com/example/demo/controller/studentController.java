 
package com.example.demo.controller; 
 
import java.util.List; 
import jakarta.validation.Valid; 
 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.web.bind.annotation.*; 
 
import com.example.demo.entity.*; 
import com.example.demo.service.*; 
 
@RestController 
public class studentController { 
 
    @Autowired 
    studentService service; 
 
    @GetMapping("/getAllStudent") 
    public List<studentEntity> getAll() { 
        return service.getAll(); 
    } 
 
    @PostMapping("/addStudent") 
    public studentEntity addStudent(@Valid @RequestBody studentEntity stu) { 
        return service.addStudent(stu); 
    } 
 
    @GetMapping("/student/{id}") 
    public studentEntity getById(@PathVariable Long id) { 
        return service.getById(id); 
    } 
 
    @PutMapping("/update/{id}") 
    public String updateStudent(@PathVariable Long id, @Valid @RequestBody studentEntity 
stu) { 
        return service.updateStudent(id, stu); 
    } 
 
    @DeleteMapping("/delete/{id}") 
    public String deleteStudent(@PathVariable Long id) { 
        return service.deleteStudent(id); 
    } 
} 