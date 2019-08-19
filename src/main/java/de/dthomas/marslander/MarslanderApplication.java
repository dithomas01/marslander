package de.dthomas.marslander;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;

@SpringBootApplication
public class MarslanderApplication {

  public static void main(String[] args) {
    SpringApplication.run(MarslanderApplication.class, args);
  }

}
