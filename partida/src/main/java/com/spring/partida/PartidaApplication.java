package com.spring.partida;


import com.spring.partida.models.Partida;
import com.spring.partida.models.User;
import com.spring.partida.repository.PartidaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.LongStream;

@SpringBootApplication
public class PartidaApplication {

	public static void main(String[] args) { SpringApplication.run(PartidaApplication.class, args);
	}

//	@Bean
//	CommandLineRunner init(PartidaRepository pr){
//		return args -> {
//			pr.deleteAll();
//			LongStream.range(1,11)
//					.mapToObj(i -> {
//						Partida p = new Partida();
//
//					})
//		}
//	}

}
