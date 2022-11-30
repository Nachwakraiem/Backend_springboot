package tn.iit;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import tn.iit.dao.ClientDaoSpringData;
import tn.iit.dao.CompteDaoSpringData;
import tn.iit.entity.Client;
import tn.iit.entity.Compte;

@SpringBootApplication
public class FirstSpringBootApplication {

	@Autowired
	CompteDaoSpringData daoCompte;
	@Autowired
	ClientDaoSpringData daoClient;

	public static void main(String[] args) {
		SpringApplication.run(FirstSpringBootApplication.class, args);

	}

}
