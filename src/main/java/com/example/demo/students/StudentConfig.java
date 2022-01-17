package com.example.demo.students;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Student spq = new Student(
                    1L, "spqjf12345", "spqjf12345@gmail.com",
                    LocalDate.of(1999, Month.JANUARY, 18)
            );
            Student cindy = new Student(
                    1L, "cindy", "cindy@gmail.com",
                    LocalDate.of(1998, Month.FEBRUARY, 19)
            );

            repository.saveAll(
                    List.of(spq, cindy)
            );
        };


    };
}
