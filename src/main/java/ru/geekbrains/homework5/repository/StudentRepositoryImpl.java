package ru.geekbrains.homework5.repository;
import ru.geekbrains.homework5.model.Student;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class StudentRepositoryImpl implements StudentRepository {

    private SessionFactory factory;

    public StudentRepositoryImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public Student findById(Long id) {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            Student student = session.get(Student.class, id);
            session.getTransaction().commit();
            return student;
        }
    }

    @Override
    public List findAll() {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            List<Student> studentsList = session.createQuery("from Student").list();
            session.getTransaction().commit();
            return studentsList;
        }
    }

    @Override
    public void saveOrUpdate(Student student) {
        Session session = factory.getCurrentSession();
        try {
            session.getTransaction().begin();
            if (student.getId() == null) {
                session.persist(student);
            } else {
                session.merge(student);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public void deleteById(Long id) {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            session.createQuery("delete from Student where id = :id")
                    .setParameter("id", id)
                    .executeUpdate();
            session.getTransaction().commit();
        } catch (HibernateException he) {
            he.printStackTrace();

        }
    }

}