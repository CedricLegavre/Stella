package com.yjmp.saydrequest;

import java.util.Date;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.yjmp.saydrequest.entity.student.Student;
import com.yjmp.saydrequest.entity.student.StudentRepository;
import com.yjmp.saydrequest.region.Region;
import com.yjmp.saydrequest.region.RegionRepository;

@SpringBootApplication
public class Saydrequest3Application {

	public static void main(String[] args) {
		SpringApplication.run(Saydrequest3Application.class, args);
	}

	@Bean
	CommandLineRunner start(StudentRepository studentRepository) {
		return args -> {
			studentRepository.save(new Student(null, "dikdid", "fjqisrgdlfjqsfl", new Date()));
			studentRepository.save(new Student(null, "yjgdr", "fjqislfjqsdrgdfl", new Date()));
			studentRepository.save(new Student(null, "dikyjgjygdid", "fjqislfdrgdjqsfl", new Date()));
			studentRepository.save(new Student(null, "gyjjy", "fjqisldrfjqsfl", new Date()));
			studentRepository.findAll().forEach(System.out::println);
		};
	}

	@Bean
	CommandLineRunner startout(RegionRepository regionRepository) {
		return args -> {
			regionRepository.save(new Region(null,"toto"));		
			regionRepository.save(new Region(null,"toto"));	
			regionRepository.save(new Region(null,"toto"));	
			regionRepository.findAll().forEach(System.out::println);
		};
	}
}
