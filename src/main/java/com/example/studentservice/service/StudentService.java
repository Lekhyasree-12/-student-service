package com.example.studentservice.service;
import com.example.studentservice.dto.StudentRequest; import com.example.studentservice.entity.Student; import com.example.studentservice.exception.ResourceNotFoundException; import com.example.studentservice.repository.StudentRepository; import org.springframework.data.domain.Sort; import org.springframework.stereotype.Service; import java.util.List;
@Service public class StudentService {
 private final StudentRepository repo; public StudentService(StudentRepository repo){this.repo=repo;}
 public Student create(StudentRequest r){return repo.save(new Student(r.name(),r.email(),r.department(),r.year()));}
 public List<Student> all(){return repo.findAll(Sort.by("id"));} public Student get(Long id){return repo.findById(id).orElseThrow(()->new ResourceNotFoundException("Student not found"));}
 public Student update(Long id,StudentRequest r){Student s=get(id);s.setName(r.name());s.setEmail(r.email());s.setDepartment(r.department());s.setYear(r.year());return repo.save(s);} public void delete(Long id){repo.delete(get(id));}
}
