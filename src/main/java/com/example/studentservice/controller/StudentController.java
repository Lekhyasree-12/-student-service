package com.example.studentservice.controller;
import com.example.studentservice.dto.StudentRequest; import com.example.studentservice.entity.Student; import com.example.studentservice.service.StudentService; import jakarta.validation.Valid; import org.springframework.http.HttpStatus; import org.springframework.web.bind.annotation.*; import java.util.List;
@RestController @RequestMapping("/api/students") public class StudentController {
 private final StudentService service; public StudentController(StudentService service){this.service=service;}
 @PostMapping @ResponseStatus(HttpStatus.CREATED) public Student create(@Valid @RequestBody StudentRequest r){return service.create(r);}
 @GetMapping public List<Student> all(){return service.all();} @GetMapping("/{id}") public Student get(@PathVariable Long id){return service.get(id);}
 @PutMapping("/{id}") public Student update(@PathVariable Long id,@Valid @RequestBody StudentRequest r){return service.update(id,r);}
 @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) public void delete(@PathVariable Long id){service.delete(id);}
}
