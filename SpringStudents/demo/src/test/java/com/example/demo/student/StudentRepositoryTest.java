package com.example.demo.student;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.Optional;

import static java.time.Month.JANUARY;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StudentRepositoryTest {

    @Autowired
    private StudentRepository underTest;

    @Test
    void itShouldFindStudentByEmail() {
        //given
        String email = "mariam@gmail.com";
        Student student = new Student(
                "Mariam",
                "mariam@gmail.com",
                LocalDate.of(2000, JANUARY, 5)
        );
        underTest.save(student);
        //when
       Optional expected = underTest.findStudentByEmail(email);

        //then
        assertThat(expected).isPresent();

    }
}