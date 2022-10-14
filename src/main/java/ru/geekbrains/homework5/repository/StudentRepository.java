package ru.geekbrains.homework5.repository;

import ru.geekbrains.homework5.model.Student;

import java.util.List;

public interface StudentRepository {

    Student findById(Long id);
    List<Student> findAll();
    void saveOrUpdate(Student student);
    void deleteById(Long id);
}