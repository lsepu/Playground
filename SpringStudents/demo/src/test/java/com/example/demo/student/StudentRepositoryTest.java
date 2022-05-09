package com.example.demo.student;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.Optional;

import static java.time.Month.JANUARY;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository underTest;

    @AfterEach
    void tearDown() {
        underTest.deleteAll();
    }

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