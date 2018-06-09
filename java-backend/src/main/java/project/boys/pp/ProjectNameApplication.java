package project.boys.pp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjectNameApplication {

	public static void main(String[] args) {
		try {
			SpringApplication.run(ProjectNameApplication.class, args);
		}catch(Exception e){
			System.exit(1);
		}
		//any main method setup for the application
	}
}
