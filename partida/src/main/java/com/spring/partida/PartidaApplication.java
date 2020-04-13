package com.spring.partida;


import com.spring.partida.models.Map;
import com.spring.partida.models.Partida;
import com.spring.partida.models.User;
import com.spring.partida.repository.PartidaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.LongStream;

@SpringBootApplication
public class PartidaApplication {

	public static void main(String[] args) { SpringApplication.run(PartidaApplication.class, args);
	}

	@Bean
	CommandLineRunner init(PartidaRepository pr){
		return args -> {
			pr.deleteAll();
			LongStream.range(1,11)
					.mapToObj(i -> {
						User u = new User();
						u.setNickName("jow");
						u.setPosition("entry fragger");
						User u1 = null;
						u1.setNickName("bro");
						u1.setPosition("awp");
						Partida p = new Partida();
						p.setRegion("Brasil");
						p.setMap(Map.de_DUST2);
						List<User> list = null;
						list.add(u);
						list.add(u1);
						p.setList(list);
						return p;
					})
			.map(v -> pr.save(v))
			.forEach(System.out::println);
		};
	}

}
