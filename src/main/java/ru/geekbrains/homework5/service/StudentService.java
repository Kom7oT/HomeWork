package ru.geekbrains.homework5.service;

import org.hibernate.SessionFactory;
import ru.geekbrains.homework5.model.Student;
import ru.geekbrains.homework5.repository.StudentRepository;

import java.util.List;

public class StudentService {
    private final StudentRepository studentRepository;
    private final SessionFactory factory;

    public StudentService(StudentRepository studentRepository, SessionFactory factory) {
        this.studentRepository = studentRepository;
        this.factory = factory;
    }

    public Student findById(Long id) {
        return studentRepository.findById(id);
    }

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public void printAll() {
        System.out.println("Полный список студентов:");
        studentRepository.findAll().forEach(System.out::println);
    }

    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }

    public void saveOrUpdate(Long id, String newName, int newMark) {
        Student student = studentRepository.findById(id);
        if (student != null) {
            student.setName(newName);
            student.setMark(newMark);
            studentRepository.saveOrUpdate(student);
        } else studentRepository.saveOrUpdate(new Student(newName, newMark));
    }
}
