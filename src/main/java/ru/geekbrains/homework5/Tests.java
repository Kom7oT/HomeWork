package ru.geekbrains.homework5;

import ru.geekbrains.homework5.model.Student;

import org.hibernate.SessionFactory;
import ru.geekbrains.homework5.repository.StudentRepository;
import ru.geekbrains.homework5.repository.StudentRepositoryImpl;
import ru.geekbrains.homework5.service.StudentService;

import java.util.ArrayList;
import java.util.List;

public class Tests {
    private StudentService studentService;

    public Tests() {
        SessionFactory factory = SessionFactoryHibernate.getSessionFactory();
        StudentRepository studentRepository = new StudentRepositoryImpl(factory);
        studentService = new StudentService(studentRepository, factory);
    }

    public void start(){
        for (int i = 0; i < 999; i++) {
            studentService.saveOrUpdate((long) i,"Student_"+i, (int) (Math.random() * 10));
        }
   studentService.printAll();

        studentService.deleteById(777L);
        studentService.saveOrUpdate(555L, "John", 3);
        studentService.printAll();
    }
}
