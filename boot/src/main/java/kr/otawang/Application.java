package kr.otawang;

import kr.otawang.model.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import kr.otawang.repository.UserRepository;

@SpringBootApplication
public class Application {
	
	private static final Logger log = LoggerFactory.getLogger(Application.class);
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(UserRepository repository) {
		
		return args -> {
			repository.save(new User(0, "David Seo", "sdw1211", "sdw1q2w3e4", "ROLE_READER"));
			repository.save(new User(0, "David Seo", "sdw1212", "sdw1q2w3e4", "ROLE_ADMIN"));
			repository.save(new User(0, "David Seo", "sdw1213", "sdw1q2w3e4", "ROLE_ADMIN"));
			
			for(User user : repository.findAll()) {
				log.info(user.toString());
			}
		};
	}
}
