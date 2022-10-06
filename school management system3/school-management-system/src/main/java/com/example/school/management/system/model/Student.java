package com.example.school.management.system.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Student")
@Setter
@Getter
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(nullable = false,name = "FirstName")
    private String firstName;
    @Column(nullable = false, name = "LastName")
    private String lastName;
    @Column(columnDefinition = "TEXT",name = "content")
    private String content;
    @Column(unique = true,nullable = false)
    private String email;

    public Student(Long id, String firstName, String lastName, String content, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.content = content;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", content='" + content + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
