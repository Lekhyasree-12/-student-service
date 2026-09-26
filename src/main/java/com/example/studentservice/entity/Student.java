package com.example.studentservice.entity;
import jakarta.persistence.*;
@Entity @Table(name="students") public class Student {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @Column(nullable=false) private String name; @Column(nullable=false, unique=true) private String email;
 @Column(nullable=false) private String department; @Column(nullable=false) private Integer year;
 protected Student() {} public Student(String name,String email,String department,Integer year){this.name=name;this.email=email;this.department=department;this.year=year;}
 public Long getId(){return id;} public String getName(){return name;} public void setName(String v){name=v;} public String getEmail(){return email;} public void setEmail(String v){email=v;} public String getDepartment(){return department;} public void setDepartment(String v){department=v;} public Integer getYear(){return year;} public void setYear(Integer v){year=v;}
}
