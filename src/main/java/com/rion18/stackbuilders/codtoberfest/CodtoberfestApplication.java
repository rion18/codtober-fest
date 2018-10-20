package com.rion18.stackbuilders.codtoberfest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.rion18.stackbuilders.codtoberfest.persistence.repository")
@EnableTransactionManagement
@EntityScan("com.rion18.stackbuilders.codtoberfest.persistence.entity")
public class CodtoberfestApplication {

  public static void main(String[] args) {
    SpringApplication.run(CodtoberfestApplication.class, args);
  }
}
