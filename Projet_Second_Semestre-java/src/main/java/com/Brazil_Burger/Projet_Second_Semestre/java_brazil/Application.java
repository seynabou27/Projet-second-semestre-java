package com.Brazil_Burger.Projet_Second_Semestre.java_brazil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.Brazil_Burger.Projet_Second_Semestre.java_brazil.fixture.BurgerFixture;
import com.Brazil_Burger.Projet_Second_Semestre.java_brazil.fixture.UserFixture;

@SpringBootApplication
public class Application implements CommandLineRunner {
	@Autowired
	private BurgerFixture burgerFixture;

	@Autowired
	private UserFixture userFixture;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		//userFixture.loadDefaultGestionnaire();
		
	}

}
