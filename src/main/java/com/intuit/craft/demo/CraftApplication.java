package com.intuit.craft.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class CraftApplication {

  public static void main(String[] args) {
    SpringApplication.run(CraftApplication.class, args);
  }

}

