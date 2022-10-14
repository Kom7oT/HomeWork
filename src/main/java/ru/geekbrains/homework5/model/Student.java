package ru.geekbrains.homework5.model;

import javax.persistence.*;

@Entity
@Table(name = "students")
@NamedQueries({
        @NamedQuery(name = "deleteById", query = "delete from Student s where s.id = :id")
})
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name = "mark")
    private int mark;

    public Student() {
    }

    public Student(Long id, String name, Integer mark) {
        this.id = id;
        this.name = name;
        this.mark = mark;
    }

    public Student(String name, Integer mark) {
        this.name = name;
        this.mark = mark;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student {id= " + id + ", name= " + name + ", mark= " + mark + "}";
    }
}
